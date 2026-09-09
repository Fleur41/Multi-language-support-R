package com.sam.multilanguagesupport.datastore

import javax.inject.Inject
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sam.multilanguagesupport.multi_language_support.Language
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@HiltViewModel
class MultilanguageScreenViewModel @Inject constructor(
    private  val datastoreRepository: DatastoreRepository
): ViewModel() {
    val language: StateFlow<Language> = datastoreRepository.language
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Companion.Eagerly,
            initialValue = Language.English
        )

    fun saveLanguage(language: Language){
        viewModelScope.launch(Dispatchers.IO) {
            datastoreRepository.saveLanguageCode(language)
        }
    }
}