package com.example.trainingproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            InputBlock()
        }
    }
}

@Composable
fun InputBlock(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val text = remember { mutableStateOf("") }

    val isValidPhone = Utils.isValidPhone(text.value)
    val isText = text.value.isNotBlank()

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp)
    ){
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            OutlinedTextField(
                value = text.value,
                onValueChange = { text.value = it },
                modifier = Modifier.fillMaxWidth(),
            )

            Column {
                Button(
                    onClick = { Utils.openSecondActivity(context, text.value) },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = isText,
                ) {
                    Text("Открыть вторую Activity")
                }
                if (!isText) {
                    Text("Строка пустая", color = Color.Red)
                }
            }

            Column {
                Button(
                    onClick = { Utils.callFriend(context, text.value) },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = isText && isValidPhone,
                ) {
                    Text("Позвонить другу")
                }
                if (!isValidPhone) {
                    Text("В строке не валидный номер", color = Color.Red)
                }
            }

            Column {
                Button(
                    onClick = { Utils.shareText(context, text.value) },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = isText,
                ) {
                    Text("Поделиться текстом")
                }
                if (!isText) {
                    Text("Строка пустая", color = Color.Red)
                }
            }


        }
    }
}
