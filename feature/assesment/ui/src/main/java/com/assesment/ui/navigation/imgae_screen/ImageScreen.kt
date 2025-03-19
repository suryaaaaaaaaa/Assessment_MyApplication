package com.assesment.ui.navigation.imgae_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import com.google.accompanist.pager.HorizontalPager
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import com.google.accompanist.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.assesment.ui.navigation.viewmodel.ImageViewModel
import com.google.accompanist.pager.ExperimentalPagerApi

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImageScreen(imagesViewModel: ImageViewModel = hiltViewModel()) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Image") },
                Modifier.background(MaterialTheme.colorScheme.surface),
            )
        },
        modifier = Modifier.fillMaxSize()
    ) {
        ImagesContent(vm = imagesViewModel)
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ImagePager(images: List<String>) {
    Column(
        Modifier
            .fillMaxSize()
    ) {
        val pagerState = rememberPagerState()
        HorizontalPager(
            count = images.size,
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 32.dp),
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
        ) { page ->
            CarImage(item = images[page])
        }
    }
}

@Composable
fun ImagesContent(vm: ImageViewModel) {
    vm.imageList.value.let { state ->
        state.images?.let { ImagePager(it) }
    }
}

@Composable
fun CarImage(item: String) {
    Image(
        painter = rememberAsyncImagePainter(item),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    )
}