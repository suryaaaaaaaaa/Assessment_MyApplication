package com.assesment.ui

import com.assesment.domain.model.CarSearchResponseItem
import com.assesment.domain.repo.CarRepository
import com.assesment.domain.usecases.GetCarsListUseCase
import com.assesment.ui.navigation.viewmodel.CarsViewModel
import com.core.common.component.UiEvent
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

class CarsViewModelTest {

    private lateinit var viewModel: CarsViewModel
    private lateinit var useCase: GetCarsListUseCase

    @ExperimentalCoroutinesApi
    private val testDispatcher = TestCoroutineDispatcher()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getCars_isSuccess() = runBlockingTest {
        useCase = mockk<GetCarsListUseCase>()
        val carList = listOf(
            CarSearchResponseItem(
                1,
                emptyList(),
                "",
                0,
                "",
                "",
                1,
                "",
                "",
                "",
                ""
            )
        )

        mockk<CarRepository> {
            coEvery { useCase.invoke() } returns flowOf(UiEvent.Success(data = carList))
        }
        viewModel = CarsViewModel(useCase)
        viewModel.carList
        delay(50)

        val observedUser = viewModel.carList.value
        assertEquals(carList, observedUser.data)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getCars_isLoading() = runBlockingTest {
        useCase = mockk<GetCarsListUseCase>()
        mockk<CarRepository> {
            coEvery { useCase.invoke() } returns flowOf(UiEvent.Loading())
        }
        viewModel = CarsViewModel(useCase)

        viewModel.carList
        delay(50)

        val observedUser = viewModel.carList.value
        assertEquals(true, observedUser.isLoading)
    }


    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getCars_isFail() = runBlockingTest {
        useCase = mockk<GetCarsListUseCase>()

        mockk<CarRepository> {
            coEvery { useCase.invoke() } returns flowOf(UiEvent.Error())
        }
        viewModel = CarsViewModel(useCase)
        viewModel.carList
        delay(50)
        val observedError = viewModel.carList.value
        assertEquals("", observedError.error)
    }
}