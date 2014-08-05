package edu.cmu.lti.oaqa.gerp.model;

import java.util.List;

@FunctionalInterface
public interface Generator<T> {

  T generate(List<?> dependencies);

}
