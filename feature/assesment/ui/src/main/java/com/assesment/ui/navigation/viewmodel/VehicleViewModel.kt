package com.assesment.ui.navigation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assesment.domain.usecases.GetCarsListUseCase
import com.assesment.ui.navigation.util.CarSearchStateHolder
import com.core.common.component.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CarsViewModel @Inject constructor(
    private val carsUseCase: GetCarsListUseCase,
) : ViewModel() {

    private val _carList = mutableStateOf(CarSearchStateHolder())
    val carList: State<CarSearchStateHolder> get() = _carList

    init {
        getCar()
    }

    fun getCar() = viewModelScope.launch {
        carsUseCase().onEach {
            when (it) {
                is UiEvent.Loading -> {
                    _carList.value = CarSearchStateHolder(isLoading = true)
                }

                is UiEvent.Error -> {
                    _carList.value = CarSearchStateHolder(error = "")
                }

                is UiEvent.Success -> {
                    _carList.value = CarSearchStateHolder(data = it.data)
                }
            }

        }.launchIn(viewModelScope)
    }
}
