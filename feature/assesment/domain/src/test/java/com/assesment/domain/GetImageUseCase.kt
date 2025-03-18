package com.assesment.domain

import androidx.lifecycle.SavedStateHandle
import com.assesment.domain.usecases.GetImageUseCase
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

class GetImageUseCase {

    @Test
    fun canGetImage()= runTest{
        val useCase= mockk<GetImageUseCase>()
        mockk<SavedStateHandle>{
            coEvery { (useCase.getImageList()) } returns listOf("Image")
        }
        val result= useCase.getImageList().toList()
        assertEquals(listOf("Image"),result)
    }
}