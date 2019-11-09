package eu.mc80.java.fizzbuzz

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FizzBuzzModule {
    @Provides
    @Singleton
    fun provideFizzBuzzMapper(): FizzBuzzMapper = KtFizzBuzzMapper()
}