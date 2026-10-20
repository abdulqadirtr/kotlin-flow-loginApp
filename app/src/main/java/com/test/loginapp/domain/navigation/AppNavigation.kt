package com.test.loginapp.domain.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.test.loginapp.LoginScreen
import com.test.loginapp.PostScreen

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.LOGIN
    ){

        composable(Routes.LOGIN){

            LoginScreen(onLoginScreen = {
                navController.navigate(Routes.DETAILS)
            })


        }

        composable(Routes.DETAILS){

            PostScreen()

        }

    }
}

object Routes {
    const val HOME = "home"
    const val LOGIN = "login"
    const val DETAILS = "details"
}