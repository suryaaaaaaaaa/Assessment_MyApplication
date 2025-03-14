package com.assesment.ui.navigation.util

import com.assesment.domain.model.CarSearchResponseItem

data class CarSearchStateHolder(
    val isLoading:Boolean=false,
    val data:List<CarSearchResponseItem>?=null,
    val error: String=""

) {
}