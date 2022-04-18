package com.kuyodynamics.commcaresurveymanager.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.kuyodynamics.commcaresurveymanager.database.entities.CommCareApp
import com.kuyodynamics.commcaresurveymanager.database.entities.CommCareProject

@Dao
interface CommCareProjectDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(commcareProject: CommCareProject)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(commcareProjects: List<CommCareProject>)

    @Update
    fun update(commcareProject: CommCareProject)

    @Query("SELECT * FROM commcare_project WHERE project_domain = :projectDomain")
    fun get(projectDomain: String): LiveData<CommCareProject>

    @Query("DELETE FROM commcare_project")
    fun clear()

    @Query("SELECT * FROM commcare_project ORDER BY project_name DESC")
    fun getAll(): LiveData<List<CommCareProject>>

}