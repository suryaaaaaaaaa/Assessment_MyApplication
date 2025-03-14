package com.example.assessment.naavigation

sealed class Screen(val route: String) {
    data object Cars : Screen("cars")
    data object Images : Screen("images/{item}") {
        fun createRoute(image: String) = "images/$image"
    }
}