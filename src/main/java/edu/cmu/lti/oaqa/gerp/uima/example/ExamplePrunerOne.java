package edu.cmu.lti.oaqa.gerp.uima.example;

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

public class ExamplePrunerOne extends JCasAnnotator_ImplBase {

  @Override
  public void process(JCas jcas) throws AnalysisEngineProcessException {
    Map<Annotation, List<Rank>> t2ranks = GerpUtil.selectRanks(jcas, Annotation.class);
    t2ranks.entrySet()
            .stream()
            .map(entry -> {
              double avg = entry.getValue().parallelStream().mapToDouble(r -> r.getRank())
                      .average().getAsDouble();
              boolean decision = avg < 2;
              return GerpFactory.createPruningDecision(jcas, entry.getKey(),
                      this.getClass().getName(), decision);
            }).forEach(PruningDecision::addToIndexes);
  }

}
