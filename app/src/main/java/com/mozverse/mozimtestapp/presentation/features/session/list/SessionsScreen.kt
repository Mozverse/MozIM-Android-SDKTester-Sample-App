package com.mozverse.mozimtestapp.presentation.features.session.list

import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.mozverse.mozimtestapp.R
import com.mozverse.mozimtestapp.data.previewSessionList
import com.mozverse.mozimtestapp.domain.data.Session
import com.mozverse.mozimtestapp.domain.usecase.DataState
import com.mozverse.mozimtestapp.presentation.components.BaseScaffold
import com.mozverse.mozimtestapp.presentation.components.ErrorReport
import com.mozverse.mozimtestapp.presentation.components.FullScreenLoader
import com.mozverse.mozimtestapp.presentation.components.NoDataReport
import com.mozverse.mozimtestapp.presentation.features.session.list.components.InteractionList
import com.mozverse.mozimtestapp.presentation.vastlist.ui.theme.MozimTestAppTheme
import timber.log.Timber


@Composable
fun SessionsScreen(
    navController: NavController,
    onStartSessionForegrounded: (Session) -> Unit,
    sessionsViewModel: SessionsViewModel = hiltViewModel()
) {
    BaseScaffold(
        titleText = stringResource(id = R.string.screen_title_sessions),
        isHome = true,
        actions = {
            IconButton(
                onClick = { navController.navigate("action_builder") }
            ) {
                Icon(
                    imageVector = Icons.Default.Build,
                    contentDescription = stringResource(id = R.string.content_description_open_action_builder)
                )
            }
            IconButton(
                onClick = { navController.navigate("new_interaction") }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(id = R.string.content_description_add_new_interaction_from_url)
                )
            }
        },
    ) { paddingValues ->

        val sessionState by sessionsViewModel.sessionsState.collectAsStateWithLifecycle()

        SessionScreenContent(
            modifier = Modifier.padding(paddingValues),
            sessionState = sessionState,
            onDeleteSessionClicked = { sessionsViewModel.deleteSession(it) },
            onStartSessionClicked = { sessionsViewModel.startSession(it) },
            onStartSessionForegroundedClicked = { onStartSessionForegrounded(it) }
        )
    }
}

@Composable
fun SessionScreenContent(
    modifier: Modifier = Modifier,
    sessionState: DataState<List<Session>>,
    onDeleteSessionClicked: (Session) -> Unit = {},
    onStartSessionClicked: (Session) -> Unit = {},
    onStartSessionForegroundedClicked: (Session) -> Unit = {},
) {
    Surface(modifier = modifier) {
        when (sessionState) {
            is DataState.Loading -> {
                FullScreenLoader()
            }

            is DataState.Success -> InteractionList(
                sessions = sessionState.data,
                onDeleteSessionClicked = {
                    // todo: delete
                    Timber.d("calling delete session from Sessions screen")
                    onDeleteSessionClicked(it)
                },
                onStartSessionClicked = { session ->
                    onStartSessionClicked(session)
                },
                onStartSessionForegroundedClicked = { session ->
                    onStartSessionForegroundedClicked(session)
                }

            )

            is DataState.Error -> {
                ErrorReport(sessionState.exception)
            }

            is DataState.EmptyData -> NoDataReport()
        }
    }
}

@Preview(name = "Light Mode", showBackground = true)
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_UNDEFINED, showBackground = true)
@Composable
fun SessionsScreenContentPreview() {
    MozimTestAppTheme {
        SessionScreenContent(
            sessionState = DataState.Success(
                previewSessionList()
            ),
        )
    }
}