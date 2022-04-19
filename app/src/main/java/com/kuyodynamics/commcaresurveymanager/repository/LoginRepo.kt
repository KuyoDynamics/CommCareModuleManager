package com.kuyodynamics.commcaresurveymanager.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.kuyodynamics.commcaresurveymanager.database.SurveyManagerDatabase
import com.kuyodynamics.commcaresurveymanager.database.entities.asDomainModel
import com.kuyodynamics.commcaresurveymanager.domain.LoggedInUser
import com.kuyodynamics.commcaresurveymanager.network.CommCareNetwork
import com.kuyodynamics.commcaresurveymanager.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */
class LoginRepo(private val database: SurveyManagerDatabase) {
    // Retrieve user from local DB as LiveData object
    val user: LiveData<LoggedInUser>? =
        Transformations.map(database.commCareUserDAO.getLoggedInUser()) {
            it.asDomainModel()
        }

    suspend fun logout() {
        withContext(Dispatchers.IO) {
            // clear user from local DB
            user?.value?.let { database.commCareUserDAO.logout(it.id) }
        }
    }

    suspend fun login(username: String, password: String, domainName: String) {
        // get user from network and update local DB(room), if successful
        withContext(Dispatchers.IO) {
            // attempt to login to commcare using the Retrofit service
            val result = CommCareNetwork.api.singleSignOn(username, password, domainName)

            // if (result is ResultDTO.Success) {
            if (result != null) {
                // store the fetched user in the Room database
                val encoded = android.util.Base64.encodeToString(
                    "$username:$password".toByteArray(),
                    android.util.Base64.DEFAULT
                )
                val token = "Basic $encoded"
                database.commCareUserDAO.insert(result.asDatabaseModel(token))
            }

            // otherwise show auth errorData?

        }
    }
}