package com.assesment.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.core.feature_api.FeatureApi

interface CarsApi: FeatureApi {
}

class CarsApiImpl:CarsApi{
    override fun registerGraph(navConController: NavHostController, navGraph: NavGraphBuilder) {
        CarApiImpl.registerGraph(navConController,navGraph)
    }

}