package com.practice.recipeapp_json

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RecipeApp(navController: NavHostController) {
    val recipeViewModel: MainViewModel = viewModel()
    val recipeState by recipeViewModel.categoriesState

    NavHost(navController = navController, startDestination = Screen.RecipeScreen.route) {
        composable(route = Screen.RecipeScreen.route) {
            RecipeScreen(viewstate = recipeState,
                navigateToDetail = {
                    //Saves Category with reference cate
                    navController.currentBackStackEntry?.savedStateHandle?.set(
                        "cate",
                        it
                    )  //sends it to Details Screen
                    navController.navigate(Screen.DetailScreen.route)
                })

        }
        composable(route = Screen.DetailScreen.route) {
            val category =
                navController.previousBackStackEntry?.savedStateHandle?.get<Category>("cate")
                    ?: Category("", "", "", "")
            CategoryDetailScreen(category = category)
        }
    }

}