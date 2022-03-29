package com.kuyodynamics.commcaremodulemanager.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.PrimaryKey


@Entity(
    tableName = "commcare_module", foreignKeys = [
        ForeignKey(
            entity = CommCareApp::class,
            parentColumns = ["appId"],
            childColumns = ["appId"],
            onDelete = CASCADE
        )
    ]
)
data class CommCareModule(

    @PrimaryKey()
    @ColumnInfo(name = "module_id")
    var moduleId: String,

    @ColumnInfo(name = "app_id")
    var appId: String,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "case_type")
    var caseType: String,

    @ColumnInfo(name = "case_properties")
    var caseProperties: List<String>
)
