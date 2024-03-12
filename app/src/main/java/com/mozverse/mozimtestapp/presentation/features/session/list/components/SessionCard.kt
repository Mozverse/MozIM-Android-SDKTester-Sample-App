package com.mozverse.mozimtestapp.presentation.features.session.list.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mozverse.mozimtestapp.R
import com.mozverse.mozimtestapp.data.previewSession1
import com.mozverse.mozimtestapp.domain.data.Session
import com.mozverse.mozimtestapp.presentation.components.DeleteButton
import com.mozverse.mozimtestapp.presentation.components.PlayButton
import com.mozverse.mozimtestapp.presentation.components.PlayForegroundedButton
import com.mozverse.mozimtestapp.presentation.components.TextTile
import com.mozverse.mozimtestapp.presentation.vastlist.ui.theme.MozimTestAppTheme

@Composable
fun SessionCard(
    session: Session,
    modifier: Modifier = Modifier,
    onStartSessionClicked: (Session) -> Unit = {},
    onStartSessionForegroundedClicked: (Session) -> Unit = {},
    onDeleteSessionClicked: (Session) -> Unit = {},
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Transparent)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(16.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier
                    .weight(1f)
                    .height(intrinsicSize = IntrinsicSize.Max),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                InteractionCard(
                    interaction = session.interaction,
                )
                TextTile(
                    label = stringResource(id = R.string.label_url),
                    explanation = session.url
                )
            }
            Column(
                modifier.height(intrinsicSize = IntrinsicSize.Max),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                PlayButton(
                    onClick = { onStartSessionClicked(session) }
                )
                PlayForegroundedButton(
                    onClick = { onStartSessionForegroundedClicked(session) }
                )
                DeleteButton(
                    onClick = { onDeleteSessionClicked(session) }
                )
            }
        }
    }
}

@Preview(name = "Light Mode", showBackground = true)
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_UNDEFINED, showBackground = true)
@Composable
fun SessionCardPreview() {
    MozimTestAppTheme {
        SessionCard(
            previewSession1()
        )
    }
}