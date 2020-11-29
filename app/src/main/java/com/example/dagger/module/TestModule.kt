package com.example.dagger.module

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class TestModule {

    @Provides
    @Named("TestModuleText")
    fun getTestModuleText(): String = "TestModuleText"
}