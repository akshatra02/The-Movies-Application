package com.example.themovieapp.presentation.navigation

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.themovieapp.presentation.screen.CategoryScreen
import com.example.themovieapp.presentation.screen.DetailScreen
import com.example.themovieapp.presentation.screen.HomeScreen
import com.example.themovieapp.presentation.screen.LandingScreen
import com.example.themovieapp.presentation.screen.SearchScreen


@Composable
fun Navigation(
){
    var showLandingScreen by remember{
        mutableStateOf( true)
    }

    val navController: NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination = if (showLandingScreen) Screen.LandingScreen.route else Screen.HomeScreen.route) {

        composable(Screen.HomeScreen.route){
            HomeScreen(navController)
        }
        composable(Screen.LandingScreen.route){
            LandingScreen(onTimeout = { showLandingScreen = false})
        }
        composable(Screen.SearchScreen.route){
            SearchScreen(navController)
        }
        composable(route = "${Screen.CategoryScreen.route}/{category}",
            arguments = listOf(navArgument("category"){ type = NavType.StringType})
            ){backStackEntry ->
            val category = backStackEntry.arguments?.getString("category") ?: ""
            CategoryScreen(navController, category =  category)
        }
        composable(route = "${Screen.DetailScreen.route}/{movieId}",
            arguments = listOf(navArgument("movieId"){ type = NavType.IntType})
        ){backStackEntry ->
            val movieId = backStackEntry.arguments?.getInt("movieId") ?: -1

            DetailScreen(navController, movieId)
        }

    }
}