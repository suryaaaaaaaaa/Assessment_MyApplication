package com.core.network

import com.core.network.api.DataSource
import com.core.network.model.CarSearchResponseItem
import com.core.network.repository.DataSourceImpl
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

class CarRepoTest {

    @Test
    fun canGetCarFromApi() =runTest{
        val repo= mockk<DataSourceImpl>()
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

        mockk<DataSource>{
            coEvery { repo.getCars() } returns carList
        }

        val observedUser = repo.getCars()
        assertEquals(carList, observedUser)

    }
}