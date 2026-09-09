package com.sam.multilanguagesupport

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.sam.multilanguagesupport.datastore.MultilanguageScreenViewModel
import com.sam.multilanguagesupport.multi_language_support.MultiLanguageScreen
import com.sam.multilanguagesupport.multi_language_support.ResourceManager.updateResources
import com.sam.multilanguagesupport.ui.theme.MultiLanguageSupportTheme
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

