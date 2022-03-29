package com.kuyodynamics.commcaremodulemanager

import android.app.Application
import timber.log.Timber

class CommCareModuleManagerApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}