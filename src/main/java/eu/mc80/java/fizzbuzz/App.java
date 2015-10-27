package eu.mc80.java.fizzbuzz;

import java.util.stream.IntStream;

import org.jooq.lambda.tuple.Tuple2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
	
	private static final Logger LOG = LoggerFactory.getLogger(App.class);

	public static void main(String... args) {
		
		IntStream.rangeClosed(1, 100)
			.mapToObj( i -> new Tuple2<Integer, String>(i, ""))
			.map(t -> t.v1%3 != 0 ? t : new Tuple2<Integer, String>(t.v1, t.v2 + "Fizz"))
			.map(t -> t.v1%5 != 0 ? t : new Tuple2<Integer, String>(t.v1, t.v2 + "Buzz"))
			.map(t -> !t.v2.isEmpty() ? t : new Tuple2<Integer, String>(t.v1, t.v1.toString()))
			.map(t -> t.v2)
			.forEach(LOG::info);
	}
}
