package com.kuyodynamics.commcaresurveymanager.viewmodels.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kuyodynamics.commcaresurveymanager.SurveyManagerApp
import com.kuyodynamics.commcaresurveymanager.database.SurveyManagerDatabase
import com.kuyodynamics.commcaresurveymanager.repository.LoginRepo

/**
 * Study more of this
 * ViewModel provider factory to instantiate LoginViewModel.
 * Required given LoginViewModel has a non-empty constructor
 */
class LoginViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(
                loginRepo = LoginRepo(
                    database = SurveyManagerDatabase.getInstance(SurveyManagerApp.context)
                )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}