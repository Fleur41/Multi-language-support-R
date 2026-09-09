package com.sam.multilanguagesupport.datastore

import com.sam.multilanguagesupport.multi_language_support.Language
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DatastoreRepository @Inject constructor(
    private val datastoreManager: DatastoreManager
) {
    val language: Flow<Language> = datastoreManager.language

    suspend fun saveLanguageCode(language: Language){
        datastoreManager.saveLanguageCode(language)
    }

}