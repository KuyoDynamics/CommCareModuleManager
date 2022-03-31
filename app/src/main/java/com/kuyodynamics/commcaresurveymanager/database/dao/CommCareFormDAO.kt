package com.kuyodynamics.commcaresurveymanager.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.kuyodynamics.commcaresurveymanager.database.entities.CommCareForm

@Dao
interface CommCareFormDAO {
    @Insert(onConflict = REPLACE)
    fun insert(commcareForm: CommCareForm)

    @Update
    fun update(commcareForm: CommCareForm)

    @Query("SELECT * FROM commcare_form WHERE form_id = :formId")
    fun get(formId: String): LiveData<CommCareForm>?

    @Query("SELECT * FROM commcare_form WHERE module_id = :moduleId")
    fun getModuleForms(moduleId: String): LiveData<List<CommCareForm>>?

}