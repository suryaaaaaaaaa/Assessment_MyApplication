package com.assesment.domain

import com.assesment.domain.model.CarSearchResponseItem
import com.assesment.domain.repo.CarRepository
import com.assesment.domain.usecases.GetCarsListUseCase
import com.core.common.component.UiEvent
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Test

class GetCarsListUseCaseTest {

    @Test
    fun canGetCarFromApi() = runTest {
        val useCase = mockk<GetCarsListUseCase>()
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
    }
}

