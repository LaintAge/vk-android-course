package com.example.trainingproject.presentation.ui.applist

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trainingproject.R
import com.example.trainingproject.presentation.theme.RuStoreBlue
import com.example.trainingproject.presentation.theme.VkEducationTheme

@Composable
internal fun AppListToolbar(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(color = RuStoreBlue)
            .height(32.dp)
            .padding(horizontal = 16.dp)
            .clickable{ onClick() }
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_logo),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.background,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Preview
@Composable
private fun Preview() {
    VkEducationTheme {
        AppListToolbar(onClick = {})
    }
}