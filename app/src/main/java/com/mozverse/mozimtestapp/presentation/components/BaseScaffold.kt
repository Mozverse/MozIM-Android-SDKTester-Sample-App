package com.mozverse.mozimtestapp.presentation.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mozverse.mozimtestapp.presentation.vastlist.ui.theme.MozimTestAppTheme

@Composable
fun BaseScaffold(
    titleText: String,
    modifier: Modifier = Modifier,
    isHome: Boolean = false,
    onNavigationButtonClick: () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            BaseTopAppBar(
                titleText = titleText,
                modifier = modifier,
                isHome = isHome,
                onNavigationButtonClick = onNavigationButtonClick,
                actions = actions
            )
        },
        content = content,
    )
}


@Preview(name = "Light Mode", showBackground = true)
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_UNDEFINED, showBackground = true)
@Composable
fun BaseScaffoldPreview() {
    MozimTestAppTheme {
        BaseScaffold(
            isHome = false,
            titleText = "Title",
            onNavigationButtonClick = {
                // do nothing
            },
            actions = {}
        ) {
        }
    }
}