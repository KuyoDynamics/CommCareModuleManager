package com.kuyodynamics.commcaremodulemanager.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "commcare_app")
data class CommCareApp(
    @PrimaryKey()
    @ColumnInfo(name = "app_id")
    var appId: String,

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
