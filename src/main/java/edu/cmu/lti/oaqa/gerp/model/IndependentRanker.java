package edu.cmu.lti.oaqa.gerp.model;

import static java.util.stream.Collectors.toMap;

import java.util.Map;

import edu.cmu.lti.oaqa.gerp.util.Pair;

@FunctionalInterface
public interface IndependentRanker<T> extends CollectiveRanker<T> {

  Rank rank(Map<CollectiveEvidencer<T>, Evidence> evidences);

  @Override
  default public Map<T, Rank> rankAll(Map<T, Map<CollectiveEvidencer<T>, Evidence>> evidences) {
    return evidences.entrySet().stream()
            .map(entry -> Pair.of(entry.getKey(), rank(entry.getValue())))
            .collect(toMap(Pair::getKey, Pair::getValue));
  }

}
