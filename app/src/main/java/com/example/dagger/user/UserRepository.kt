package com.example.dagger.user

import android.util.Log
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import javax.inject.Inject

const val TAG = "UserRepository"

class UserRepository @Inject constructor(
    private val localDataSource: UserLocalDataSource,
    private val remoteDataSource: UserRemoteDataSource
) {
    fun getUserLocalDataSource() = localDataSource
    fun getUserRemoteDataSource() = remoteDataSource

    fun testRx(): @NonNull Observable<ArrayList<UserLocalDataSource>>? {
        val dataSources = ArrayList<UserLocalDataSource>()
        dataSources.add(getUserLocalDataSource())
        dataSources.add(getUserLocalDataSource())
        dataSources.add(getUserLocalDataSource())
        dataSources.add(getUserLocalDataSource())
        return Observable.fromArray(dataSources)
    }

    fun getObserver(): Observer<ArrayList<UserLocalDataSource>> {
        return object : Observer<ArrayList<UserLocalDataSource>> {
            override fun onSubscribe(d: Disposable) {
                Log.d(TAG, "onSubscribe")
            }

            override fun onNext(@NonNull t: ArrayList<UserLocalDataSource>?) {
                Log.d(TAG, "onNext: size ${t?.size}")
                t.let { tNotNull ->
                    tNotNull?.forEach { userLocalDataSource ->
                        Log.d(TAG, "RX test:" + userLocalDataSource.getTest1()
                                + " " + userLocalDataSource.getTest2()
                        )
                    }
                }
            }

            override fun onError(e: Throwable) {
                Log.e(TAG, "onError: " + e.message)
            }

            override fun onComplete() {
                Log.d(TAG, "onComplete")
            }
        }
    }
}