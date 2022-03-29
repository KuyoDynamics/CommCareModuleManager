package com.kuyodynamics.commcaremodulemanager.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kuyodynamics.commcaremodulemanager.database.CommCareApp
import com.kuyodynamics.commcaremodulemanager.database.CommCareModule
import timber.log.Timber

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