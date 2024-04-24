package com.dicoding.infobanjir

import android.app.Application
import com.dicoding.infobanjir.core.di.*
import com.dicoding.infobanjir.di.*
import org.koin.android.ext.koin.*
import org.koin.core.context.*
import org.koin.core.logger.*

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule,
                )
            )
        }
    }
}