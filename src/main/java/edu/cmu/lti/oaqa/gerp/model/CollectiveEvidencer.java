package edu.cmu.lti.oaqa.gerp.model;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@FunctionalInterface
public interface CollectiveEvidencer<T> {

  Map<T, Evidence> evidenceAll(Collection<T> objects, List<?> dependencies);

}
