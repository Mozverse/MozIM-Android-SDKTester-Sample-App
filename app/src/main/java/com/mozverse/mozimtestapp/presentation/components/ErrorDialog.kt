package com.mozverse.mozimtestapp.presentation.components


import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.mozverse.mozimtestapp.R
import com.mozverse.mozimtestapp.presentation.vastlist.ui.theme.MozimTestAppTheme


@Composable
fun ErrorDialog(
    dialogText: String,
    onDismiss: () -> Unit = {},
) {
    var shouldShowDialog by remember { mutableStateOf(true) }

    if (shouldShowDialog) {

        Dialog(
            onDismissRequest = {
                onDismiss()
                shouldShowDialog = false
            }
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp, horizontal = 32.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(
                    Modifier
                        .background(MaterialTheme.colorScheme.inverseOnSurface)
                        .padding(all = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        tint = Color.Red,
                        imageVector = Icons.Default.Warning,
                        contentDescription = stringResource(id = R.string.content_description_error_alert_icon)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = stringResource(id = R.string.dialog_title_error),
                        style = MaterialTheme.typography.headlineSmall,
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = dialogText)
                    Spacer(modifier = Modifier.height(24.dp))
                    ElevatedButton(
                        colors = ButtonDefaults.buttonColors(),
                        onClick = {
                            shouldShowDialog = false
                            onDismiss()
                        }
                    ) {
                        Text(stringResource(id = R.string.button_dismiss))
                    }
                }


            }
        }
    }
}


@Preview(name = "Light Mode", showBackground = true)
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_UNDEFINED, showBackground = true)
@Composable
fun ErrorDialogPreview() {
    MozimTestAppTheme {
        ErrorDialog(dialogText = "An error has occurred")
    }
}