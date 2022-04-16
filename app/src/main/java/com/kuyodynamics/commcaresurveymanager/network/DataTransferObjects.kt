package com.kuyodynamics.commcaresurveymanager.network

import androidx.room.ColumnInfo
import com.kuyodynamics.commcaresurveymanager.database.entities.CommCareApp
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
 * AppsHolder holds a list of Apps.
 *
 * This is a parse first level of our network result which looks like
 *
 * {
 *      "meta": {},
 *      "objects": [
 *          {
 *              "id": "some_id",
 *              ...,
 *              "modules": []
 *          }
 *      ]
 * }
 *
 * But I just want to return a list of Apps that look like {id: "some_id", name: "some_app_name"}
 */
@JsonClass(generateAdapter = true)
data class NetworkCommCareAppContainer(val apps: NetworkCommCareAppResponse)

/**
 * CommCareApp
 */
@JsonClass(generateAdapter = true)
data class NetworkCommCareAppResponse(
    val meta: Any,
    val objects: List<NetworkCommCareApp>
)

/**
 * Network CommCareApp format
 */
@JsonClass(generateAdapter = true)
data class NetworkCommCareApp(
    val build_comment: String,
    val built_from_app_id: Any,
    val built_on: String,
    val id: String,
    val is_released: Boolean,
    val modules: List<Any>,
    val name: String,
    val resource_uri: String,
    val version: Int,
    val versions: List<Any>
)
/**
 * Convert Network results to database objects via Extesnion function
 */
fun NetworkCommCareAppContainer.asDatabaseModel(): List<CommCareApp> {
    return apps.objects.map {
        CommCareApp(
            appId = it.id,
            name = it.name,
            buildComment = it.build_comment,
            builtOn = it.built_on as Date,
            isReleased = it.is_released,
            version = it.version
        )
    }
}