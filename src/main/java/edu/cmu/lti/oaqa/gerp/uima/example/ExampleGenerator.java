package edu.cmu.lti.oaqa.gerp.uima.example;

import java.util.ArrayList;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;

import edu.cmu.lti.oaqa.gerp.uima.type.GeneratorInfo;
import edu.cmu.lti.oaqa.gerp.uima.util.GerpFactory;

public class ExampleGenerator extends JCasAnnotator_ImplBase {

  @Override
  public void process(JCas jcas) throws AnalysisEngineProcessException {
    String text = jcas.getDocumentText();
    int begin = 0;
    int end = -1;
    while ((end = text.indexOf("\n", begin)) > 0) {
      Annotation sentence = new Annotation(jcas, begin, end);
      sentence.addToIndexes();
      GeneratorInfo ginfo = GerpFactory.createGeneratorInfo(jcas, sentence, this.getClass()
              .getName(), new ArrayList<>());
      ginfo.addToIndexes();
      begin = end + 1;
    }
    Annotation sentence = new Annotation(jcas, begin, text.length());
    sentence.addToIndexes();
    GeneratorInfo ginfo = GerpFactory.createGeneratorInfo(jcas, sentence,
            this.getClass().getName(), new ArrayList<>());
    ginfo.addToIndexes();
  }

}
