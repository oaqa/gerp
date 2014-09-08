package edu.cmu.lti.oaqa.gerp.uima.example;

import static java.lang.String.format;

import java.util.stream.Stream;

import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.JCasIterable;
import org.apache.uima.fit.pipeline.SimplePipeline;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;

import edu.cmu.lti.oaqa.gerp.uima.components.SequentialGerpExecutor;
import edu.cmu.lti.oaqa.gerp.uima.type.GeneratorInfo;
import edu.cmu.lti.oaqa.gerp.uima.util.GerpUtil;

public class ExampleSequentialGerpExecutor {

  public static void main(String[] args) throws ResourceInitializationException {
    // configure components as parameter
    Object[] configurationData = {
        "type",
        "org.apache.uima.jcas.tcas.Annotation",
        "generators",
        new String[] { "edu.cmu.lti.oaqa.gerp.uima.example.ExampleGeneratorDescriptor" },
        "evidencers",
        new String[] { "edu.cmu.lti.oaqa.gerp.uima.example.ExampleEvidencerOneDescriptor",
            "edu.cmu.lti.oaqa.gerp.uima.example.ExampleEvidencerTwoDescriptor" },
        "rankers",
        new String[] { "edu.cmu.lti.oaqa.gerp.uima.example.ExampleRankerOneDescriptor",
            "edu.cmu.lti.oaqa.gerp.uima.example.ExampleRankerTwoDescriptor" },
        "pruners",
        new String[] { "edu.cmu.lti.oaqa.gerp.uima.example.ExamplePrunerOneDescriptor",
            "edu.cmu.lti.oaqa.gerp.uima.example.ExamplePrunerTwoDescriptor" } };

    // execute cpe
    CollectionReaderDescription crd = CollectionReaderFactory
            .createReaderDescription(ExampleCollectionReader.class);
    AnalysisEngineDescription aed = AnalysisEngineFactory.createEngineDescription(
            SequentialGerpExecutor.class, configurationData);
    JCasIterable iter = SimplePipeline.iteratePipeline(crd, aed);

    // print out results
    iter.forEach(jcas -> {
      Stream<GeneratorInfo> ginfos = GerpUtil.streamGeneratorInfos(jcas, Annotation.class);
      System.out.println("Candidate");
      System.out.println("Generators: ");
      ginfos.forEach(g -> System.out.println(format("  - %s: %s",
              ((Annotation) g.getRaw()).getCoveredText(), g.getGenerator())));
      System.out.println("Evidences: ");
      GerpUtil.streamEvidences(jcas, Annotation.class).forEach(
              e -> System.out.println(format("  - %s: %s <- %s",
                      ((Annotation) e.getRaw()).getCoveredText(), e.getConfidence(),
                      e.getEvidencer())));
      System.out.println("Ranks: ");
      GerpUtil.streamRanks(jcas, Annotation.class).forEach(
              r -> System.out.println(format("  - %s: %s <- %s",
                      ((Annotation) r.getRaw()).getCoveredText(), r.getRank(), r.getRanker())));
      System.out.println("Pruning decision: ");
      GerpUtil.streamPruningDecisions(jcas, Annotation.class).forEach(
              p -> System.out.println(format("  - %s: %s <- %s",
                      ((Annotation) p.getRaw()).getCoveredText(), p.getDecision(), p.getPruner())));
      System.out.println();
    });
  }

}
