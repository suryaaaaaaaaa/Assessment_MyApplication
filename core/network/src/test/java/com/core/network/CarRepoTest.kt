package com.core.network

import com.core.network.api.ApiService
import com.core.network.model.CarSearchResponseItem
import com.core.network.repository.CarsRepositoryImpl
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

class CarRepoTest {

    @Test
    fun canGetCarFromApi() =runTest{
        val repo= mockk<CarsRepositoryImpl>()
        val carList=listOf(
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
            1,
            ""
        )
        )

        mockk<ApiService>{
            coEvery { repo.getCars() } returns carList
        }

        val observedUser = repo.getCars()
        assertEquals(carList, observedUser)

    }
}