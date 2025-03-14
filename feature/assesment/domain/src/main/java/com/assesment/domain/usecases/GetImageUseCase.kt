package com.assesment.domain.usecases

import androidx.lifecycle.SavedStateHandle
import javax.inject.Inject

class GetImageUseCase @Inject constructor(private val stateHandle: SavedStateHandle) {
    fun getImageList(): List<String> {
        val item = stateHandle.get<String>("item")
        item?.let {
            return (listOf(it))
        }
        return emptyList()
    }
}