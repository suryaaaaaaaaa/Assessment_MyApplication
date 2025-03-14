package com.core.feature_api

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation

interface FeatureApi {
    fun registerGraph(
        navConController: NavHostController,
        navGraph: NavGraphBuilder
    ){
        //navGraph.navigation(startDestination = "cars", route = "cars_nested_navigation")
    }
}