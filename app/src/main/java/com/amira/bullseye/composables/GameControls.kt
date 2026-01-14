package com.amira.bullseye.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.amira.bullseye.R


@Composable
fun GameControls(
    score: Int,
    round: Int,
    onStartOver: () -> Unit,
    onInfo: () -> Unit,
    modifier: Modifier = Modifier,
) {

    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        FilledIconButton(
            onClick = onStartOver,
            colors = IconButtonDefaults.filledIconButtonColors(
                containerColor = MaterialTheme.colorScheme.tertiary
            )
        ) {
            Icon(
                Icons.Filled.Refresh,
                contentDescription = stringResource(id = R.string.restart_btn_desc)
            )
        }
//        Button(
//            onClick = onStartOver
//        ) { Text(stringResource(R.string.start_over)) }

        Text(
            stringResource(R.string.score_label, score),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.labelLarge.copy(fontSize = 12.sp)
        )

        Text(
            stringResource(R.string.current_round_label, round),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.labelLarge.copy(fontSize = 12.sp)
        )

        FilledIconButton(
            onClick = onInfo,
            colors = IconButtonDefaults.filledIconButtonColors(
                containerColor = MaterialTheme.colorScheme.tertiary
            )
        ) {
            Icon(
                Icons.Filled.Info,
                contentDescription = stringResource(id = R.string.about_btn_desc)
            )
        }
//        Button(
//            onClick = {}
//        ) { Text(stringResource(R.string.info)) }

    }
}


@Composable
@Preview
fun GameControlsPreview() {
    GameControls(0, 1, onStartOver = {}, onInfo = {})
}