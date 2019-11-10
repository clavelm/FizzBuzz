package eu.mc80.java.fizzbuzz;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

  private static final Logger log = LoggerFactory.getLogger(App.class);

  public static void main(String... args) {

    final var component = DaggerFizzBuzzComponent.create();
    final Integer end = component.parametersExtractor().getEnd(args);
    if (end == null) {
      log.error("Missing end parameters, syntax : '-e value' or '--end value'.");
      return;
    }
    final var range = IntStream.rangeClosed(1, end);
    final Stream<String> fizzBuzz = component.mapper().map(range);
    fizzBuzz.forEach(log::info);
  }
}
