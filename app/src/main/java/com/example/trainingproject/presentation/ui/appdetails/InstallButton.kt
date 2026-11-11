package com.example.trainingproject.presentation.ui.appdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
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
    installState: InstallState,
    onInstallClick: () -> Unit,
    onDeleteClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    when (installState) {
        is InstallState.NotInstalled -> {
            Button(
                onClick = onInstallClick,
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(vertical = 12.dp, horizontal = 6.dp),
                modifier = modifier,
            ) {
                Text(text = stringResource(R.string.install))
            }
        }
        is InstallState.Installing -> {
            Button(
                onClick = onInstallClick,
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(vertical = 12.dp, horizontal = 6.dp),
                modifier = modifier,
            ) {
                Text(text = "${stringResource(R.string.cancel)} (${installState.progress}%)")
            }
        }
        is InstallState.Installed -> {
            Button(
                onClick = onDeleteClick,
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(vertical = 12.dp, horizontal = 6.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.error
                ),
                modifier = modifier,
            ) {
                Text(text = stringResource(R.string.delete))
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    VkEducationTheme {
        InstallButton(
            onInstallClick = {},
            onDeleteClick = {},
            modifier = Modifier.fillMaxWidth(),
            installState = InstallState.NotInstalled,
        )
    }
}