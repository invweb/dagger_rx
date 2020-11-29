package com.example.dagger.user

import javax.inject.Inject

class UserRemoteDataSource @Inject constructor() {

    fun getData() = "data"
}