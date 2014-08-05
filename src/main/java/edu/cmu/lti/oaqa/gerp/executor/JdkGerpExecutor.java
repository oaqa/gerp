package edu.cmu.lti.oaqa.gerp.executor;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import edu.cmu.lti.oaqa.gerp.example.SimpleGerpExample;
import edu.cmu.lti.oaqa.gerp.model.CollectiveEvidencer;
import edu.cmu.lti.oaqa.gerp.model.CollectivePruner;
import edu.cmu.lti.oaqa.gerp.model.CollectiveRanker;
import edu.cmu.lti.oaqa.gerp.model.Evidence;
import edu.cmu.lti.oaqa.gerp.model.Generator;
import edu.cmu.lti.oaqa.gerp.model.PruningDecision;
import edu.cmu.lti.oaqa.gerp.model.Rank;
import edu.cmu.lti.oaqa.gerp.util.Pair;

/**
 * A {@link GerpExecutor} based purely on JDK, with {@link Stream#parallel()} being used to
 * parallelize execution of each generation, evidencing, ranking, and pruning phase.
 * <p>
 * Example can be found in {@link SimpleGerpExample}.
 * <p>
 * 
 * @author Zi Yang <ziy@cs.cmu.edu>
 *
 * @param <T>
 *          The raw type to be "gerp"ed.
 */
public final class JdkGerpExecutor<T> implements GerpExecutor<T> {

  private final List<Generator<T>> generators;

  private final List<CollectiveEvidencer<T>> evidencers;

  private final List<CollectiveRanker<T>> rankers;

  private final List<CollectivePruner<T>> pruners;

  private Set<T> candidates;

  private Map<T, List<Generator<T>>> o2generators;

  private Table<CollectiveEvidencer<T>, T, Evidence> eo2evidence;

  private Table<CollectiveRanker<T>, T, Rank> ro2rank;

  private Table<CollectivePruner<T>, T, PruningDecision> po2pruning;

  public JdkGerpExecutor(List<Generator<T>> generators, List<CollectiveEvidencer<T>> evidencers,
          List<CollectiveRanker<T>> rankers, List<CollectivePruner<T>> pruners) {
    super();
    this.generators = generators;
    this.evidencers = evidencers;
    this.rankers = rankers;
    this.pruners = pruners;
    this.o2generators = new HashMap<>();
    this.eo2evidence = HashBasedTable.create();
    this.ro2rank = HashBasedTable.create();
    this.po2pruning = HashBasedTable.create();
  }

  @Override
  public List<T> run(List<?> dependencies) {
    o2generators = generators.parallelStream()
            .map(generator -> Pair.of(generator.generate(dependencies), generator))
            .collect(groupingBy(Pair::getKey, mapping(Pair::getValue, toList())));
    candidates = o2generators.keySet();
    eo2evidence = evidencers.parallelStream()
            .map(evidencer -> Pair.of(evidencer, evidencer.evidenceAll(candidates, dependencies)))
            .collect(new RowColumnMapToTableCollector<>());
    ro2rank = rankers.parallelStream()
            .map(ranker -> Pair.of(ranker, ranker.rankAll(eo2evidence.columnMap())))
            .collect(new RowColumnMapToTableCollector<>());
    po2pruning = pruners.parallelStream()
            .map(pruner -> Pair.of(pruner, pruner.pruneAll(ro2rank.columnMap())))
            .collect(new RowColumnMapToTableCollector<>());
    return po2pruning.columnMap().entrySet().stream().filter(entry -> aggregate(entry.getValue()))
            .map(Map.Entry::getKey).collect(toList());
  }

  private boolean aggregate(Map<CollectivePruner<T>, PruningDecision> p2pruning) {
    long trueCount = p2pruning.values().stream().filter(PruningDecision::isDecision).count();
    return trueCount > p2pruning.size() / 2;
  }

  @Override
  public List<Generator<T>> getGenerators() {
    return generators;
  }

  @Override
  public List<CollectiveEvidencer<T>> getEvidencers() {
    return evidencers;
  }

  @Override
  public List<CollectiveRanker<T>> getRankers() {
    return rankers;
  }

  @Override
  public List<CollectivePruner<T>> getPruners() {
    return pruners;
  }

  @Override
  public List<Generator<T>> getGeneratorsOf(T output) {
    return o2generators.get(output);
  }

  @Override
  public Evidence getEvidenceOf(T output, CollectiveEvidencer<T> evidencer) {
    return eo2evidence.get(evidencer, output);
  }

  @Override
  public Rank getRankOf(T output, CollectiveRanker<T> ranker) {
    return ro2rank.get(ranker, output);
  }

  @Override
  public PruningDecision getPruningDecisionOf(T output, CollectivePruner<T> pruner) {
    return po2pruning.get(pruner, output);
  }

  @Override
  public Set<T> getCandidates() {
    return candidates;
  }

}
