package com.practice.recipeapp_json

//Variables for different Screens
sealed class Screen(val route: String) {
    object RecipeScreen : Screen ("recipescreen")
    object DetailScreen : Screen ("detailscreen")
}