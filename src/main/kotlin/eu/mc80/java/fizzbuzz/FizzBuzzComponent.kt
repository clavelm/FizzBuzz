package eu.mc80.java.fizzbuzz

import dagger.Component
import javax.inject.Singleton

@Component(modules = [FizzBuzzModule::class])
@Singleton
interface FizzBuzzComponent {
    fun mapper(): FizzBuzzMapper
    fun parametersExtractor(): ParametersExtractor
}