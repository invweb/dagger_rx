package com.example.dagger.module

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class StringModule {

    @Provides
    @Named("test1")
    fun test1(): String = "test1"

    @Provides
    @Named("test2")
    fun test2(): String = "test2"
}