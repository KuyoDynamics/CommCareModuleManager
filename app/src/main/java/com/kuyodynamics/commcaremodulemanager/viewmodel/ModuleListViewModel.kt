package com.kuyodynamics.commcaremodulemanager.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kuyodynamics.commcaremodulemanager.database.CommCareApp
import com.kuyodynamics.commcaremodulemanager.database.CommCareModule
import timber.log.Timber

class ModuleListViewModel : ViewModel() {

    val appModule = MutableLiveData<CommCareModule?>()
    val appModuleList = mutableListOf<CommCareModule?>()
    val commcareApp = MutableLiveData<CommCareApp?>()
    init {
//        Reset the list here
        Timber.i("ModuleListViewModel created!")
//        initialize appModule
        appModule.value =null
//        appModuleList.value = null
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("ModuleListViewModel destroyed!")
    }
}