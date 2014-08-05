package edu.cmu.lti.oaqa.gerp.executor;

import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Sets;
import com.google.common.collect.Table;

import edu.cmu.lti.oaqa.gerp.util.Pair;

public class RowColumnMapToTableCollector<R, C, V> implements
        Collector<Pair<R, Map<C, V>>, Table<R, C, V>, Table<R, C, V>> {

  @Override
  public Supplier<Table<R, C, V>> supplier() {
    return () -> HashBasedTable.create();
  }

  @Override
  public BiConsumer<Table<R, C, V>, Pair<R, Map<C, V>>> accumulator() {
    return (table, pair) -> table.row(pair.getKey()).putAll(pair.getValue());
  }

  @Override
  public BinaryOperator<Table<R, C, V>> combiner() {
    return (table1, table2) -> {
      table1.putAll(table2);
      return table1;
    };
  }

  @Override
  public Function<Table<R, C, V>, Table<R, C, V>> finisher() {
    return Function.identity();
  }

  @Override
  public Set<java.util.stream.Collector.Characteristics> characteristics() {
    return Sets.newHashSet(Collector.Characteristics.CONCURRENT,
            Collector.Characteristics.IDENTITY_FINISH, Collector.Characteristics.UNORDERED);
  }

}
