package edu.cmu.lti.oaqa.gerp.uima.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.uima.fit.util.FSCollectionFactory;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.TOP;

import edu.cmu.lti.oaqa.gerp.uima.type.Evidence;
import edu.cmu.lti.oaqa.gerp.uima.type.GeneratorInfo;
import edu.cmu.lti.oaqa.gerp.uima.type.PruningDecision;
import edu.cmu.lti.oaqa.gerp.uima.type.Rank;

public class GerpFactory {

  public static <T extends TOP> GeneratorInfo newGeneratorInfo(JCas jcas, T raw,
          List<String> generators, List<TOP> dependencies) {
    GeneratorInfo ret = new GeneratorInfo(jcas);
    ret.setRaw(raw);
    ret.setGenerators(FSCollectionFactory.createStringList(jcas, generators));
    ret.setDependencies(FSCollectionFactory.createFSList(jcas, dependencies));
    return ret;
  }

  public static <T extends TOP> Evidence newEvidence(JCas jcas, T raw, String evidencer,
          double confidence, List<TOP> details) {
    Evidence ret = new Evidence(jcas);
    ret.setRaw(raw);
    ret.setEvidencer(evidencer);
    ret.setConfidence(confidence);
    ret.setDetails(FSCollectionFactory.createFSList(jcas, details));
    return ret;
  }

  public static <T extends TOP> Evidence newEvidence(JCas jcas, T raw, String evidencer,
          double confidence) {
    Evidence ret = new Evidence(jcas);
    ret.setRaw(raw);
    ret.setEvidencer(evidencer);
    ret.setConfidence(confidence);
    ret.setDetails(FSCollectionFactory.createFSList(jcas, new ArrayList<>()));
    return ret;
  }

  public static <T extends TOP> Rank newRank(JCas jcas, T raw, String ranker, int rank, double score) {
    Rank ret = new Rank(jcas);
    ret.setRaw(raw);
    ret.setRanker(ranker);
    ret.setRank(rank);
    ret.setScore(score);
    return ret;
  }

  public static <T extends TOP> PruningDecision newPruningDecision(JCas jcas, T raw, String pruner,
          boolean decision) {
    PruningDecision ret = new PruningDecision(jcas);
    ret.setRaw(raw);
    ret.setPruner(pruner);
    ret.setDecision(decision);
    return ret;
  }

}
