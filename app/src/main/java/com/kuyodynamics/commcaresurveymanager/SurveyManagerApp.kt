package com.kuyodynamics.commcaresurveymanager

import android.app.Application
import timber.log.Timber

class SurveyManagerApp: Application() {
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}