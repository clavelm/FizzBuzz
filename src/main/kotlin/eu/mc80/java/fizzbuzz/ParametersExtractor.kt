package eu.mc80.java.fizzbuzz

interface ParametersExtractor {
    fun getEnd(vararg args: String): Int?
}
