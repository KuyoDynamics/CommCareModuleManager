package com.kuyodynamics.commcaresurveymanager.network

import com.kuyodynamics.commcaresurveymanager.database.entities.CommCareApp
import com.kuyodynamics.commcaresurveymanager.database.entities.CommCareProject
import com.squareup.moshi.JsonClass
import java.util.*

/**
 * DataTransferObjects go in this file. These are responsible for parsing responses from the server
 * or formatting objects to send to the server. You should convert these to domain objects before
 * using them.
 *
 * @see domain package for
 */

/**
 * ProjectsHolder holds a list of Projects.
 *
 * This is a parse first level of our network result which looks like
 *
 * {
 *      "meta": {},
 *      "objects": [
 *          {
 *          }
 *      ]
 * }
 *
 * But I just want to return a list of projects without meta
 */
@JsonClass(generateAdapter = true)
data class NetworkCommCareProjectContainer(val projects: NetworkCommCareProjectResponse)

/**
 * CommCareApp
 */
@JsonClass(generateAdapter = true)
data class NetworkCommCareProjectResponse(
    val meta: Any,
    val objects: List<NetworkCommCareProject>
)

/**
 * Network CommCareApp format
 */
@JsonClass(generateAdapter = true)
data class NetworkCommCareProject(
    var domainName: String,
    var projectName: String
)

/**
 * Convert Network results to database objects via Extension function
 */
fun NetworkCommCareProjectContainer.asDatabaseModelList(): List<CommCareProject> {
    return projects.objects.map {
        CommCareProject(
            projectName = it.projectName,
            domainName = it.domainName
        )
    }
}
