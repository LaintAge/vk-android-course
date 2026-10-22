package com.example.trainingproject.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trainingproject.R
import com.example.trainingproject.presentation.data.App
import com.example.trainingproject.presentation.data.AppsData
import com.example.trainingproject.presentation.data.Category
import com.example.trainingproject.presentation.theme.VkEducationTheme

@Composable
fun AppShowcase(
    apps: List<App>,
    contentPadding: PaddingValues,
    onShowcaseAppClick: (App) -> Unit = {},
    modifier: Modifier = Modifier,
) {
    val pages = remember(apps) { apps.chunked(3) }
    val pagerState = rememberPagerState(pageCount = { pages.size })

    Column(modifier = modifier) {
        Text(
            text = stringResource(R.string.showcase_title),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(contentPadding)
        )

        Spacer(Modifier.height(8.dp))

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxWidth(),
            pageSpacing = 8.dp,
            contentPadding = contentPadding,
        ) { page ->
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth(),
            ) {
                pages[page].forEach { dataApp ->
                    AppListItem(app = dataApp, onClick = {onShowcaseAppClick(dataApp)})
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    VkEducationTheme {
        val app = AppsData.apps

        AppShowcase(app, contentPadding = PaddingValues(horizontal = 16.dp))
    }
}