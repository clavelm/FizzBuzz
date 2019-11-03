package eu.mc80.java.fizzbuzz;

import org.jooq.lambda.tuple.Tuple2;

import java.util.stream.IntStream;
import java.util.stream.Stream;

@lombok.Data
public class FizzBuzzMapperFunctional implements FizzBuzzMapper {
  @Override
  public Stream<String> map(IntStream range) {
    return range
        .mapToObj(i -> new Tuple2<>(i, ""))
        .map(t -> t.v1 % 3 != 0 ? t : new Tuple2<>(t.v1, t.v2 + "Fizz"))
        .map(t -> t.v1 % 5 != 0 ? t : new Tuple2<>(t.v1, t.v2 + "Buzz"))
        .map(t -> !t.v2.isEmpty() ? t : new Tuple2<>(t.v1, t.v1.toString()))
        .map(t -> t.v2);
  }
}
