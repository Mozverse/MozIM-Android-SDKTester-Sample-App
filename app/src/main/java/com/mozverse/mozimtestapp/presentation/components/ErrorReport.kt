package com.mozverse.mozimtestapp.presentation.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mozverse.mozimtestapp.R
import com.mozverse.mozimtestapp.presentation.vastlist.ui.theme.MozimTestAppTheme

@Composable
fun ErrorReport(
    exception: Throwable,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = stringResource(id = R.string.error_general_title))
        Spacer(modifier = Modifier.height(24.dp))
        OutlinedTextField(
            value = exception.stackTraceToString(),
            onValueChange = {},
            label = {
                Text(text = stringResource(id = R.string.label_exception))
            }
        )
    }
}

@Preview(name = "Light Mode", showBackground = true)
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_UNDEFINED, showBackground = true)
@Composable
fun ErrorReportPreview() {
    MozimTestAppTheme {
        ErrorReport(IllegalArgumentException("Sample error"))
    }
}
