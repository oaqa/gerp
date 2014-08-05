package edu.cmu.lti.oaqa.gerp.uima.example;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;

import edu.cmu.lti.oaqa.gerp.uima.type.Evidence;
import edu.cmu.lti.oaqa.gerp.uima.type.Rank;
import edu.cmu.lti.oaqa.gerp.uima.util.GerpFactory;
import edu.cmu.lti.oaqa.gerp.uima.util.GerpUtil;
import edu.cmu.lti.oaqa.gerp.util.Pair;

public class ExampleRankerTwo extends JCasAnnotator_ImplBase {

  @Override
  public void process(JCas jcas) throws AnalysisEngineProcessException {
    Map<Annotation, List<Evidence>> t2evidences = GerpUtil.selectEvidences(jcas, Annotation.class);
    List<Pair<Annotation, Double>> pairs = t2evidences
            .entrySet()
            .parallelStream()
            .map(entry -> Pair.of(entry.getKey(),
                    entry.getValue().stream().mapToDouble(Evidence::getConfidence).max()
                            .getAsDouble())).sorted(comparing(Pair::getValue)).collect(toList());
    IntStream
            .range(1, pairs.size() + 1)
            .boxed()
            .map(i -> {
              Pair<Annotation, Double> pair = pairs.get(pairs.size() - i);
              return GerpFactory.newRank(jcas, pair.getKey(), this.getClass().getName(), i,
                      pair.getValue());
            }).forEach(Rank::addToIndexes);
  }

}
