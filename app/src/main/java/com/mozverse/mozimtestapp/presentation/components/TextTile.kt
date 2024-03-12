package com.mozverse.mozimtestapp.presentation.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mozverse.mozimtestapp.presentation.vastlist.ui.theme.MozimTestAppTheme

@Composable
fun TextTile(
    label: String,
    explanation: String?,
    modifier: Modifier = Modifier
) {
    explanation?.let {
        Row {
            Text(text = label, color = MaterialTheme.colorScheme.primary)
            Spacer(modifier = modifier.width(4.dp))
            Text(text = it, color = MaterialTheme.colorScheme.secondary)
        }
    }
}

@Preview(name = "Light Mode", showBackground = true)
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_UNDEFINED, showBackground = true)
@Composable
fun TextTilePreview() {
    MozimTestAppTheme {
        TextTile(
            label = "label",
            explanation = "explanation"
        )
    }
}