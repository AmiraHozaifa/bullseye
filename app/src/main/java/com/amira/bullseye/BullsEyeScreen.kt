package com.amira.bullseye

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.sync.Mutex

@Composable
fun BullsEyeScreen() {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Spacer(modifier = Modifier.weight(0.5f))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.weight(9f)

        ) {
            Text(text = "Put the eyes as close as you can")
            Text(
                text = "88", fontSize = 24.sp, fontWeight = FontWeight.Bold
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "min", modifier = Modifier.padding(horizontal = 5.dp))
                Slider(
                    modifier = Modifier.weight(1f),
                    value = 0.5f, valueRange = 0.01f..1f, onValueChange = {}
                )

                Text(text = "max", modifier = Modifier.padding(horizontal = 5.dp))
            }

            Button(onClick = {}) {
                Text("HitMe")
            }
        }
        Spacer(modifier = Modifier.weight(0.5f))

    }
}

@Composable
@Preview
fun previewGame() {
    BullsEyeScreen()
}