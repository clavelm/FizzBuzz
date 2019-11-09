package eu.mc80.java.fizzbuzz

import java.util.stream.IntStream
import java.util.stream.Stream

interface FizzBuzzMapper {
    fun map(range: IntStream?): Stream<String>
}
