package com.amira.bullseye

import androidx.compose.foundation.Image
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.amira.bullseye.composables.BullsEyeDialog
import com.amira.bullseye.composables.GameControls
import com.amira.bullseye.composables.GameHeader
import com.amira.bullseye.composables.TargetSlider
import kotlin.math.abs
import kotlin.random.Random

@Composable
fun BullsEyeScreen() {

    fun generateNewTarget() = Random.nextInt(1, 100)

    var alertIsVisible by rememberSaveable { mutableStateOf(false) }
    var sliderValue by rememberSaveable { mutableFloatStateOf(0.5f) }
    var sliderIntValue = (sliderValue * 100).toInt()
    var totalScore by rememberSaveable { mutableIntStateOf(0) }
    var currentRound by rememberSaveable { mutableIntStateOf(1) }
    var targetValue by rememberSaveable { mutableIntStateOf(generateNewTarget()) }

    fun calculateScoreDiff() = abs(sliderIntValue - targetValue)
    fun resetGame() {
        sliderValue = 0.5f
        totalScore = 0
        currentRound = 1
        targetValue = generateNewTarget()
    }

    fun calculateScore(): Int {
        val maxScore = 100
        val diff = calculateScoreDiff()
        var bonus = 0
        if (diff == 0) {
            bonus = 100
        } else if (diff == 1) {
            bonus = 50
        }
        return (maxScore - diff) + bonus
    }

    fun getScoreMessage(): Int {
        val difference = calculateScoreDiff()

        val title: Int = when {

            difference == 0 -> {
                R.string.alert_title_1
            }

            difference < 5 -> {
                R.string.alert_title_2
            }

            difference <= 10 -> {
                R.string.alert_title_3
            }

            else -> {
                R.string.alert_title_4
            }
        }

        return title
    }

    Image(
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop, // New Code
        painter = painterResource(id = R.drawable.background),
        contentDescription = "Background Image"
    )
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
                totalScore += calculateScore()
                alertIsVisible = true
            }) {
                Text(stringResource(R.string.hit_me_button_text))
            }
        }
        Spacer(modifier = Modifier.weight(0.5f))
        if (alertIsVisible) {
            //Text(text = "This is an alert")
            BullsEyeDialog(
                onDialogDismissRequest = {
                    currentRound++
                    targetValue = generateNewTarget()
                    alertIsVisible = false
                },
                title = getScoreMessage(),
                sliderVal = sliderIntValue,
                score = calculateScore()
            )
        }

        GameControls(totalScore, currentRound, onStartOver = { resetGame() })

    }
}

@Composable
@Preview
fun PreviewGame() {
    BullsEyeScreen()
}