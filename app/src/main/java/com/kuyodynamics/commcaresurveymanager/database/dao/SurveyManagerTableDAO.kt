package com.kuyodynamics.commcaresurveymanager.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.kuyodynamics.commcaresurveymanager.database.entities.SurveyManagerTable

@Dao
interface SurveyManagerTableDAO {

    // We enforce upsert for idempotency
    @Insert(onConflict = REPLACE)
    fun insert(surveyManagerTable: SurveyManagerTable)

    @Update
    fun update(surveyManagerTable: SurveyManagerTable)

    @Query("SELECT * FROM survey_manager_table WHERE id = :id LIMIT 1")
    fun getSurveyConfig(id: String): LiveData<SurveyManagerTable>?

    @Query("SELECT * FROM survey_manager_table WHERE app_id = :appId")
    fun getAppSurveyManagerTable(appId: String): LiveData<List<SurveyManagerTable>>?

}