package eu.mc80.java.fizzbuzz;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jooq.lambda.tuple.Tuple2;

public class FunctionalFizzBuzzMapper implements FizzBuzzMapper {
  @Override
  @NotNull
  public Stream<String> map(@Nullable IntStream range) {
    if (range == null) {
      return Stream.empty();
    }
    return range
        .mapToObj(i -> new Tuple2<>(i, ""))
        .map(t -> t.v1 % 3 != 0 ? t : new Tuple2<>(t.v1, t.v2 + "Fizz"))
        .map(t -> t.v1 % 5 != 0 ? t : new Tuple2<>(t.v1, t.v2 + "Buzz"))
        .map(t -> !t.v2.isEmpty() ? t : new Tuple2<>(t.v1, t.v1.toString()))
        .map(t -> t.v2);
  }
}
