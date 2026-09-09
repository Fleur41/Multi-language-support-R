package com.sam.multilanguagesupport.multi_language_support

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sam.multilanguagesupport.datastore.DatastoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MultilanguageScreenViewModel @Inject constructor(
    private  val datastoreRepository: DatastoreRepository
): ViewModel() {
    val language: StateFlow<Language> = datastoreRepository.language
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = Language.English
        )

    fun saveLanguage(language: Language){
        viewModelScope.launch(Dispatchers.IO) {
            datastoreRepository.saveLanguageCode(language)
        }
    }
}