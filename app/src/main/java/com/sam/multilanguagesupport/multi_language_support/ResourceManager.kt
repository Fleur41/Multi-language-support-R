package com.sam.multilanguagesupport.multi_language_support

import android.R.attr.resource
import android.content.Context
import java.util.Locale

object ResourceManager {
    fun Context.updateResources(language: Language){
        val locale = Locale(language.code).apply {
            Locale.setDefault(this)
        }
        val configuration = resources.configuration.apply {
            setLocale(locale)
            setLayoutDirection(locale)
        }

        resources.updateConfiguration(configuration, resources.displayMetrics)

    }
}