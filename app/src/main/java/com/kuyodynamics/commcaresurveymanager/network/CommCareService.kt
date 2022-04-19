package com.kuyodynamics.commcaresurveymanager.network

import com.kuyodynamics.commcaresurveymanager.domain.LoggedInUser
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*
import java.io.IOException
import java.util.*

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
    @GET("a/{domainName}/api/v0.5/application")
    suspend fun getApps(
        @Path("domainName") domainName: String
    ): NetworkCommCareAppContainer

    /**
     * Get a list of CommCare Projects, a user is a part of, from the api
     */
    @GET("api/v0.5/user_domains/")
    suspend fun getProjects(): NetworkCommCareProjectContainer


    /**
     * Login to CommCare
     */
    @FormUrlEncoded
    @POST("a/{domainName}/api/v0.5/sso")
    suspend fun singleSignOn(
        @Field("username") username: String,
        @Field("password") password: String,
        @Path("domainName") domainName: String
    ): NetworkCommCareUserContainer
}

/**
 * Main entry point for network access. Call like `CommCareNetwork.api.getApps
 */
object CommCareNetwork {
    // Configure retrofit to parse JSON and use coroutines
    private val retrofit = Retrofit.Builder().baseUrl("https://www.commcarehq.org/")
        .addConverterFactory(MoshiConverterFactory.create()).build()

    val api = retrofit.create(CommCareService::class.java)
}

