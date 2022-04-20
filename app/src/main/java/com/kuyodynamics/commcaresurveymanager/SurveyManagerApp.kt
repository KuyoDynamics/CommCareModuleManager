package com.kuyodynamics.commcaresurveymanager

import android.app.Application
import android.content.Context
import timber.log.Timber

class SurveyManagerApp : Application() {
    init {
        INSTANCE = this
    }

    companion object {
        lateinit var INSTANCE: SurveyManagerApp
            private set

        val context: Context
            get() {
                return INSTANCE.applicationContext
            }
    }

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())


    }
}