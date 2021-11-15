package com.avazpar.featureflag

import android.app.Application
import com.avazpar.featureflag.di.dataModule
import com.avazpar.featureflag.di.domainModule
import com.avazpar.featureflag.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class FeatureFlagApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@FeatureFlagApplication)
            modules(modules = listOf(
                viewModelModule,
                domainModule,
                dataModule
            ))
        }

    }
}