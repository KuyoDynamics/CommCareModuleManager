package com.kuyodynamics.commcaresurveymanager.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.PrimaryKey
import com.kuyodynamics.commcaresurveymanager.domain.App
import java.util.*

@Entity(tableName = "commcare_app", foreignKeys = [
    ForeignKey(
        entity = CommCareProject::class,
        parentColumns = ["projectDomain"],
        childColumns = ["projectDomain"],
        onDelete = CASCADE
    )
])
data class CommCareApp(
    @PrimaryKey()
    @ColumnInfo(name = "app_id")
    var appId: String,

    var projectDomain: String,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "build_comment")
    var buildComment: String,

    @ColumnInfo(name = "built_on")
    var builtOn: Date,

    @ColumnInfo(name = "is_released")
    var isReleased: Boolean,

    @ColumnInfo(name = "version")
    var version: Int
)

/**
 * [Extension Function] Map CommCareApps to domain entities
 */
fun List<CommCareApp>.asDomainModelList(): List<App>{
    return map{
        App(
            appId = it.appId,
            name = it.name,
            buildComment = it.buildComment,
            builtOn = it.builtOn,
            isReleased = it.isReleased,
            version = it.version
        )
    }
}