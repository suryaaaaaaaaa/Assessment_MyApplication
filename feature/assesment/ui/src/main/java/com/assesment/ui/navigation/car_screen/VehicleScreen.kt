package com.assesment.ui.navigation.car_screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.assesment.domain.model.CarSearchResponseItem
import com.assesment.ui.navigation.theme.Typography
import com.assesment.ui.navigation.util.LoadingBar
import com.assesment.ui.navigation.util.ToolbarWidget
import com.assesment.ui.navigation.viewmodel.CarsViewModel
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun CarSearchScreen(
    carsViewModel: CarsViewModel = hiltViewModel(),
    onClick: (String) -> Unit
) {
    androidx.compose.material.Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Column {
            ToolbarWidget()
            CarsContent(vm = carsViewModel, onImageClick = onClick)
        }
    }
}

@Composable
fun CarsContent(vm: CarsViewModel, onImageClick: (String) -> Unit) {
    val result = vm.carList.value
    if (result.isLoading) {
        LoadingBar()
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(),
        ) {
            CircularProgressIndicator()
        }
    }
    (result.data.let {
        if (it?.isNotEmpty() == true) {
            result.data?.let { it1 -> BindList(it1, onImageClick = onImageClick) }
        }
    })
}

@Composable
fun CarImage(item: CarSearchResponseItem) {
    item.images?.let {
        Image(
            painter = rememberAsyncImagePainter(it.first().url),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(150.dp)
                .padding(end = 8.dp)
                .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
        )
    }
}

@Composable
fun ListItem(item: CarSearchResponseItem, onClick: (CarSearchResponseItem) -> Unit) {
    androidx.compose.material.Card(
        backgroundColor = colors.background,
        elevation = 0.dp,
        modifier = Modifier
            .height(200.dp)
            .padding(8.dp)
            .clickable { onClick.invoke(item) },
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(16.dp),
        ) {

            CarImage(item)
            Spacer(modifier = Modifier.height(8.dp))
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .padding(8.dp)
            ) {
                androidx.compose.material.Text(
                    text = "€${item.price}",
                    fontWeight = FontWeight.Bold,
                    style = Typography.titleSmall,
                )
                androidx.compose.material.Text(
                    text = "${item.make} ${item.model}",
                    fontWeight = FontWeight.Bold,
                    style = Typography.titleSmall,
                )

                Text(
                    text = item.fuel,
                    style = Typography.titleSmall
                )
                Spacer(modifier = Modifier.height(8.dp))

                item.colour?.let {
                    androidx.compose.material.Text(
                        text = "Color: %s$it",
                        style = Typography.titleSmall,
                    )
                }
                item.mileage?.let {
                    androidx.compose.material.Text(
                        text = "Miles: %s$it",
                        style = Typography.titleSmall,
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = item.description,
                    style = Typography.titleSmall,
                    maxLines = 2
                )

            }
        }
    }
}

@Composable
fun BindList(list: List<CarSearchResponseItem>, onImageClick: (String) -> Unit) {
    LazyColumn(contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp)) {
        items(
            items = list,
            itemContent = { image ->
                ListItem(image, onClick = {
                    it.images?.first()?.url?.let {
                        val encodedUrl = URLEncoder.encode(it, StandardCharsets.UTF_8.toString())
                        onImageClick.invoke(encodedUrl)
                    }
                })
            })
    }
}


