package com.mozverse.mozimtestapp.presentation.components

import android.content.res.Configuration
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.mozverse.mozimtestapp.presentation.vastlist.ui.theme.MozimTestAppTheme

@Composable
fun BackButton(onClick: () -> Unit) {
    IconButton(
        colors = IconButtonDefaults.iconButtonColors(),
        onClick = onClick,
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null, // Set a meaningful content description if needed
            tint = MaterialTheme.colorScheme.primary // Set the tint color of the icon
        )
    }
}

@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_UNDEFINED)
@Composable
fun BackButtonPreview() {
    MozimTestAppTheme {
        BackButton {}
    }
}