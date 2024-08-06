package com.example.retrofitdrill

import android.app.Application
import com.example.retrofitdrill.data.AppContainer
import com.example.retrofitdrill.data.DefaultAppContainer

class AnimalInfoApplication : Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}