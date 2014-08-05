package edu.cmu.lti.oaqa.gerp.uima.components;

import java.util.stream.Stream;

import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.TOP;

import edu.cmu.lti.oaqa.gerp.uima.example.ExampleSequentialGerpExecutor;

/**
 * A sequential implementation of {@link AbstractGerpExecutor}. All generators, evidencers, rankers and
 * pruners will be executed sequentially in a random order to process the same input CAS.
 * Annotations or other feature structures will be persisted in this CAS. Therefore, no CAS copying
 * or merging is needed.
 * <p>
 * A simple example using uimafit can be found in {@link ExampleSequentialGerpExecutor}.
 * <p>
 * 
 * @see {@link ParallelGerpExecutor}
 * @author Zi Yang <ziy@cs.cmu.edu>
 * 
 */
public class SequentialGerpExecutor<T extends TOP> extends AbstractGerpExecutor<T> {

  @Override
  public void gerp(JCas jcas) throws AnalysisEngineProcessException {
    Stream.of(generators, evidencers, rankers, pruners).flatMap(aes -> aes.stream()).sequential()
            .forEach(ae -> process(jcas, ae));
  }

  private static void process(JCas jcas, AnalysisEngine ae) {
    try {
      ae.process(jcas);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}
