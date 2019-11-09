package eu.mc80.java.fizzbuzz

import java.util.stream.IntStream
import java.util.stream.Stream

class KtFizzBuzzMapper : FizzBuzzMapper {
    override fun map(range: IntStream?) =
            if (range == null) {
                Stream.empty()
            } else {
                range.mapToObj({ i -> Pair(i, "") })
                        .map({ p -> if (p.first % 3 != 0) p else p.copy(second = p.second + "Fizz") })
                        .map({ p -> if (p.first % 5 != 0) p else p.copy(second = p.second + "Buzz") })
                        .map({ p -> if (p.second.isNotEmpty()) p else p.copy(second = p.first.toString()) })
                        .map { p -> p.second }
            }
}