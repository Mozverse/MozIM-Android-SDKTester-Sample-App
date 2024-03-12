package com.mozverse.mozimtestapp.presentation.features.session.add

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.mozverse.mozimtestapp.R
import com.mozverse.mozimtestapp.domain.usecase.DataState
import com.mozverse.mozimtestapp.presentation.components.BaseTopAppBar
import com.mozverse.mozimtestapp.presentation.vastlist.ui.theme.MozimTestAppTheme


@Composable
fun AddSessionScreen(
    startUrl: String? = null,
    navController: NavController,
    addSessionViewModel: AddSessionViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            BaseTopAppBar(
                titleText = stringResource(id = R.string.screen_title_add_session),
                onNavigationButtonClick = {
                    navController.navigateUp()
                }
            )
        },
    ) { paddingValues ->

        val dataState = addSessionViewModel.sessionState.collectAsStateWithLifecycle()

        AddSessionScreenContent(
            dataState = dataState.value,
            modifier = Modifier.padding(paddingValues),
            startUrl = startUrl ?: "",
            onSubmitClicked = { url ->
                addSessionViewModel.importUrl(url)
            },
            onAddBuiltInUrlsClicked = {
                addSessionViewModel.importBuiltInUrls()
            }
        )
    }
}

@Composable
fun AddSessionScreenContent(
    dataState: DataState<Any>,
    startUrl: String,
    modifier: Modifier = Modifier,
    onSubmitClicked: (String) -> Unit = {},
    onAddBuiltInUrlsClicked: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var url by rememberSaveable { mutableStateOf(startUrl) }

        OutlinedTextField(
            singleLine = false,
            value = url,
            onValueChange = { url = it },
            label = { Text(text = stringResource(id = R.string.label_url)) }
        )
        Spacer(modifier = Modifier.height(32.dp))
        when {
            dataState.isLoading() -> CircularProgressIndicator()
            dataState.isSuccess() -> Icon(
                modifier = Modifier.size(64.dp),
                imageVector = Icons.Default.CheckCircle,
                tint = Color.Green,
                contentDescription = stringResource(
                    id = R.string.report_success_adding_xml_from_url
                ),
            )

            else -> Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = { onSubmitClicked(url) }
                ) {
                    Text(text = stringResource(id = R.string.button_submit))
                }
                Spacer(modifier = Modifier.height(32.dp))
                Button(
                    onClick = { onAddBuiltInUrlsClicked() }
                ) {
                    Text(text = stringResource(id = R.string.button_add_built_in_urls))
                }
            }
        }
    }
}

@Preview(name = "Light Mode", showBackground = true)
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_UNDEFINED, showBackground = true)
@Composable
fun AddSessionScreenContentPreview() {
    MozimTestAppTheme {
        AddSessionScreenContent(
            dataState = DataState.EmptyData(),
            startUrl = "https://",
        )
    }
}