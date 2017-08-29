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
Benchmark                                                         Mode  Cnt        Score        Error  Units
IterablesBenchmark.CollectListToList.guava                       thrpt    5  1123001.433 ±  45634.534  ops/s
IterablesBenchmark.CollectListToList.guava_immutable             thrpt    5  1143280.767 ±  73951.884  ops/s
IterablesBenchmark.CollectListToList.iterate                     thrpt    5  1609121.538 ±  31361.499  ops/s
IterablesBenchmark.CollectListToList.iterate_immutable           thrpt    5  1256231.852 ± 143288.242  ops/s
IterablesBenchmark.CollectListToList.parallel_streams            thrpt    5    35053.087 ±   2631.421  ops/s
IterablesBenchmark.CollectListToList.parallel_streams_immutable  thrpt    5    34687.248 ±   3634.177  ops/s
IterablesBenchmark.CollectListToList.streams                     thrpt    5  1108512.767 ±  88668.641  ops/s
IterablesBenchmark.CollectListToList.streams_immutable           thrpt    5  1213230.572 ± 144316.935  ops/s
```
