package com.example.trainingproject.presentation.ui.appdetails

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trainingproject.R
import com.example.trainingproject.presentation.theme.VkEducationTheme

@Composable
fun InstallButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(8.dp),
        contentPadding = PaddingValues(vertical = 12.dp, horizontal = 6.dp),
        modifier = modifier,
    ) {
        Text(text = stringResource(R.string.install))
    }
}

@Preview
@Composable
private fun Preview() {
    VkEducationTheme {
        InstallButton(
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
        )
    }
}