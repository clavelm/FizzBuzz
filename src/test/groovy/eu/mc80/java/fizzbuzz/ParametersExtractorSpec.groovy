package eu.mc80.java.fizzbuzz

import spock.lang.Specification
import spock.lang.Unroll

class ParametersExtractorSpec extends Specification {

    private extractor = DaggerFizzBuzzComponent.create().parametersExtractor()

    @Unroll
    def "getEnd(#args) = #value"() {
        expect:
        extractor.getEnd(args as String[]) == value

        where:
        args                                        || value
        []                                          || null
        ["-b", "toto"]                              || null
        ["--bb", "toto"]                            || null
        ["-e", "toto"]                              || null
        ["--end", "toto"]                           || null
        ["-e", "16"]                                || 16
        ["-e", "-5"]                                || -5
        ["-e", "-5", "--end", "256"]                || -5
        ["--end", "256", "-e", "-5"]                || 256
        ["--end", "256", "--end", "17", "-e", "-5"] || 256
    }
}
