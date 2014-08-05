package edu.cmu.lti.oaqa.gerp.model;

import static java.util.stream.Collectors.toMap;

import java.util.Map;

import edu.cmu.lti.oaqa.gerp.util.Pair;

@FunctionalInterface
public interface IndependentPruner<T> extends CollectivePruner<T> {

  PruningDecision prune(Map<CollectiveRanker<T>, Rank> ranks);

  @Override
  default public Map<T, PruningDecision> pruneAll(Map<T, Map<CollectiveRanker<T>, Rank>> ranks) {
    return ranks.entrySet().stream().map(entry -> Pair.of(entry.getKey(), prune(entry.getValue())))
            .collect(toMap(Pair::getKey, Pair::getValue));
  }

}
