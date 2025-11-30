package com.amira.bullseye.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.amira.bullseye.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TargetSlider(
    modifier: Modifier = Modifier,
    value: Float = 0.5f,
    onValueChanged: (Float) -> Unit
) {


    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = stringResource(R.string.min_value_text),
            modifier = Modifier.padding(horizontal = 5.dp)
        )
        Slider(
            modifier = Modifier.weight(1f),
            value = value, valueRange = 0.01f..1f, onValueChange = onValueChanged,
            thumb = {
                Image(
                    modifier = Modifier.size(100.dp),
                    painter = painterResource(R.drawable.slider),
                    contentDescription = "slider thumb",
                )
            }
        )

        Text(
            text = stringResource(R.string.max_value_text),
            modifier = Modifier.padding(horizontal = 5.dp)
        )
    }

}

@Preview
@Composable
fun TargetSliderPreview() {
    TargetSlider(value = 0.5F, onValueChanged = {})
}