GERP Framework
==============

Data object and logic definition for GERP Framework, which standardizes the four key processing steps: generation, evidencing, ranking, and pruning, to achieve each individual information processing task.

1. *Generators* will be executed in parallel given the _dependencies_ that the generator requires as input arguments.
2. All raw types will be collected and processed by each *Evidencer*. *Evidence*s are required to be created for all raw input types in each evidencer.
3. All *Evidence*s will then again be collected and passed to each *Ranker* in a _Map_ grouped by raw types generated in the generation phase. A *Rank* should be produced by each ranker.
4. Finally, all *Rank* types are grouped and delivered to each *Pruner*, and each pruner should produce a *PruningDecision* for each raw type.

Use GERP in Java
----------------

```java
GerpExecutor<String> exec = new JdkGerpExecutor<String>(Arrays.asList(g1, g2),
                                                        Arrays.asList(e1, e2),
                                                        Arrays.asList(r1, r2),
                                                        Arrays.asList(p1, p2));
List<String> results = exec.run(new ArrayList<>());
```

Full example can be found [here]()

Use GERP with UIMA
------------------

```java
Object[] configurationData = {
    "type",       TYPE_NAME_TO_BE_GERPED,
    "generators", new String[] { G1_DESC_PATH, G2_DESC_PATH },
    "evidencers", new String[] { E1_DESC_PATH, E2_DESC_PATH },
    "rankers",    new String[] { R1_DESC_PATH, R2_DESC_PATH },
    "pruners",    new String[] { P1_DESC_PATH, P2_DESC_PATH }}
    AnalysisEngineDescription aed = AnalysisEngineFactory.createEngineDescription(
            SequentialGerpExecutor.class, configurationData);
    JCasIterable iter = SimplePipeline.iteratePipeline(CR_DESC, aed);
```

Full example can be found [here]()

