package com.mozverse.mozimtestapp.presentation.features.session.list.components


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mozverse.mozimtestapp.data.previewSessionList
import com.mozverse.mozimtestapp.domain.data.Session
import com.mozverse.mozimtestapp.presentation.vastlist.ui.theme.MozimTestAppTheme

@Composable
fun InteractionList(
    sessions: List<Session>,
    modifier: Modifier = Modifier,
    onDeleteSessionClicked: (Session) -> Unit = {},
    onStartSessionClicked: (Session) -> Unit = {},
    onStartSessionForegroundedClicked: (Session) -> Unit = {}
) {
    LazyColumn(
        modifier = modifier.fillMaxWidth()
    ) {
        items(sessions) { session ->
            SessionCard(
                session = session,
                onStartSessionClicked = { onStartSessionClicked(session) },
                onStartSessionForegroundedClicked = { onStartSessionForegroundedClicked(session)},
                onDeleteSessionClicked = { onDeleteSessionClicked(session) }
            )
        }
    }
}


@Preview
@Composable
fun InteractionListPreview() {
    MozimTestAppTheme {
        InteractionList(
            previewSessionList()
        )
    }
}

