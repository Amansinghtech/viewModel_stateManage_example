package com.example.androidprac.presentation.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androidprac.R
import kotlinx.coroutines.delay

// Banner Carousel
@Composable
fun Carousel(modifier: Modifier = Modifier) {
    val images = listOf(
        R.drawable.newbannerone,
        R.drawable.newbannertwo,
        R.drawable.newbannerreplace,
        R.drawable.newbannerfourth,
        R.drawable.newbannerfifth
    )
    val pagerState = rememberPagerState(pageCount = { images.size })
    LaunchedEffect(Unit) {
        while (true) {
            delay(2000)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1) % images.size
            )
        }
    }
    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier
            .wrapContentSize()
            .align(Alignment.CenterHorizontally)) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.wrapContentSize()
            ) { currentpage ->
                Card(
                    modifier
                        .wrapContentSize()
                        .padding(0.dp),
                    elevation = CardDefaults.cardElevation(8.dp)
                ) {
                    Box {

                        Image(
                            painter = painterResource(id = images[currentpage]),
                            contentDescription = null
                        )
                        PageIndicator(
                            pageCount = images.size,
                            currentPage = pagerState.currentPage,
                            modifier = modifier.align(Alignment.BottomCenter)
                        )
                    }
                }
            }
        }
    }
}
// Page Indicator for Carousel
@Composable
fun PageIndicator(pageCount: Int, currentPage: Int, modifier: Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        repeat(pageCount) {
            IndicatorDots(isSelected = it == currentPage, modifier = modifier)
        }
    }
}

// Indicator for Carousel
@Composable
fun IndicatorDots(isSelected: Boolean, modifier: Modifier) {
    val size = animateDpAsState(targetValue = if (isSelected) 6.dp else 5.dp)
    Box(
        modifier
            .padding(2.dp)
            .size(size.value)
            .clip(CircleShape)
            .background(if (isSelected) Color.White else Color.Gray)
    )
}
