package edu.cmu.lti.oaqa.gerp.uima.example;

import static java.lang.Character.isWhitespace;

import java.util.List;
import java.util.Map;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;

import edu.cmu.lti.oaqa.gerp.uima.type.Evidence;
import edu.cmu.lti.oaqa.gerp.uima.type.GeneratorInfo;
import edu.cmu.lti.oaqa.gerp.uima.util.GerpFactory;
import edu.cmu.lti.oaqa.gerp.uima.util.GerpUtil;

public class ExampleEvidencerOne extends JCasAnnotator_ImplBase {

  @Override
  public void process(JCas jcas) throws AnalysisEngineProcessException {
    Map<Annotation, List<GeneratorInfo>> t2ginfos = GerpUtil.selectGeneratorInfos(jcas,
            Annotation.class);
    t2ginfos.keySet().stream().map(annotation -> {
      String sentence = annotation.getCoveredText();
      long count = sentence.chars().filter(ch -> isWhitespace(ch)).count();
      double confidence = 1.0 - Math.abs(count / (double) sentence.length() - 0.16);
      return GerpFactory.newEvidence(jcas, annotation, this.getClass().getName(), confidence);
    }).forEach(Evidence::addToIndexes);
  }

}
