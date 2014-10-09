package edu.cmu.lti.oaqa.gerp.uima.components;

import static java.util.stream.Collectors.toSet;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.AbstractCas;
import org.apache.uima.fit.component.JCasMultiplier_ImplBase;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.StringList;
import org.apache.uima.jcas.cas.TOP;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.CasCopier;

import edu.cmu.lti.oaqa.gerp.uima.type.Evidence;
import edu.cmu.lti.oaqa.gerp.uima.type.GeneratorInfo;
import edu.cmu.lti.oaqa.gerp.uima.type.GerpBase;
import edu.cmu.lti.oaqa.gerp.uima.type.PruningDecision;
import edu.cmu.lti.oaqa.gerp.uima.type.Rank;
import edu.cmu.lti.oaqa.gerp.uima.util.GerpUtil;

/**
 * Component that supports 4-step processing: candidate Generation -> Evidencing -> Ranking ->
 * Pruning, each of which corresponds to a reusable UIMA component with different input/output
 * capabilities. The AE descriptors should be specified in the parameters <code>generators</code>,
 * <code>evidencers</code>, <code>rankers</code>, and <code>pruners</code> as {@link StringList}. In
 * addition, the type that will be gerpped from the component should be specified by the
 * <code>type</code> parameter.
 * <p>
 * Specifically, the class defines a specific workflow to execute all the components as follows:
 * <ol>
 * <li>
 * Generators described by AEs will be executed in a random order as normal UIMA components,
 * generators are also expected to create {@link GeneratorInfo} in additional to the raw types.</li>
 * <li>
 * All raw types and types from all previous steps will then be added to the same CAS and processed
 * by each evidencer specified in <code>evidencers</code>. {@link Evidence}s are required to be
 * created for all raw input types in each evidencer.</li>
 * <li>
 * All {@link Evidence}s will be passed to each ranker specified in the <code>rankers</code> list.
 * Each ranker should be able to collect the {@link Evidence}s and group them by the raw types, and
 * produce a {@link Rank}.</li>
 * <li>
 * Finally, all {@link Rank} types are delivered to each pruner from <code>pruners</code> , and each
 * pruner should produce a {@link PruningDecision} for each raw type.</li>
 * </li>
 * <p>
 * 
 * @see {@link SequentialGerpExecutor}, {@link ParallelGerpExecutor}
 * 
 * @author Zi Yang <ziy@cs.cmu.edu>
 * 
 */
public abstract class AbstractGerpExecutor<T extends TOP> extends JCasMultiplier_ImplBase {

  protected Class<T> type;

  protected Set<AnalysisEngine> generators;

  protected Set<AnalysisEngine> evidencers;

  protected Set<AnalysisEngine> rankers;

  protected Set<AnalysisEngine> pruners;

  protected Iterator<Entry<TOP, List<GerpBase>>> iter;

  public AbstractGerpExecutor() {
    super();
  }

  @SuppressWarnings("unchecked")
  @Override
  public void initialize(UimaContext context) throws ResourceInitializationException {
    super.initialize(context);
    try {
      type = (Class<T>) Class.forName((String) context.getConfigParameterValue("type")).asSubclass(
              TOP.class);
    } catch (ClassNotFoundException e) {
      throw new ResourceInitializationException(e);
    }
    generators = createEngines((String[]) context.getConfigParameterValue("generators"));
    evidencers = createEngines((String[]) context.getConfigParameterValue("evidencers"));
    rankers = createEngines((String[]) context.getConfigParameterValue("rankers"));
    pruners = createEngines((String[]) context.getConfigParameterValue("pruners"));
  }

  private static Set<AnalysisEngine> createEngines(String[] descriptorNames) {
    return Arrays.stream(descriptorNames).map(name -> createEngine(name)).collect(toSet());
  }

  private static AnalysisEngine createEngine(String name) {
    try {
      return AnalysisEngineFactory.createEngine(name);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void process(JCas jcas) throws AnalysisEngineProcessException {
    gerp(jcas);
    // group types in jcas by raw types
    @SuppressWarnings("unchecked")
    Map<TOP, List<GerpBase>> raw2fs = Stream
            .of(GeneratorInfo.class, Evidence.class, Rank.class, PruningDecision.class)
            .flatMap(clazz -> (Stream<GerpBase>) GerpUtil.stream(jcas, clazz, type))
            .collect(Collectors.groupingBy(GerpBase::getRaw));
    iter = raw2fs.entrySet().iterator();
  }

  protected abstract void gerp(JCas jcas) throws AnalysisEngineProcessException;

  @Override
  public boolean hasNext() throws AnalysisEngineProcessException {
    return iter.hasNext();
  }

  @Override
  public AbstractCas next() throws AnalysisEngineProcessException {
    Entry<TOP, List<GerpBase>> next = iter.next();
    JCas jcas = getEmptyJCas();
    CasCopier copier = new CasCopier(next.getKey().getCAS(), jcas.getCas());
    jcas.addFsToIndexes(copier.copyFs(next.getKey()));
    next.getValue().stream().forEach(fs -> jcas.addFsToIndexes(copier.copyFs(fs)));
    return jcas;
  }

  @Override
  public void collectionProcessComplete() throws AnalysisEngineProcessException {
    super.collectionProcessComplete();
    Stream.of(generators, evidencers, rankers, pruners).flatMap(aes -> aes.stream())
            .forEach(ae -> collectionProcessComplete(ae));
  }

  private static void collectionProcessComplete(AnalysisEngine ae) {
    try {
      ae.collectionProcessComplete();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}