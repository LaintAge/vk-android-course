package com.example.trainingproject.presentation.ui.appdetails

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
import com.example.trainingproject.domain.appdetails.Category
import com.example.trainingproject.domain.applist.ShowcaseApp
import com.example.trainingproject.presentation.theme.VkEducationTheme
import com.example.trainingproject.presentation.ui.applist.AppListItem

@Composable
fun AppShowcase(
    apps: List<ShowcaseApp>,
    contentPadding: PaddingValues,
    onAppClick: (String) -> Unit,
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
                    AppListItem(app = dataApp, onClick = { onAppClick(dataApp.id) })
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    VkEducationTheme {
        val app = List(9) { index ->
            ShowcaseApp(
                id = "similar-app-$index",
                name = "Гильдия Героев: Экшен ММО РПГ: $index",
                iconUrl = "https://static.rustore.ru/imgproxy/APsbtHxkVa4MZ0DXjnIkSwFQ_KVIcqHK9o3gHY6pvOQ/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/393868735/content/ICON/3f605e3e-f5b3-434c-af4d-77bc5f38820e.png@webp",
                category = Category.GAME,
                description = "sdggsrgvsdvfsdfsdfs"
            )
        }
        AppShowcase(
            app,
            onAppClick = {},
            contentPadding = PaddingValues(horizontal = 16.dp),
        )
    }
}