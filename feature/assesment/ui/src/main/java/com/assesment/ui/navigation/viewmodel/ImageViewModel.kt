package com.assesment.ui.navigation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assesment.domain.usecases.GetImageUseCase
import com.assesment.ui.navigation.util.ImageStateHolder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImageViewModel @Inject constructor(
    getImageUseCase: GetImageUseCase,
) : ViewModel() {
    private val _imageList = mutableStateOf(ImageStateHolder())
    val imageList: State<ImageStateHolder> get() = _imageList

    init {
        getImages(getImageUseCase.getImageList())
    }

    fun getImages(images: List<String>) = viewModelScope.launch {
        _imageList.value = ImageStateHolder(images = images)
    }
}
