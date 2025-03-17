package com.assesment.ui

import com.assesment.domain.model.CarSearchResponseItem
import com.assesment.domain.repo.RepoInterface
import com.assesment.domain.usecases.GetCarsListUseCase
import com.assesment.ui.navigation.viewmodel.CarsViewModel
import com.core.network.api.ApiService
import com.core.network.repository.CarsRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.justRun
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test


@ExperimentalCoroutinesApi
class CarsViewModelTest {
    @MockK
    lateinit var viewModel: CarsViewModel

    @MockK
    lateinit var apiService: ApiService

    @MockK
    lateinit var repoInterface: RepoInterface

    @MockK
    lateinit var repository: CarsRepository

    @MockK
    lateinit var getCarsUseCase: GetCarsListUseCase
     @Before
    fun setUp() {
        MockKAnnotations.init(this)
        // Dispatchers.setMain(Dispatchers.Unconfined)
         repository = CarsRepository(apiService)
        getCarsUseCase = GetCarsListUseCase(repoInterface)
         viewModel = CarsViewModel(getCarsUseCase)
    }
    @Test
    fun getCars_isSuccess(){
        val carList = listOf(
            CarSearchResponseItem(
                1,
                emptyList(),
                "",
                "",
                0,
                "",
                "",
                "",
                "",
                0,
                ""
            )
        )
        every { getCarsUseCase.invoke(any()) }.returns(flowOf(carList))
        assertTrue(viewModel.carList == carList)
    }

    @Test
    fun getCars_isFail()  {
        justRun { viewModel.getCar() }
    }
}