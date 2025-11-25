package com.amira.bullseye.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.amira.bullseye.R


@Composable
fun GameControls() {

    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(
            onClick = {}
        ) { Text(stringResource(R.string.start_over)) }

        Text(stringResource(R.string.score_label, 1), textAlign = TextAlign.Center)

        Text(stringResource(R.string.current_round_label, 1), textAlign = TextAlign.Center)

        Button(
            onClick = {}
        ) { Text(stringResource(R.string.info)) }

    }
}


@Composable
@Preview
fun GameControlsPreview() {
    GameControls()
}