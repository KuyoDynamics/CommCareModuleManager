package com.kuyodynamics.commcaresurveymanager.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.kuyodynamics.commcaresurveymanager.database.entities.CommCareUser

@Dao
interface CommCareUserDAO {

    @Insert(onConflict = REPLACE)
    fun insert(commCareUser: CommCareUser)

    @Update
    fun update(commCareUser: CommCareUser)

    @Query("SELECT * FROM commcare_user WHERE id = :id")
    fun get(id: String): LiveData<CommCareUser>

    @Query("SELECT * FROM commcare_user LIMIT 1")
    fun getLoggedInUser(): LiveData<CommCareUser>

    @Query("DELETE FROM commcare_user WHERE id = :id")
    fun logout(id: String)
}