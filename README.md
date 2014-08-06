GERP Framework
==============

Data object and logic definition for GERP Framework, which standardizes the four key processing steps: generation, evidencing, ranking, and pruning, to accomplish each individual information processing task. The standardized GERP-compatible pipeline allows to easily reuse components and formal performance analysis.

1. __Generators__ will be executed in parallel given the _dependencies_ that the generator requires as input arguments.
2. All raw types will be collected and processed by each __Evidencer__. __Evidences__ are required to be created for all raw input types in each evidencer.
3. All __Evidences__ will then again be collected and passed to each __Ranker__ in a _Map_ grouped by raw types generated in the generation phase. A __Rank__ should be produced by each ranker.
4. Finally, all __Rank__ types are grouped and delivered to each __Pruner__, and each pruner should produce a __PruningDecision__ for each raw type.

Use GERP in Java
----------------

```java
Generator<T>           g1, g2 = ...;
CollectiveEvidencer<T> e1, e2 = ...;
CollectiveRanker<T>    r1, r2 = ...;
CollectivePruner<T>    p1, p2 = ...;
GerpExecutor<T> exec = new JdkGerpExecutor<T>(Arrays.asList(g1, g2),
                                              Arrays.asList(e1, e2),
                                              Arrays.asList(r1, r2),
                                              Arrays.asList(p1, p2));
List<T> results = exec.run(DEPENDENCIES);
```

A full example can be found [here](src/main/java/edu/cmu/lti/oaqa/gerp/example/SimpleGerpExample.java).

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

A full example can be found [here](src/main/java/edu/cmu/lti/oaqa/gerp/uima/example/ExampleSequentialGerpExecutor.java).

**Questions or comments** Please create an issue or contact [me](http://www.cs.cmu.edu/~ziy).

