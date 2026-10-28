package com.example.trainingproject.presentation.ui.applist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trainingproject.domain.appdetails.Category
import com.example.trainingproject.domain.applist.ShowcaseApp
import com.example.trainingproject.presentation.theme.VkEducationTheme

@Composable
fun AppListContent(
    modifier: Modifier = Modifier,
    content: AppListState.Content,
    onToolbarClick: () -> Unit,
    onAppClick: (ShowcaseApp) -> Unit,
) {
    Column(modifier = modifier) {
        AppListToolbar(onClick = onToolbarClick)
        AppList(
            onAppClick= onAppClick,
            appList = content.showcaseApps,
            modifier= Modifier
                .padding(horizontal = 16.dp )
                .padding(top = 8.dp)
        )
    }
}

@Preview
@Composable
private fun Preview() {
    VkEducationTheme {
        AppListContent(
            content = AppListState.Content(List(16) { index ->
                ShowcaseApp(
                    id = "show-app-$index",
                    name = "Гильдия Героев: Экшен ММО РПГ: $index",
                    iconUrl = "https://static.rustore.ru/imgproxy/APsbtHxkVa4MZ0DXjnIkSwFQ_KVIcqHK9o3gHY6pvOQ/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/393868735/content/ICON/3f605e3e-f5b3-434c-af4d-77bc5f38820e.png@webp",
                    category = Category.GAME,
                    description = "fsdfpksdgkfkgp;ldfkg;ldfgfdgfdg fgdkl;gkdf;gdfgdf"
                )
            }),
            onToolbarClick = {},
            onAppClick = {},
        )
    }
}