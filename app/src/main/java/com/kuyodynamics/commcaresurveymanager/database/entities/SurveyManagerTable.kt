package com.kuyodynamics.commcaresurveymanager.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.PrimaryKey

@Entity(
    tableName = "survey_manager_table", foreignKeys = [
        ForeignKey(
            entity = CommCareApp::class,
            parentColumns = ["appId"],
            childColumns = ["appId"],
            onDelete = CASCADE
        )
    ]
)
data class SurveyManagerTable(
    @PrimaryKey()
    @ColumnInfo(name = "id")
    var id: String,

    @ColumnInfo(name = "survey")
    var survey: String,

    @ColumnInfo(name = "app_id")
    var appId: String,

    @ColumnInfo(name = "collect")
    var collect: String,

    @ColumnInfo(name = "window")
    var window: Int,

    @ColumnInfo(name = "data_collection_round")
    var dataCollectionRound: Int,

    @ColumnInfo(name = "access_level")
    var accessLevel: String,

    @ColumnInfo(name = "last_configured", defaultValue = "CURRENT_TIMESTAMP")
    var lastConfigured: String,

    @ColumnInfo(name = "last_configured_by")
    var lastConfiguredBy: String
)
