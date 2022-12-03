package ru.umarsh.jetpackcomposeapptest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.umarsh.jetpackcomposeapptest.screens.ChatScreen
import ru.umarsh.jetpackcomposeapptest.screens.HomeScreen
import ru.umarsh.jetpackcomposeapptest.screens.SettingsScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable(route = "home") {
            HomeScreen()
        }
        composable(route = "chat") {
            ChatScreen()
        }
        composable(route = "settings") {
            SettingsScreen()
        }
    }
}