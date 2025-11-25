package com.amira.bullseye.composables

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.amira.bullseye.R

@Composable
fun BullsEyeDialog(
    sliderVal : Int,
    score : Int,
    title : Int,
    onDialogDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
) {

    AlertDialog(
        onDismissRequest = onDialogDismissRequest,
        confirmButton = {
            TextButton(onClick = {
                onDialogDismissRequest()
            }) {
                Text(stringResource(id = R.string.result_dialog_button_text))
            }
        },
        title = { Text(stringResource(id = title)) },
        text = { Text(stringResource(id = R.string.result_dialog_message , sliderVal , score)) }
    )
}