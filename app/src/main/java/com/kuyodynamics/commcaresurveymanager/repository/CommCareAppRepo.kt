package com.kuyodynamics.commcaresurveymanager.repository

import com.kuyodynamics.commcaresurveymanager.database.SurveyManagerDatabase
import com.kuyodynamics.commcaresurveymanager.network.CommCareNetwork
import com.kuyodynamics.commcaresurveymanager.network.CommCareService
import com.kuyodynamics.commcaresurveymanager.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CommCareAppRepo(private val database: SurveyManagerDatabase) {

    suspend fun refreshApps(projectName: String){

        withContext(Dispatchers.IO){
            // fetch the Apps list from the network using the Retrofit service
            val apps = CommCareNetwork.apps.getApps(projectName)
            // store the fetched apps in the Room database
            database.commCareAppDAO.insertAll(apps.asDatabaseModel())
        }

    }
}