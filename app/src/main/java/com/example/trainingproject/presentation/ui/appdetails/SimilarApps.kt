package com.example.trainingproject.presentation.ui.appdetails

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.trainingproject.R
import com.example.trainingproject.domain.appdetails.Category
import com.example.trainingproject.domain.appdetails.SimilarApp
import com.example.trainingproject.presentation.theme.VkEducationTheme

@Composable
fun SimilarApps(
    apps: List<SimilarApp>,
    onDownloadClick: (SimilarApp) -> Unit,
    onAppClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier) {
        Text(
            text = stringResource(R.string.app_details_similar_apps),
            style = MaterialTheme.typography.headlineSmall,
        )
        Spacer(Modifier.height(4.dp))
        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            items(apps) { app ->
                SimilarAppItem(
                    app = app,
                    onDownloadClick = { onDownloadClick(app) },
                    onAppClick = { onAppClick(app.id) }
                )
            }
        }
    }
}

@Composable
private fun SimilarAppItem(
    app: SimilarApp,
    onDownloadClick: () -> Unit,
    onAppClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.width(128.dp).clickable{onAppClick()},
    ) {
        AsyncImage(
            model = app.iconUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(128.dp)
                .clip(RoundedCornerShape(16.dp)),
        )
        Text(text = app.name, maxLines = 2, overflow = TextOverflow.Ellipsis)
        Button(
            onClick = onDownloadClick,
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(
                text = stringResource(R.string.app_details_download),
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    VkEducationTheme {
        SimilarApps(
            apps = List(15) { index ->
                SimilarApp(
                    id = "similar-app-$index",
                    name = "Гильдия Героев: Экшен ММО РПГ: $index",
                    iconUrl = "https://static.rustore.ru/imgproxy/APsbtHxkVa4MZ0DXjnIkSwFQ_KVIcqHK9o3gHY6pvOQ/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/393868735/content/ICON/3f605e3e-f5b3-434c-af4d-77bc5f38820e.png@webp",
                )
            },
            onDownloadClick = {},
            onAppClick = {}
        )
    }
}