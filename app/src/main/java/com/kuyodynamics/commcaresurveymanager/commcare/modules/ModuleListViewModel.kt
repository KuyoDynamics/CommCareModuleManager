package com.kuyodynamics.commcaresurveymanager.commcare.modules

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kuyodynamics.commcaresurveymanager.database.entities.CommCareApp
import com.kuyodynamics.commcaresurveymanager.database.entities.CommCareModule
import timber.log.Timber

// This is the state that the recyclerView adaptor will call
data class ModuleItemUiState(
    val moduleId: String,
    val appId: String,
    val name: String,
    val caseType: String,
    val caseProperties: List<String>,
    val onToggleModule: () -> Unit,
    val onWindowChange: () -> Unit,
    val onSave: () -> Unit,
    val onView: () -> Unit
)

class ModuleListViewModel : ViewModel() {

    private val _appModule = MutableLiveData<CommCareModule?>()
    val appModule: LiveData<CommCareModule?>
        get() = _appModule

    private val _appModuleList = MutableLiveData<MutableList<CommCareModule>>()
    val appModuleList: LiveData<MutableList<CommCareModule>>
        get() = _appModuleList

    private val _commcareApp = MutableLiveData<CommCareApp?>()
    val commCareApp: LiveData<CommCareApp?>
        get() = _commcareApp

    init {
//        Reset the list here
        Timber.i("ModuleListViewModel created!")
//        initialize appModule
//        _appModule.value = null
//        appModuleList.value = null
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("ModuleListViewModel destroyed!")
    }
}