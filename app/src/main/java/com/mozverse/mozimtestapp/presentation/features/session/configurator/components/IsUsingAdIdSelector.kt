package com.mozverse.mozimtestapp.presentation.features.session.configurator.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.RadioButton
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
fun IsUsingAdIdSelector(
    isUsingAdId: Boolean,
    onIsUsingAdIdClicked: (Boolean) -> Unit = {}
) {
    Row(
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = stringResource(id = R.string.radio_group_is_using_ad))
        Spacer(modifier = Modifier.width(8.dp))
        RadioButton(
            selected = isUsingAdId,
            onClick = {
                if (!isUsingAdId) onIsUsingAdIdClicked(true)
            }
        )
        Text(text = stringResource(id = R.string.radio_option_yes))

        RadioButton(
            selected = !isUsingAdId,
            onClick = {
                if (isUsingAdId) onIsUsingAdIdClicked(false)
            }
        )
        Text(text = stringResource(id = R.string.radio_option_no))
    }
}


@Preview(name = "Light Mode", showBackground = true)
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_UNDEFINED, showBackground = true)
@Composable
fun IsUsingAdIdSelectorPreview() {
    MozimTestAppTheme {
        IsUsingAdIdSelector(isUsingAdId = true)
    }
}