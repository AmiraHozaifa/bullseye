package com.amira.bullseye

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.amira.bullseye.composables.BullsEyeDialog
import com.amira.bullseye.composables.GameHeader
import com.amira.bullseye.composables.TargetSlider
import kotlin.math.abs
import kotlin.random.Random

fun calculateScore(target: Int, current: Int): Int {
    val maxScore = 100
    return maxScore - abs(current - target)
}

@Composable
fun BullsEyeScreen() {

    var alertIsVisible by rememberSaveable { mutableStateOf(false) }
    var sliderValue by rememberSaveable { mutableFloatStateOf(0.5f) }
    var totalScore by rememberSaveable { mutableIntStateOf(0) }

    var sliderIntValue = (sliderValue * 100).toInt()

    var targetValue by rememberSaveable { mutableIntStateOf(Random.nextInt(1, 100)) }

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

            GameHeader(targetValue = targetValue)

            TargetSlider(value = sliderValue) { newValue -> sliderValue = newValue }
            Text("Value $sliderIntValue")
            Button(onClick = {
                totalScore += calculateScore(targetValue, sliderIntValue)
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
                sliderVal = sliderIntValue,
                score = calculateScore(targetValue, sliderIntValue)
            )
        }

    }
}

@Composable
@Preview
fun previewGame() {
    BullsEyeScreen()
}