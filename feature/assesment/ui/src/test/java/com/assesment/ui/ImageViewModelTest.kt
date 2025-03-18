package com.assesment.ui

import com.assesment.domain.repo.RepoInterface
import com.assesment.domain.usecases.GetCarsListUseCase
import com.assesment.domain.usecases.GetImageUseCase
import com.assesment.ui.navigation.viewmodel.ImageViewModel
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

class ImageViewModelTest {

    private lateinit var useCase: GetImageUseCase
    private lateinit var viewModel: ImageViewModel
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
    @Test
    fun getImage()= runTest{
        useCase= mockk<GetImageUseCase>()

        mockk<RepoInterface>{
            coEvery { useCase.getImageList() } returns listOf("image")
        }
        viewModel = ImageViewModel(useCase)
        viewModel.getImages(listOf("image"))
        delay(50)

        val observedUser = viewModel.imageList.value
        assertEquals(listOf("image"), observedUser.images)
    }
}