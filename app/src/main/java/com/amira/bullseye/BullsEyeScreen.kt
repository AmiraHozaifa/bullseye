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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.sync.Mutex

@Composable
fun BullsEyeScreen() {

    var alertIsVisible by rememberSaveable { mutableStateOf(false) }
    var sliderValue by rememberSaveable { mutableStateOf(0.5f) }

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

            GameHeader()

            TargetSlider(value = sliderValue) { newValue -> sliderValue = newValue }
            Button(onClick = {
                alertIsVisible = true
            }) {
                Text(stringResource(R.string.hit_me_button_text))
            }
        }
        Spacer(modifier = Modifier.weight(0.5f))
        if (alertIsVisible) {
            //Text(text = "This is an alert")
            BullsEyeDialog(
                onDialogDismissRequest = { alertIsVisible = false },
                sliderVal = (sliderValue * 100).toInt()
            )
        }

    }
}

@Composable
@Preview
fun previewGame() {
    BullsEyeScreen()
}