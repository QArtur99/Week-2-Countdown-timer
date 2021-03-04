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

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artf.week2.ui.theme.green600
import com.artf.week2.ui.theme.green700

@Composable
fun ProgressCircle(viewModel: MainViewModel) {
    Box(contentAlignment = Alignment.Center) {
        Canvas(
            modifier = Modifier
                .padding(16.dp)
                .size(200.dp),
            onDraw = {
                drawCircle(
                    color = Color.Gray,
                    style = Stroke(width = 16.dp.toPx())
                )
                drawArc(
                    startAngle = -90f,
                    sweepAngle = viewModel.progressSweepAngle(),
                    useCenter = false,
                    style = Stroke(width = 16.dp.toPx()),
                    color = green600,
                    alpha = 1f
                )
                drawArc(
                    startAngle = -90f,
                    sweepAngle = viewModel.progressSweepAngle(),
                    useCenter = false,
                    style = Stroke(
                        width = 16.dp.toPx(),
                        pathEffect = PathEffect.dashPathEffect(
                            intervals = floatArrayOf(
                                3.dp.toPx(),
                                3.dp.toPx()
                            )
                        )
                    ),
                    color = green700,
                    alpha = 1f
                )
            }
        )
        Text(
            text = viewModel.timeLeftValue(),
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}
