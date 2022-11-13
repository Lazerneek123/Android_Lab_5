package com.example.appfordisplaying.view.app

import android.app.Application
import com.example.appfordisplaying.view.api.APIServiceModule
import com.example.appfordisplaying.view.di.appModule
import com.example.appfordisplaying.view.di.dataModule
import com.example.appfordisplaying.view.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)  // To output errors in logger
            androidContext(this@App) // Application context
            modules(listOf(APIServiceModule, appModule, domainModule, dataModule))
        }
    }
}