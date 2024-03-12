package com.mozverse.mozimtestapp.presentation.features.session.list.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mozverse.mozim.domain.data.interaction.IMInteraction
import com.mozverse.mozimtestapp.data.extensions.capitalizeFirst
import com.mozverse.mozimtestapp.data.previewInteractionVAST
import com.mozverse.mozimtestapp.presentation.vastlist.ui.theme.MozimTestAppTheme

@Composable
fun InteractionCard(
    interaction: IMInteraction,
    modifier: Modifier = Modifier,
) {

    Column(modifier = modifier.fillMaxWidth()) {
        interaction.actions.forEach { action ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Chip(
                    text = action.actionType.action,
                )
                Spacer(modifier = Modifier.width(16.dp))
                Chip(
                    text = action.triggerType.trigger.capitalizeFirst(),
                    backgroundColor = MaterialTheme.colorScheme.background
                )

            }
            Spacer(modifier = modifier.height(4.dp))
            ActionDataTile(action.actionData)
        }
    }
}

@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_UNDEFINED, showBackground = true)
@Composable
fun InteractionCardPreview() {
    MozimTestAppTheme {
        InteractionCard(
            previewInteractionVAST()
        )
    }
}