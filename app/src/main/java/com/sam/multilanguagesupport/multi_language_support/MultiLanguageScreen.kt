package com.sam.multilanguagesupport.multi_language_support

import android.R.attr.label
import android.R.attr.onClick
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import com.sam.multilanguagesupport.R
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sam.multilanguagesupport.datastore.MultilanguageScreenViewModel
import com.sam.multilanguagesupport.multi_language_support.ResourceManager.updateResources

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MultiLanguageScreen(
    viewModel: MultilanguageScreenViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    fun updateLanguage(language: Language){
//        context.updateResources(language)
        viewModel.saveLanguage(language)
    }

    val currentLanguage by viewModel.language.collectAsState()
    val english by remember (currentLanguage ){ mutableIntStateOf(R.string.language_english) }
    val swahili by remember (currentLanguage ){ mutableIntStateOf(R.string.language_swahili) }
    val title by remember (currentLanguage ){ mutableIntStateOf(R.string.multi_language_screen_title) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(title)) }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
           Text(text = stringResource(R.string.select_your_desired_language))
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                AssistChip(
                    onClick = {
                        updateLanguage(Language.English)
                },
                   label = {
                       Text(text = stringResource(english))
                   },
                    colors = AssistChipDefaults.assistChipColors(
                        containerColor = if (currentLanguage == Language.English) MaterialTheme.colorScheme.primary.copy(alpha = 0.5f) else Color.White
                    )
                )


                Spacer(modifier = Modifier.width(16.dp))
                AssistChip(
                    onClick = {
                        updateLanguage(Language.Swahili)
                },
                    label = {
                        Text(text = stringResource(swahili))
                    },
                    colors = AssistChipDefaults.assistChipColors(
                        containerColor = if (currentLanguage == Language.Swahili) Color.Gray else Color.White
                    )
                )
            }
        }
    }
}