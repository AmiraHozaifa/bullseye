package com.amira.bullseye

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun MainScreen() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = BullsEyeGameScreenNames.HOME_SCREEN.route
    ) {
        composable(BullsEyeGameScreenNames.HOME_SCREEN.route) {
            BullsEyeGameScreen(onInfoClick = {

                navController.navigate(BullsEyeGameScreenNames.INFO_SCREEN.route)
            })
        }

        composable(BullsEyeGameScreenNames.INFO_SCREEN.route) {
            BullsEyeInfoScreen(onNavigateBack = {navController.navigateUp()})
        }
    }

}