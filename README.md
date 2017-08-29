## Overview
I find that java code spends a lot of time moving data from one list to another list. This test compares iteration and list manipulation across a variety of mechanisms including
* Java for loops
* Guava 23 Iterables
* Java streams
* Java parallel streams

It compares performance of collecting to both Java ArrayList and Guava ImmutableList through these mechanisms.

## Usage
This test requires Maven 3.3+ and Java 8. From the CLI:
`mvn clean test`

## Results (bigger scores are better)
```
# VM version: JDK 1.8.0_77, VM 25.77-b03
Benchmark                                                        Mode  Cnt        Score       Error  Units
IterablesBenchmark.CollectListToList.for_loop                   thrpt    5  1604355.586 ± 69785.889  ops/s
IterablesBenchmark.CollectListToList.for_loop_immutable         thrpt    5  1273970.437 ± 53283.995  ops/s
IterablesBenchmark.CollectListToList.foreach                    thrpt    5  2367348.551 ± 88210.294  ops/s
IterablesBenchmark.CollectListToList.foreach_immutable          thrpt    5  1326800.061 ± 46750.209  ops/s
IterablesBenchmark.CollectListToList.guava_transform            thrpt    5   991420.345 ± 37108.552  ops/s
IterablesBenchmark.CollectListToList.guava_transform_immutable  thrpt    5  1159346.619 ± 25255.831  ops/s
IterablesBenchmark.CollectListToList.stream_foreach             thrpt    5  1493196.809 ± 52525.728  ops/s
IterablesBenchmark.CollectListToList.stream_foreach_immutable   thrpt    5  1744172.947 ± 50315.796  ops/s
IterablesBenchmark.CollectListToList.stream_map                 thrpt    5  1160352.162 ± 31191.902  ops/s
IterablesBenchmark.CollectListToList.stream_map_immutable       thrpt    5  1245420.440 ± 41924.844  ops/s
```
