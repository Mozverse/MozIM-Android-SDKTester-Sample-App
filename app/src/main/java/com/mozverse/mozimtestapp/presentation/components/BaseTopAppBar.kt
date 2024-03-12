package com.mozverse.mozimtestapp.presentation.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mozverse.mozimtestapp.presentation.vastlist.ui.theme.MozimTestAppTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseTopAppBar(
    titleText: String,
    modifier: Modifier = Modifier,
    isHome: Boolean = false,
    onNavigationButtonClick: () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {}
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Text(text = titleText)
        },
        navigationIcon = {
            if (isHome) HomeIcon(onNavigationButtonClick)
            else (BackButton(onClick = onNavigationButtonClick))
        },
        actions = actions
    )
}

@Preview(name = "Light Mode", showBackground = true)
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_UNDEFINED, showBackground = true)
@Composable
@Preview
fun BaseTopAppBar() {
    MozimTestAppTheme {
        BaseTopAppBar(
            titleText = "Title"
        )
    }
}