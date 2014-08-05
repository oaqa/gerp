package edu.cmu.lti.oaqa.gerp.model;

import java.util.Map;

@FunctionalInterface
public interface CollectiveRanker<T> {

  Map<T, Rank> rankAll(Map<T, Map<CollectiveEvidencer<T>, Evidence>> evidences);

}
