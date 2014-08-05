package edu.cmu.lti.oaqa.gerp.uima.util;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.TOP;

import edu.cmu.lti.oaqa.gerp.uima.type.Evidence;
import edu.cmu.lti.oaqa.gerp.uima.type.GeneratorInfo;
import edu.cmu.lti.oaqa.gerp.uima.type.GerpBase;
import edu.cmu.lti.oaqa.gerp.uima.type.PruningDecision;
import edu.cmu.lti.oaqa.gerp.uima.type.Rank;

public class GerpUtil {

  public static <R extends TOP> Stream<GeneratorInfo> streamGeneratorInfos(JCas jcas,
          Class<R> rawClass) {
    return stream(jcas, GeneratorInfo.class, rawClass);
  }

  public static <R extends TOP> Stream<Evidence> streamEvidences(JCas jcas, Class<R> rawClass) {
    return stream(jcas, Evidence.class, rawClass);
  }

  public static <R extends TOP> Stream<Rank> streamRanks(JCas jcas, Class<R> rawClass) {
    return stream(jcas, Rank.class, rawClass);
  }

  public static <R extends TOP> Stream<PruningDecision> streamPruningDecisions(JCas jcas,
          Class<R> rawClass) {
    return stream(jcas, PruningDecision.class, rawClass);
  }

  public static <M extends GerpBase, R extends TOP> Stream<M> stream(JCas jcas,
          Class<M> metainfoClass, Class<R> rawClass) {
    return JCasUtil.select(jcas, metainfoClass).stream()
            .filter(top -> rawClass.isAssignableFrom(top.getRaw().getClass()));
  }

  public static <R extends TOP> Map<R, List<GeneratorInfo>> selectGeneratorInfos(JCas jcas,
          Class<R> rawClass) {
    return select(jcas, GeneratorInfo.class, rawClass);
  }

  public static <R extends TOP> Map<R, List<Evidence>> selectEvidences(JCas jcas, Class<R> rawClass) {
    return select(jcas, Evidence.class, rawClass);
  }

  public static <R extends TOP> Map<R, List<Rank>> selectRanks(JCas jcas, Class<R> rawClass) {
    return select(jcas, Rank.class, rawClass);
  }

  public static <R extends TOP> Map<R, List<PruningDecision>> selectPruningDecisions(JCas jcas,
          Class<R> rawClass) {
    return select(jcas, PruningDecision.class, rawClass);
  }

  @SuppressWarnings("unchecked")
  private static <M extends GerpBase, R extends TOP> Map<R, List<M>> select(JCas jcas,
          Class<M> metainfoClass, Class<R> rawClass) {
    return stream(jcas, metainfoClass, rawClass).collect(groupingBy(top -> (R) top.getRaw()));
  }

}
