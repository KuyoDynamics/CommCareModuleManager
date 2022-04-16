package com.kuyodynamics.commcaresurveymanager.repository

import androidx.lifecycle.LiveData
import com.kuyodynamics.commcaresurveymanager.database.SurveyManagerDatabase
import com.kuyodynamics.commcaresurveymanager.database.entities.CommCareApp
import com.kuyodynamics.commcaresurveymanager.network.CommCareNetwork
import com.kuyodynamics.commcaresurveymanager.network.CommCareService
import com.kuyodynamics.commcaresurveymanager.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CommCareAppRepo(private val database: SurveyManagerDatabase) {

    // get apps from network and update local DB(room)
    suspend fun refreshApps(projectName: String){

        withContext(Dispatchers.IO){
            // fetch the Apps list from the network using the Retrofit service
            val appList = CommCareNetwork.apps.getApps(projectName)
            // store the fetched apps in the Room database
            database.commCareAppDAO.insertAll(appList.asDatabaseModel())
        }
    }

    // Retrieve data from the local database as store it memory as Domain Model
    val apps: LiveData<List<CommCareApp>> = database.commCareAppDAO.getAllApps()

}