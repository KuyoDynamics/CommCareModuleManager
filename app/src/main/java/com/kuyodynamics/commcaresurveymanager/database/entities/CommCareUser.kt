package com.kuyodynamics.commcaresurveymanager.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "commcare_user")
data class CommCareUser(
    @PrimaryKey()
    @ColumnInfo(name = "id")
    var id: String,

    @ColumnInfo(name = "token")
    var token: String,

    @ColumnInfo(name = "username")
    var username: String,

    @ColumnInfo(name = "email")
    var email: String,

    @ColumnInfo(name = "last_name")
    var lastName: String,

    @ColumnInfo(name = "first_name")
    var firstName: String,

    @ColumnInfo(name = "is_admin")
    var isAdmin: Boolean,

    @ColumnInfo(name = "role")
    var role: String
)
