package com.kuyodynamics.commcaresurveymanager.network

import com.kuyodynamics.commcaresurveymanager.database.entities.CommCareUser
import com.kuyodynamics.commcaresurveymanager.domain.LoggedInUser
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkCommCareUserContainer(val response: NetworkCommCareUserResponse)

@JsonClass(generateAdapter = true)
data class NetworkCommCareUserResponse(
    val meta: Meta,
    val objects: List<Object>
)

@JsonClass(generateAdapter = true)
data class Meta(
    val limit: Int,
    val next: Any,
    val offset: Int,
    val previous: Any,
    val total_count: Int
)

@JsonClass(generateAdapter = true)
data class Object(
    val default_phone_number: Any,
    val email: String,
    val first_name: String,
    val id: String,
    val is_admin: Boolean,
    val last_name: String,
    val permissions: Permissions,
    val phone_numbers: List<Any>,
    val resource_uri: String,
    val role: String,
    val username: String
)

@JsonClass(generateAdapter = true)
data class Permissions(
    val doc_type: String,
    val edit_apps: Boolean,
    val edit_commcare_users: Boolean,
    val edit_data: Boolean,
    val edit_web_users: Boolean,
    val view_report_list: List<Any>,
    val view_reports: Boolean
)

/**
 * Convert Network results to database objects via Extension function
 */
fun NetworkCommCareUserContainer.asDatabaseModel(token:String): CommCareUser{
    val user = response.objects[0]
    return CommCareUser(
        id = user.id,
        token = token,
        username = user.username,
        email = user.email,
        lastName = user.last_name,
        firstName = user.first_name,
        isAdmin = user.is_admin,
        role = user.role
    )
}

/**
 * Extension function to cast user as DomainModel
 */
fun NetworkCommCareUserContainer.asDomainModel(token: String): LoggedInUser {
    val user = response.objects[0]
    return LoggedInUser(
        id = user.id,
        token = token,
        lastName = user.last_name,
        firstName = user.first_name
    )
}
