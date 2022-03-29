package com.kuyodynamics.commcaremodulemanager.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.PrimaryKey

@Entity(
    tableName = "commcare_form", foreignKeys = [
        ForeignKey(
            entity = CommCareModule::class,
            parentColumns = ["moduleId"],
            childColumns = ["moduleId"],
            onDelete = CASCADE
        )
    ]
)
data class CommCareForm(
    @PrimaryKey
    @ColumnInfo(name = "form_id")
    var formId: String,

    @ColumnInfo(name = "module_id")
    var moduleId: String,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "xmlns")
    var xmlns: String
)
