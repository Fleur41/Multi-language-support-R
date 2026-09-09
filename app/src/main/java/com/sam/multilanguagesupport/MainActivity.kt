package com.sam.multilanguagesupport

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.sam.multilanguagesupport.multi_language_support.MultilanguageScreenViewModel
import com.sam.multilanguagesupport.multi_language_support.MultiLanguageScreen
import com.sam.multilanguagesupport.multi_language_support.ResourceManager.updateResources
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewModel by viewModels<MultilanguageScreenViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultiLanguageScreen()
        }

        lifecycleScope.launch{
            viewModel.language.collect { language ->
                this@MainActivity.updateResources(language)
            }
        }
    }
}

