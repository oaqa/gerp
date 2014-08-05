package edu.cmu.lti.oaqa.gerp.uima.example;

import static java.util.Comparator.comparing;

import java.util.List;
import java.util.Map;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;

import edu.cmu.lti.oaqa.gerp.uima.type.PruningDecision;
import edu.cmu.lti.oaqa.gerp.uima.type.Rank;
import edu.cmu.lti.oaqa.gerp.uima.util.GerpFactory;
import edu.cmu.lti.oaqa.gerp.uima.util.GerpUtil;
import edu.cmu.lti.oaqa.gerp.util.Pair;

public class ExamplePrunerTwo extends JCasAnnotator_ImplBase {

  @Override
  public void process(JCas jcas) throws AnalysisEngineProcessException {
    Map<Annotation, List<Rank>> t2ranks = GerpUtil.selectRanks(jcas, Annotation.class);
    Pair<Annotation, Double> avg = t2ranks
            .entrySet()
            .parallelStream()
            .map(entry -> Pair.of(entry.getKey(),
                    entry.getValue().stream().mapToDouble(Rank::getRank).average().getAsDouble()))
            .sorted(comparing(Pair::getValue)).findFirst().get();
    t2ranks.entrySet()
            .stream()
            .map(e -> GerpFactory.newPruningDecision(jcas, e.getKey(), this.getClass().getName(), e
                    .getKey().equals(avg.getKey()))).forEach(PruningDecision::addToIndexes);
  }

}
