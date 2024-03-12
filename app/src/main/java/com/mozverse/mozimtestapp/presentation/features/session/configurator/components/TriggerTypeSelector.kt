package com.mozverse.mozimtestapp.presentation.features.session.configurator.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mozverse.mozim.domain.data.trigger.IMTriggerType
import com.mozverse.mozimtestapp.R
import com.mozverse.mozimtestapp.presentation.vastlist.ui.theme.MozimTestAppTheme

@Composable
fun TriggerTypeSelector(
    selectedTriggerType: IMTriggerType,
    onTriggerTypeSelected: (IMTriggerType) -> Unit = {}
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selectedTriggerType == IMTriggerType.INSTANT,
            onClick = {
                onTriggerTypeSelected(IMTriggerType.INSTANT)
            }
        )
        Text(text = stringResource(id = R.string.radio_option_instant))

        RadioButton(
            selected = selectedTriggerType == IMTriggerType.SHAKE,
            onClick = {
                onTriggerTypeSelected(IMTriggerType.SHAKE)
            }
        )
        Text(text = stringResource(id = R.string.radio_option_shake))
    }
}


@Preview(name = "Light Mode", showBackground = true)
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_UNDEFINED, showBackground = true)
@Composable
fun TriggerTypeSelectorPreview() {
    MozimTestAppTheme {
        TriggerTypeSelector(selectedTriggerType = IMTriggerType.INSTANT)
    }
}