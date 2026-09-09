package com.sam.multilanguagesupport.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.sam.multilanguagesupport.multi_language_support.Language
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

val Context.dataStore: DataStore<Preferences> by preferencesDataStore("settings")
class DatastoreManager @Inject constructor(
    @ApplicationContext private val context: Context
){
    val languageCodeKey = stringPreferencesKey("language_code_key")

    val language: Flow<Language> = context.dataStore.data.map{ preference ->
        val languageCode = preference[languageCodeKey]
        Language.entries.firstOrNull { it.code == languageCode } ?: Language.English
    }
    suspend fun saveLanguageCode(language: Language){
        context.dataStore.edit { preference ->
            preference[languageCodeKey] = language.code
        }
    }
}