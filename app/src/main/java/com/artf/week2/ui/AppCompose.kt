/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.artf.week2.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artf.week2.R
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
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CompleteText(mainViewModel)
            ProgressCircle(mainViewModel)
            EditText(mainViewModel)
            Buttons(mainViewModel)
        }
    }
}

@Composable
private fun CompleteText(viewModel: MainViewModel) {
    Text(
        text = viewModel.completeString(),
        modifier = Modifier.padding(16.dp),
        color = MaterialTheme.colors.primary
    )
}

@Composable
private fun EditText(viewModel: MainViewModel) {
    if (viewModel.hideEditText()) return
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        Spacer(modifier = Modifier.weight(0.15f))
        TextField(
            modifier = Modifier.weight(0.7f),
            value = viewModel.editTextValue(),
            onValueChange = {
                viewModel.editTextValueChanged(it)
            },
            label = { Text("Seconds") },
            maxLines = 1,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.weight(0.15f))
    }
}

@Composable
private fun Buttons(viewModel: MainViewModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        Spacer(modifier = Modifier.weight(0.15f))
        Row(Modifier.weight(0.7f)) {
            Button(
                modifier = Modifier.weight(1f),
                enabled = viewModel.startButtonEnabled(),
                onClick = {
                    viewModel.clickStartButton()
                }
            ) {
                Text(text = stringResource(viewModel.startButtonDisplayString()))
            }
            Spacer(modifier = Modifier.weight(0.1f))
            Button(
                modifier = Modifier.weight(1f),
                enabled = viewModel.stopButtonEnabled(),
                onClick = {
                    viewModel.clickStopButton()
                }
            ) {
                Text(text = stringResource(id = R.string.common_btn_reset))
            }
        }
        Spacer(modifier = Modifier.weight(0.15f))
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
