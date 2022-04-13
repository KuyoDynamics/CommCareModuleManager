package com.kuyodynamics.commcaresurveymanager.commcare.modules

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kuyodynamics.commcaresurveymanager.database.entities.CommCareApp
import com.kuyodynamics.commcaresurveymanager.database.entities.CommCareModule
import timber.log.Timber

// This is the state that the recyclerView adaptor will call
// This way, the RecyclerView adaptor only works with the data
// it needs: the list of ModuleItemUiState objects
// Only the fragment class works with the ViewModel
// This ensures that UI-specific objects like views or RecyclerView adaptors
// do not interact directly with the ViewModel
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
// The ViewModel contains business logic and converts the results from lower layers of the hierarchy into UI state.
class ModuleListViewModel : ViewModel(
//    The viewModel should now accept a repository
) {

    private val _appModule = MutableLiveData<CommCareModule?>()
    val appModule: LiveData<CommCareModule?>
        get() = _appModule

    private val _appModuleList = MutableLiveData<MutableList<CommCareModule>>()
    val appModuleList: LiveData<MutableList<CommCareModule>>
        get() = _appModuleList

    private val _commcareApp = MutableLiveData<CommCareApp?>()
    val commCareApp: LiveData<CommCareApp?>
        get() = _commcareApp

//    Implement this type  of logic:
//val newsListUiItems = repository.latestNews.map { news ->
//    NewsItemUiState(
//        title = news.title,
//        body = news.body,
//        bookmarked = news.bookmarked,
//        publicationDate = formatDateUseCase(news.publicationDate),
//        // Business logic is passed as a lambda function that the
//        // UI calls on click events.
//        onBookmark = {
//            repository.addBookmark(news.id)
//        }
//    )
//}
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