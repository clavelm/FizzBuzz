package eu.mc80.java.fizzbuzz;

import org.apache.commons.cli.*;
import org.slf4j.Logger;

import java.util.stream.IntStream;
import java.util.stream.Stream;

@lombok.extern.slf4j.Slf4j
public class App {

  public static void main(String... args) throws Exception {

    final int end = getEndFromArgs(args);
    final IntStream range = IntStream.rangeClosed(1, end);
    final Stream<String> fizzBuzz = new FunctionalFizzBuzzMapper().map(range);
    logstream(log, fizzBuzz);
  }

  static void logstream(Logger logger, Stream<String> fizzBuzz) {
    fizzBuzz.forEach(logger::info);
  }

  static int getEndFromArgs(String... args) throws ParseException {
    final Option endOption = Option.builder("e").required().longOpt("end").hasArg().build();

    final Options options = new Options();
    options.addOption(endOption);

    CommandLineParser parser = new DefaultParser();
    CommandLine cmd = parser.parse(options, args);

    return Integer.parseInt(cmd.getOptionValue(endOption.getOpt()));
  }
}
