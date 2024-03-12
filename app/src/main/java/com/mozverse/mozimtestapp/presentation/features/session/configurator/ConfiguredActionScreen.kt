package com.mozverse.mozimtestapp.presentation.features.session.configurator

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.mozverse.mozim.domain.data.action.IMActionType
import com.mozverse.mozim.domain.data.config.IMXMLType
import com.mozverse.mozim.domain.data.trigger.IMTriggerType
import com.mozverse.mozimtestapp.R
import com.mozverse.mozimtestapp.data.extensions.capitalizeFirst
import com.mozverse.mozimtestapp.domain.usecase.DataState
import com.mozverse.mozimtestapp.presentation.components.BaseTopAppBar
import com.mozverse.mozimtestapp.presentation.components.FullScreenLoader
import com.mozverse.mozimtestapp.presentation.features.session.configurator.components.TriggerTypeSelector
import com.mozverse.mozimtestapp.presentation.features.session.configurator.components.XmlTypeSelector
import com.mozverse.mozimtestapp.presentation.features.session.configurator.data.ActionBuilderData
import com.mozverse.mozimtestapp.presentation.vastlist.ui.theme.MozimTestAppTheme


@Composable
fun ActionBuilderScreen(
    navController: NavController,
    viewModel: ConfiguredActionsViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            BaseTopAppBar(
                titleText = stringResource(id = R.string.screen_title_action_builder),
                onNavigationButtonClick = {
                    navController.navigateUp()
                }
            )
        },
    ) { paddingValues ->

        val dataState = viewModel.configuratorSettingsState.collectAsStateWithLifecycle()

        ActionBuilderScreenContent(
            dataState = dataState.value,
            modifier = Modifier.padding(paddingValues),
            onStartActionClicked = { viewModel.startAction(it) },
            onTriggerTypeSelected = { viewModel.setSelectedTriggerType(it) },
            onXmlTypeSelected = { viewModel.setSelectedXmlType(it) },
            onIsUsingAdIdClicked = { viewModel.setIsUsingAdId(it) }
        )
    }
}

@Composable
fun ActionBuilderScreenContent(
    dataState: DataState<ActionBuilderData>,
    modifier: Modifier = Modifier,
    onStartActionClicked: (IMActionType) -> Unit = {},
    onTriggerTypeSelected: (IMTriggerType) -> Unit = {},
    onXmlTypeSelected: (IMXMLType) -> Unit = {},
    onIsUsingAdIdClicked: (Boolean) -> Unit = {}
) {
    when (dataState) {
        is DataState.Loading -> FullScreenLoader()
        is DataState.Success -> {
            Column(verticalArrangement = Arrangement.Top, modifier = modifier.fillMaxSize()) {
                TriggerTypeSelector(
                    selectedTriggerType = dataState.data.triggerType,
                    onTriggerTypeSelected = { onTriggerTypeSelected(it) }
                )
                XmlTypeSelector(
                    selectedXmlType = dataState.data.xmlType,
                    onXmlTypeSelected = { onXmlTypeSelected(it) }
                )
//                IsUsingAdIdSelector(
//                    isUsingAdId = dataState.data.isUsingAdId,
//                    onIsUsingAdIdClicked = { onIsUsingAdIdClicked(it) }
//                )
                LazyVerticalGrid(
                    modifier = Modifier.fillMaxSize(),
                    columns = GridCells.Fixed(2),
                    verticalArrangement = Arrangement.Center,
                    horizontalArrangement = Arrangement.Center
                ) {
                    items(dataState.data.actionTypes) { actionType ->
                        ElevatedButton(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp, horizontal = 16.dp),
                            onClick = { onStartActionClicked(actionType) }
                        ) {
                            Text(
                                text = actionType.action.capitalizeFirst(),
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                    }
                }
            }
        }

        is DataState.Error -> {
            //todo: implement error
        }

        is DataState.EmptyData -> {
            //todo: implement empty screen
        }
    }
}

@Preview(name = "Light Mode", showBackground = true)
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_UNDEFINED, showBackground = true)
@Composable
fun ConfiguredActionScreenContentPreview() {
    MozimTestAppTheme {
        ActionBuilderScreenContent(
            dataState = DataState.Success(ActionBuilderData())
        )
    }
}