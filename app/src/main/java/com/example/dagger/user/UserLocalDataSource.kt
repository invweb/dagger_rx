package com.example.dagger.user

import javax.inject.Inject
import javax.inject.Named

class UserLocalDataSource
@Inject
constructor(
    @Named("test1")
    private val test1: String,

    @Named("test2")
    private val test2: String
    ) {

    fun getTest1() = test1

    fun getTest2() = test2
}