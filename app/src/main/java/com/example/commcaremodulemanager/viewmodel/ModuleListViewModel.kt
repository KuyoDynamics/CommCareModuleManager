package com.example.commcaremodulemanager.viewmodel

import androidx.lifecycle.ViewModel
import timber.log.Timber

class ModuleListViewModel : ViewModel() {
    init {
        Timber.i("ModuleListViewModel", "ModuleListViewModel created!")
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("ModuleListViewModel", "ModuleListViewModel destroyed!")
    }
}