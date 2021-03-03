package com.artf.week2.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artf.week2.ui.theme.MyTheme


// Start building your app here!
@Composable
fun AppCompose(mainViewModel: MainViewModel) {
    MyTheme {
        AppContent(mainViewModel)
    }
}

@Composable
private fun AppContent(
    mainViewModel: MainViewModel
) {
    Surface(color = MaterialTheme.colors.background) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            TextField(value = TextFieldValue(), {

            })
            Row {
                Button(
                    onClick = {
                    },
                    content = {
                        Text(text = "Start")
                    }
                )

                Button(
                    onClick = {
                    },
                    content = {
                        Text(text = "Reset")
                    }
                )
            }
        }

    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    val mainViewModel by lazy { MainViewModel() }
    MyTheme {
        AppContent(mainViewModel)
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    val mainViewModel by lazy { MainViewModel() }
    MyTheme(darkTheme = true) {
        AppContent(mainViewModel)
    }
}