package com.kuyodynamics.commcaresurveymanager.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.kuyodynamics.commcaresurveymanager.database.entities.CommCareQuestion

@Dao
interface CommCareQuestionDAO {
    @Insert(onConflict = REPLACE)
    fun insert(commCareQuestion: CommCareQuestion)

    @Update
    fun update(commCareQuestion: CommCareQuestion)

    @Query("SELECT * FROM commcare_question WHERE value = :questionId")
    fun get(questionId: String): LiveData<List<CommCareQuestion>>?

    @Query("SELECT * FROM commcare_question WHERE form_id = :formId")
    fun getFormQuestions(formId: String): LiveData<List<CommCareQuestion>>?
}