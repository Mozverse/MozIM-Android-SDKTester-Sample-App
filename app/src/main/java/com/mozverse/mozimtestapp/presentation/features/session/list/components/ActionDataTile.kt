package com.mozverse.mozimtestapp.presentation.features.session.list.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.mozverse.mozim.domain.data.action.IMActionData
import com.mozverse.mozimtestapp.R
import com.mozverse.mozimtestapp.data.previewAllActionData
import com.mozverse.mozimtestapp.presentation.components.TextTile
import com.mozverse.mozimtestapp.presentation.vastlist.ui.theme.MozimTestAppTheme

@Composable
fun ActionDataTile(
    actionData: IMActionData,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        TextTile(
            label = stringResource(id = R.string.label_website),
            explanation = actionData.url
        )
        TextTile(
            label = stringResource(id = R.string.label_plays_store),
            explanation = actionData.playStoreUrl
        )
        TextTile(
            label = stringResource(id = R.string.label_wallet_url),
            explanation = actionData.walletUrl
        )
        TextTile(
            label = stringResource(id = R.string.label_ics_url),
            explanation = actionData.eventICSUrl
        )
        TextTile(
            label = stringResource(id = R.string.label_phone_number),
            explanation = actionData.phoneNumber
        )
        TextTile(
            label = stringResource(id = R.string.label_v_card_string),
            explanation = actionData.vCardString?.let { stringResource(id = R.string.some_data) }
        )
        TextTile(
            label = stringResource(id = R.string.label_vcf_url),
            explanation = actionData.contactVCFUrl
        )
        TextTile(
            label = stringResource(id = R.string.label_directions_url),
            explanation = actionData.directions
        )
        TextTile(
            label = stringResource(id = R.string.label_locations_url),
            explanation = actionData.locations
        )
        TextTile(
            label = stringResource(id = R.string.label_image_url),
            explanation = actionData.imageUrl
        )
        TextTile(
            label = stringResource(id = R.string.label_email_recipient),
            explanation = actionData.emailRecipient
        )
        TextTile(
            label = stringResource(id = R.string.label_email_subject),
            explanation = actionData.emailSubject
        )
        TextTile(
            label = stringResource(id = R.string.label_email_body),
            explanation = actionData.emailBody
        )
    }
}


@Preview(name = "Light Mode")
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_UNDEFINED, showBackground = true)
@Composable
fun ActionDataTilePreview() {
    MozimTestAppTheme {
        ActionDataTile(
            previewAllActionData()
        )
    }
}