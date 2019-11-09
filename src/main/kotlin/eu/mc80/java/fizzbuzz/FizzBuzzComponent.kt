package eu.mc80.java.fizzbuzz

import dagger.Component
import javax.inject.Scope
import javax.inject.Singleton

@Component(modules = [FizzBuzzModule::class])
@Singleton
interface FizzBuzzComponent {
    fun mapper() : FizzBuzzMapper
}