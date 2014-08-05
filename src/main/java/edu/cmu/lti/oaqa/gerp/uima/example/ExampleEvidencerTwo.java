package edu.cmu.lti.oaqa.gerp.uima.example;

import static java.lang.Character.getType;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;

import edu.cmu.lti.oaqa.gerp.uima.type.Evidence;
import edu.cmu.lti.oaqa.gerp.uima.type.GeneratorInfo;
import edu.cmu.lti.oaqa.gerp.uima.util.GerpFactory;
import edu.cmu.lti.oaqa.gerp.uima.util.GerpUtil;

public class ExampleEvidencerTwo extends JCasAnnotator_ImplBase {

  @Override
  public void process(JCas jcas) throws AnalysisEngineProcessException {
    Map<Annotation, List<GeneratorInfo>> t2ginfos = GerpUtil.selectGeneratorInfos(jcas,
            Annotation.class);
    t2ginfos.keySet()
            .stream()
            .map(annotation -> {
              String sentence = annotation.getCoveredText();
              long count = IntStream
                      .range(0, sentence.length() - 1)
                      .filter(idx -> getType(sentence.charAt(idx)) == getType(sentence
                              .charAt(idx + 1))).count();
              double confidence = count / (double) sentence.length();
              return GerpFactory.newEvidence(jcas, annotation, this.getClass().getName(),
                      confidence);
            }).forEach(Evidence::addToIndexes);
  }

}
