package com.kuyodynamics.commcaresurveymanager.repository

import com.kuyodynamics.commcaresurveymanager.database.SurveyManagerDatabase
import com.kuyodynamics.commcaresurveymanager.network.CommCareService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CommCareAppRepo(private val database: SurveyManagerDatabase) {

    suspend fun refreshApps(){

        withContext(Dispatchers.IO){
            // fetch the Apps list from the network using the Retrofit serice
//            val apps = CommCareService.
        }

    }
}