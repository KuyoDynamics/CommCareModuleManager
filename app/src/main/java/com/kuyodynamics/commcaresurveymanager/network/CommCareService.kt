package com.kuyodynamics.commcaresurveymanager.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * A retrofit service to fetch a list of CommCare Apps for a given user
 */
interface CommCareService {
//    baseUrl='https://www.commcarehq.org/a/'
//    project url= mira-rfms/api/v0.5/
//    projects url projects
//    login `${baseUrl}sso/
//     `application/${appId}`

    /**
     * Get a list of CommCare Apps from the api
     */
    @GET("a/{projectName}/api/v0.5/application")
    suspend fun getApps(
        @Path("projectName") projectName: String
    ): NetworkCommCareAppContainer

    /**
     * Get a list of CommCare Projects, a user is a part of, from the api
     */
    @GET("api/v0.5/user_domains/")
    suspend fun getProjects(): NetworkCommCareProjectContainer
}

/**
 * Main entry point for network access. Call like `CommCareNetwork.apps.getApps
 */
object CommCareNetwork {
    // Configure retrofit to parse JSON and use coroutines
    private val retrofit = Retrofit.Builder().baseUrl("https://www.commcarehq.org/")
        .addConverterFactory(MoshiConverterFactory.create()).build()

    val api = retrofit.create(CommCareService::class.java)
}