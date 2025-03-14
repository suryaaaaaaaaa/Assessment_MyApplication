package com.assesment.ui.navigation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assesment.domain.usecases.GetCarsListUseCase
import com.assesment.ui.navigation.util.CarSearchStateHolder
import com.core.common.component.UiEvent

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
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
    private var _query: MutableStateFlow<String> = MutableStateFlow("")
    val query: StateFlow<String> get() = _query

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

//    fun filterCars(filter: Boolean) = viewModelScope.launch {
//        carsUseCase().collect {
//            state.value = CarsListUiStateReady(it.data)
//        }
//    }
//
//    fun getCars() = viewModelScope.launch {
//        withContext(Dispatchers.IO) {
//            carsUseCase().collect(::handleResponse)
//        }
//    }

//    private suspend fun handleResponse(it: UiEvent<List<CarSearchResponseItem>>) = withContext(Dispatchers.Main) {
//        when (state) {
//            istate.value = Loading
//            Resource.Status.SUCCESS -> state.value = CarsListUiStateReady(cars = it.data)
//            Resource.Status.ERROR -> state.value =
//                CarsListUiStateError(error = it.error?.data?.message)
//        }
//    }
//}
//
//sealed class CarsListUiState
//data class CarsListUiStateReady(val cars: List<CarSearchResponseItem>?) : CarsListUiState()
//object Loading : CarsListUiState()
//class CarsListUiStateError(val error: String? = null) : CarsListUiState()