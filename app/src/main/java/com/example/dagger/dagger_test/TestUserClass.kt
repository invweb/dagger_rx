package com.example.dagger.dagger_test

import javax.inject.Inject

class TestUserClass @Inject constructor(){
    fun getClassName(): String = this.toString()
}
