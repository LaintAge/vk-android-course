package com.example.trainingproject.presentation.ui.applist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.trainingproject.R
import com.example.trainingproject.domain.appdetails.Category

@Composable
private fun getCategoryText(category: Category): String = when (category) {
    Category.APP -> stringResource(R.string.category_app)
    Category.GAME -> stringResource(R.string.category_game)
}

@Composable
fun CategoryItem(
    category: Category,
    modifier: Modifier = Modifier,
) {
    Text(
        text = getCategoryText(category),
        style = MaterialTheme.typography.labelSmall,
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surfaceDim)
            .padding(horizontal = 6.dp)
    )
}