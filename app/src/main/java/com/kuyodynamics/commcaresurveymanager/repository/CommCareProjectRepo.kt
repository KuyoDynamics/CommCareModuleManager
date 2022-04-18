package com.kuyodynamics.commcaresurveymanager.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.kuyodynamics.commcaresurveymanager.database.SurveyManagerDatabase
import com.kuyodynamics.commcaresurveymanager.database.entities.asDomainModelList
import com.kuyodynamics.commcaresurveymanager.domain.App
import com.kuyodynamics.commcaresurveymanager.domain.Project
import com.kuyodynamics.commcaresurveymanager.network.CommCareNetwork
import com.kuyodynamics.commcaresurveymanager.network.asDatabaseModelList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CommCareProjectRepo(private val database: SurveyManagerDatabase) {

    // get projects from network and update local DB(room)
    suspend fun refreshProjects() {

        withContext(Dispatchers.IO) {
            // fetch the Projects list from the network using the Retrofit service
            val projectsList = CommCareNetwork.api.getProjects()
            // store the fetched projects in the Room database
            database.commCareProjectDAO.insertAll(projectsList.asDatabaseModelList())
        }
    }

    // Retrieve data from the local database and store it in memory as Domain Model
    val projects: LiveData<List<Project>> = Transformations.map(database.commCareProjectDAO.getAll()) {
        it.asDomainModelList()
    }

}