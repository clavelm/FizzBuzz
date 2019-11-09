package eu.mc80.java.fizzbuzz

import spock.lang.Specification

import java.util.stream.IntStream

class FizzBuzzMapperTest extends Specification {

    private mapper = new FunctionalFizzBuzzMapper()

    def "map null range to empty stream"() {
        when:
        def result = mapper.map(null)

        then:
        result.count() == 0
    }

    def "map empty range is empty stream"() {
        when:
        def result = mapper.map(IntStream.empty())

        then:
        result.count() == 0
    }

    def "map some values"() {
        when:
        def result = mapper.map(IntStream.of(1, 3, 5, 11, 15))

        then:
        result.toArray() == ["1", "Fizz", "Buzz", "11", "FizzBuzz"].toArray()
    }
}
