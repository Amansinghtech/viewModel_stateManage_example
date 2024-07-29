package com.example.androidprac.presentation.screens.dashboard.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.androidprac.R
import com.example.androidprac.presentation.components.Carousel
import com.example.androidprac.presentation.components.ProductCardComp
import com.example.androidprac.presentation.components.SearchAndAvatar
import com.example.androidprac.presentation.components.TopCategoryListItem
import com.example.androidprac.presentation.screens.onboarding.Variables

object Dimensions {
    val xSm: Dp = 8.dp
    val xxSm: Dp = 4.dp
}

object Colors {
    val ShadesOfGray400: Color = Color(0xFFA3A3A3)
    val textActive: Color = Color(0xDE000000)
}

// home screen
@Composable
fun HomeScreen(homeViewModel: HomeViewModel = hiltViewModel()) {

    val topCategoriesUiState = homeViewModel.topCategoriesUiState.collectAsState().value

    LaunchedEffect(key1 = Unit) {
        homeViewModel.getTopCategories()
    }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(32.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(start = 8.dp, end = 8.dp)

    ) {
        /* Search and Avatar */
        item {
            SearchAndAvatar()
        }

        /* Banner Carousel */
        item {
            Carousel()
        }

        /* Top Categories horizontal list */
        item {
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .fillMaxWidth()
                //.height(201.60001.dp)

            ) {
                Text(
                    text = "Top Categories",
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight(600),
                        color = Colors.textActive,
                    )
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(
                        Dimensions.xSm,
                        Alignment.Start
                    ),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .border(width = 1.dp, color = Colors.ShadesOfGray400)
                        .fillMaxWidth()
                        .height(2.dp)
                )
                {}
                LazyRow(horizontalArrangement = Arrangement.spacedBy(Variables.xSm)) {

                    when (topCategoriesUiState) {
                        is TopCategoriesUiState.Error -> {
                            item {
                                Box(modifier = Modifier.fillMaxWidth()) {
                                    Text(text = topCategoriesUiState.message, color = Color.Red)
                                }

                            }
                        }

                        TopCategoriesUiState.Idle -> {
                            item {
                                Box(modifier = Modifier.fillMaxWidth()) {
                                    Text(text = "No Categories to Show")
                                }
                            }
                        }

                        is TopCategoriesUiState.Loading -> {
                            item {
                                LinearProgressIndicator(
                                    modifier = Modifier.fillMaxWidth(),
                                    progress = {
                                        topCategoriesUiState.progress
                                    })
                            }
                        }

                        is TopCategoriesUiState.Success -> {
                            items(topCategoriesUiState.data) { category ->
                                TopCategoryListItem(
                                    label = category.label,
                                    image = category.image,
                                    onClick = {},
                                )
                            }
                        }
                    }

                }
            }
        }
        item {
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .fillMaxWidth()

            ) {
                Text(
                    text = "Top Products",
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight(600),
                        color = Colors.textActive,
                    )
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(Dimensions.xSm, Alignment.Start),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .border(width = 1.dp, color = Colors.ShadesOfGray400)
                        .fillMaxWidth()
                        .height(2.dp)
                )
                {}
//            }
                LazyRow {
                    item {
                        ProductCardComp(
                            title = "Development Boards",
                            imageResId = R.drawable.image_arduino_nano,
                            productname = "Arduino Nano RP2040",
                            deliverytype = "free delivery",
                            badges1 = R.drawable.badges,
                            badges2 = R.drawable.badgetwo,
                            view = "1563 reviews",
                            price = "",
                            oldprice = "",
                            onClick = {}
                        )
                        ProductCardComp(
                            title = "raspberry pi",
                            imageResId = R.drawable.image_raspberry_pi,
                            productname = "Raspberry PI 4 Model B With 4GB RAM",
                            deliverytype = "free delivery",
                            badges1 = R.drawable.badges,
                            badges2 = null,
                            view = "1563 reviews",
                            price = "₹ 5,999.00",
                            oldprice = "₹ 6,400.00",
                            onClick = {}
                        )
                        ProductCardComp(
                            title = "raspberry pi",
                            imageResId = R.drawable.image_raspberry_pi,
                            productname = "Raspberry PI 4 Model B With 4GB RAM",
                            deliverytype = "free delivery",
                            badges1 = R.drawable.badges,
                            badges2 = null,
                            view = "1563 reviews",
                            price = "₹ 5,999.00",
                            oldprice = "₹ 6,400.00",
                            onClick = {}
                        )
                    }
                }
            }
        }
    }
}

