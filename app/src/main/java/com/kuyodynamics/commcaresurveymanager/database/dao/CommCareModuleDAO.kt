package com.kuyodynamics.commcaresurveymanager.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.kuyodynamics.commcaresurveymanager.database.entities.CommCareModule

@Dao
interface CommCareModuleDAO {
    @Insert(onConflict = REPLACE)
    fun insert(commcareModule: CommCareModule)

    @Update
    fun update(commcareModule: CommCareModule)

    @Query("SELECT * FROM commcare_module WHERE module_id = :moduleId")
    fun get(moduleId: String)

    @Query("SELECT * FROM commcare_module WHERE app_id = :appId")
    fun getAppModules(appId: String): LiveData<List<CommCareModule>>?
}