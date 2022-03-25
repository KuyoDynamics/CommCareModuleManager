package com.example.commcaremodulemanager

import android.app.Application
import timber.log.Timber

class ModuleManagerApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}