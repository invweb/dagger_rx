package com.example.dagger.dagger_test

import javax.inject.Inject

class TestClass @Inject constructor(
    private val testUserClass: TestUserClass
    ) {
    fun getName() = this.toString()
    fun getTestUserClassName() = testUserClass.toString()
}
