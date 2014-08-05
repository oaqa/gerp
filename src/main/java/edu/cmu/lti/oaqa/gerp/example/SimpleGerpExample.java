package edu.cmu.lti.oaqa.gerp.example;

import static java.lang.Character.getType;
import static java.lang.Character.isWhitespace;
import static java.lang.String.format;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import edu.cmu.lti.oaqa.gerp.executor.GerpExecutor;
import edu.cmu.lti.oaqa.gerp.executor.JdkGerpExecutor;
import edu.cmu.lti.oaqa.gerp.model.CollectivePruner;
import edu.cmu.lti.oaqa.gerp.model.CollectiveRanker;
import edu.cmu.lti.oaqa.gerp.model.Evidence;
import edu.cmu.lti.oaqa.gerp.model.Generator;
import edu.cmu.lti.oaqa.gerp.model.IndependentEvidencer;
import edu.cmu.lti.oaqa.gerp.model.IndependentPruner;
import edu.cmu.lti.oaqa.gerp.model.PruningDecision;
import edu.cmu.lti.oaqa.gerp.model.Rank;
import edu.cmu.lti.oaqa.gerp.util.Pair;

/**
 * 
 * @author Zi Yang <ziy@cs.cmu.edu>
 *
 */
public class SimpleGerpExample {

  public static void main(String[] args) {
    
    // create components
    Generator<String> g1 = __ -> "This is a normal English sentence.";
    Generator<String> g2 = __ -> "X52aQhBP8ouH7RvpYFeBiL1wtSj5ZSNOjs1gHNTC";
    IndependentEvidencer<String> e1 = (raw, __) -> {
      long count = raw.chars().filter(ch -> isWhitespace(ch)).count();
      return Evidence.create(1.0 - Math.abs(count / (double) raw.length() - 0.16));
    };
    IndependentEvidencer<String> e2 = (raw, __) -> {
      long count = IntStream.range(0, raw.length() - 1)
              .filter(idx -> getType(raw.charAt(idx)) == getType(raw.charAt(idx + 1))).count();
      return Evidence.create(count / (double) raw.length());
    };
    CollectiveRanker<String> r1 = t2emap -> {
      List<Pair<String, Double>> pairs = t2emap
              .entrySet()
              .stream()
              .map(e -> Pair.of(e.getKey(),
                      e.getValue().values().stream().mapToDouble(Evidence::getConfidence).average()
                              .getAsDouble())).sorted(comparing(Pair::getValue)).collect(toList());
      return IntStream
              .range(1, pairs.size() + 1)
              .boxed()
              .collect(
                      toMap(i -> pairs.get(pairs.size() - i).getKey(),
                              i -> Rank.createWithScore(i, pairs.get(pairs.size() - i).getValue())));
    };
    CollectiveRanker<String> r2 = t2emap -> {
      List<Pair<String, Double>> pairs = t2emap
              .entrySet()
              .stream()
              .map(e -> Pair.of(e.getKey(),
                      e.getValue().values().stream().mapToDouble(Evidence::getConfidence).max()
                              .getAsDouble())).sorted(comparing(Pair::getValue)).collect(toList());
      return IntStream
              .range(1, pairs.size() + 1)
              .boxed()
              .collect(
                      toMap(i -> pairs.get(pairs.size() - i).getKey(),
                              i -> Rank.createWithScore(i, pairs.get(pairs.size() - i).getValue())));
    };
    IndependentPruner<String> p1 = rmap -> {
      double avg = rmap.values().stream().mapToDouble(r -> r.getRank()).average().getAsDouble();
      return PruningDecision.create(avg < 2);
    };
    CollectivePruner<String> p2 = t2rmap -> {
      Pair<String, Double> avg = t2rmap
              .entrySet()
              .stream()
              .map(e -> Pair.of(e.getKey(),
                      e.getValue().values().stream().mapToDouble(Rank::getRank).average()
                              .getAsDouble())).sorted(comparing(Pair::getValue)).findFirst().get();
      return t2rmap
              .entrySet()
              .stream()
              .map(e -> Pair.of(e.getKey(), PruningDecision.create(e.getKey().equals(avg.getKey()))))
              .collect(toMap(Pair::getKey, Pair::getValue));
    };
    
    // execute gerp
    GerpExecutor<String> exec = new JdkGerpExecutor<String>(Arrays.asList(g1, g2), Arrays.asList(
            e1, e2), Arrays.asList(r1, r2), Arrays.asList(p1, p2));
    List<String> results = exec.run(new ArrayList<>());
    
    // print out results
    System.out.println("Final gerped results: " + results);
    Set<String> candidates = exec.getCandidates();
    System.out.println("Candidates: " + candidates);
    System.out.println("Generators: ");
    candidates.forEach(c -> System.out.println(format("  - %s: %s", c, exec.getGeneratorsOf(c))));
    System.out.println("Evidences: ");
    candidates.forEach(c -> exec.getEvidencers().forEach(
            e -> System.out.println(format("  - %s: %s <- %s", c, exec.getEvidenceOf(c, e), e))));
    System.out.println("Ranks: ");
    candidates.forEach(c -> exec.getRankers().forEach(
            r -> System.out.println(format("  - %s: %s <- %s", c, exec.getRankOf(c, r), r))));
    System.out.println("Pruning decision: ");
    candidates.forEach(c -> exec.getPruners().forEach(
            p -> System.out.println(format("  - %s: %s <- %s", c, exec.getPruningDecisionOf(c, p),
                    p))));
  }
  
}
