package com.example.dagger.application_graph

import com.example.dagger.dagger_test.TestClass
import com.example.dagger.dagger_test.TestUserClass
import com.example.dagger.module.StringModule
import com.example.dagger.module.TestModule
import com.example.dagger.user.UserRepository
import dagger.Component

@Component(modules = [StringModule::class, TestModule::class])
interface ApplicationGraph {
    fun repository(): UserRepository

    fun getTestClass(): TestClass

    fun getTestUserClass(): TestUserClass
}