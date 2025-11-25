package com.amira.bullseye

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

@Composable
fun BullsEyeDialog(
    modifier: Modifier = Modifier,
    sliderVal : Int,
    onDialogDismissRequest: () -> Unit
) {

    AlertDialog(
        onDismissRequest = onDialogDismissRequest,
        confirmButton = {
            TextButton(onClick = {
                onDialogDismissRequest
            }) {
                Text(stringResource(id = R.string.result_dialog_button_text))
            }
        },
        title = { Text(stringResource(id = R.string.result_dialog_title)) },
        text = { Text(stringResource(id = R.string.result_dialog_message , sliderVal)) }
    )
}