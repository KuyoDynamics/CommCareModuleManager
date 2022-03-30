package com.kuyodynamics.commcaremodulemanager.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.Companion.REPLACE
import com.kuyodynamics.commcaremodulemanager.database.entities.CommCareUser

@Dao
interface CommCareUserDAO {

    @Insert(onConflict = REPLACE)
    fun insert(commCareUser: CommCareUser)

    @Update
    fun update(commCareUser: CommCareUser)

    @Query("SELECT * FROM commcare_user WHERE id = :id")
    fun get(id: String): LiveData<CommCareUser>?

    @Query("SELECT token FROM commcare_user WHERE id = :id")
    fun getToken(id: String): LiveData<String>?

    @Query("DELETE commcare_user WHERE id = :id")
    fun logout(id: String)
}