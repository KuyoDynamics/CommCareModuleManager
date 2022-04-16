package com.kuyodynamics.commcaresurveymanager.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.Companion.REPLACE
import com.kuyodynamics.commcaresurveymanager.database.entities.CommCareApp

@Dao
interface CommCareAppDAO {
    @Insert(onConflict = REPLACE)
    fun insert(commcareApp: CommCareApp)

    @Insert(onConflict = REPLACE)
    fun insertAll(commcareApps: List<CommCareApp>)

    @Update
    fun update(commcareApp: CommCareApp)

    @Query("SELECT * FROM commcare_app WHERE app_id = :appId")
    fun get(appId: String): LiveData<CommCareApp>?

    @Query("DELETE FROM commcare_app")
    fun clear()

    @Query("SELECT * FROM commcare_app ORDER BY name DESC")
    fun getAllApps(): LiveData<List<CommCareApp>>?
}