package com.example.androidprac.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidprac.presentation.screens.onboarding.SignUpScreen
import com.example.androidprac.presentation.screens.dashboard.HomePage
import com.example.androidprac.presentation.screens.onboarding.LoginScreen
import com.example.androidprac.presentation.screens.onboarding.WelcomePage
import kotlinx.serialization.Serializable

//sealed class AppScreen for navigation

sealed class NavigationRoute {

    @Serializable
    data object Welcome : NavigationRoute()

    @Serializable
    data object Login : NavigationRoute()

    @Serializable
    data object Account : NavigationRoute()

    @Serializable
    data object Home : NavigationRoute()

}

@Composable
// NavHost is used to navigate between different screens
fun NavController() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationRoute.Home) {
        composable<NavigationRoute.Welcome> { WelcomePage(navController) }
        composable<NavigationRoute.Login> { LoginScreen(navController) }
        composable<NavigationRoute.Account> { SignUpScreen(navController) }
        composable<NavigationRoute.Home> { HomePage(navController) }
    }
}