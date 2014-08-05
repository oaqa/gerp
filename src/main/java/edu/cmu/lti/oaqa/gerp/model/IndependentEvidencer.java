package edu.cmu.lti.oaqa.gerp.model;

import static java.util.stream.Collectors.toMap;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import edu.cmu.lti.oaqa.gerp.util.Pair;

@FunctionalInterface
public interface IndependentEvidencer<T> extends CollectiveEvidencer<T> {

  Evidence evidence(T object, List<?> dependencies);

  @Override
  default public Map<T, Evidence> evidenceAll(Collection<T> objects, List<?> dependencies) {
    return objects.stream().map(o -> Pair.of(o, evidence(o, dependencies)))
            .collect(toMap(Pair::getKey, Pair::getValue));
  }

}
