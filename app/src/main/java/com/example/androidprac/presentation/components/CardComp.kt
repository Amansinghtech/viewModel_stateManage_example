package com.example.androidprac.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.traceEventEnd
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidprac.presentation.screens.onboarding.Variables


// Card Component
@Composable
fun TopCategoryListItem(
    label: String,
    image: DynamicImageSource,
    onClick: () -> Unit,
    enable: Boolean = true
) {
    Column(
        modifier = Modifier
            .requiredWidth(120.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable(enabled = enable, onClick = onClick)
            .padding(vertical = Variables.xSm, horizontal = Variables.sm)
        ,
        verticalArrangement = Arrangement.spacedBy(Variables.sm),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DynamicImage(
            imageSource = image,
            customization = ImageCustomization(
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(90.dp)
                    .clip(CircleShape),
            ),
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .height(32.dp),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            text = label,
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(400),
                color = Variables.textInactive,
                textAlign = TextAlign.Center,
            )
        )
    }
}