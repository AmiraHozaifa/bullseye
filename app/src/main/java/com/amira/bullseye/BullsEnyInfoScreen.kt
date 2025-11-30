package com.amira.bullseye

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BullsEyeInfoScreen() {

    Scaffold(
        topBar = {
            BullsEyeInfoTopBar()
        }

    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.about_title_text),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Bold)
            )

            Text(
                text = stringResource(id = R.string.about_bullseye_text),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge
            )

            Button(
                onClick = {},
                shape = MaterialTheme.shapes.medium,

                ) { Text(text = stringResource(id = R.string.back_button_text)) }
        }

    }
}


@Composable
@Preview
fun BullsEyeInfoScreenPreview() {
    BullsEyeInfoScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BullsEyeInfoTopBar() {
    TopAppBar(
        title = { Text(stringResource(id = R.string.about_page_title)) },
        navigationIcon = {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = stringResource(id = R.string.back_button_text)
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
        )

    )
}

@Composable
@Preview
fun BullsEyeInfoTopBarPreview() {
    BullsEyeInfoTopBar()
}