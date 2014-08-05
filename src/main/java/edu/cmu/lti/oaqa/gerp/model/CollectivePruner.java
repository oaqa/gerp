package edu.cmu.lti.oaqa.gerp.model;

import java.util.Map;

@FunctionalInterface
public interface CollectivePruner<T> {

  Map<T, PruningDecision> pruneAll(Map<T, Map<CollectiveRanker<T>, Rank>> ranks);

}
