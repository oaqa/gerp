package edu.cmu.lti.oaqa.gerp.executor;

import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.cmu.lti.oaqa.gerp.model.CollectiveEvidencer;
import edu.cmu.lti.oaqa.gerp.model.CollectivePruner;
import edu.cmu.lti.oaqa.gerp.model.CollectiveRanker;
import edu.cmu.lti.oaqa.gerp.model.Evidence;
import edu.cmu.lti.oaqa.gerp.model.Generator;
import edu.cmu.lti.oaqa.gerp.model.IndependentEvidencer;
import edu.cmu.lti.oaqa.gerp.model.IndependentPruner;
import edu.cmu.lti.oaqa.gerp.model.IndependentRanker;
import edu.cmu.lti.oaqa.gerp.model.PruningDecision;
import edu.cmu.lti.oaqa.gerp.model.Rank;

/**
 * An interface that defines how to gerp types from components that complete generation, evidencing,
 * ranking, and pruning phase. Each of G/E/R and P components need to implement specific interfaces
 * ({@link Generator}, {@link CollectiveEvidencer} or {@link IndependentEvidencer},
 * {@link CollectiveRanker} or {@link IndependentRanker}, {@link CollectivePruner} or
 * {@link IndependentPruner}.
 * <p>
 * The components are executed according to the following schedule:
 * <ol>
 * <li>
 * {@link Generator}s will be executed in parallel given the <code>dependencies</code> that the
 * generator requires as input arguments.</li>
 * <li>
 * All raw types will be collected and processed by each {@link CollectiveEvidencer} or
 * {@link IndependentEvidencer}. {@link Evidence}s are required to be created for all raw input
 * types in each evidencer.</li>
 * <li>
 * All {@link Evidence}s will then again be collected and passed to each {@link CollectiveRanker} or
 * {@link IndependentRanker} in a {@link Map} grouped by raw types generated in the generation
 * phase. A {@link Rank} should be produced by each ranker.</li>
 * <li>
 * Finally, all {@link Rank} types are grouped and delivered to each {@link CollectivePruner} or
 * {@link IndependentPruner}, and each pruner should produce a {@link PruningDecision} for each raw
 * type.</li>
 * </ol>
 * <p>
 * 
 * @author Zi Yang <ziy@cs.cmu.edu>
 *
 * @param <T>
 *          The raw type to be "gerp"ed.
 */
public interface GerpExecutor<T> {

  List<T> run(List<?> dependencies);
  
  Set<T> getCandidates();

  List<Generator<T>> getGenerators();

  List<CollectiveEvidencer<T>> getEvidencers();

  List<CollectiveRanker<T>> getRankers();

  List<CollectivePruner<T>> getPruners();

  List<Generator<T>> getGeneratorsOf(T output);

  Evidence getEvidenceOf(T output, CollectiveEvidencer<T> evidencer);

  Rank getRankOf(T output, CollectiveRanker<T> ranker);

  PruningDecision getPruningDecisionOf(T output, CollectivePruner<T> pruner);

}
