package com.example.androidprac.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object color {
    val primary = Color.Blue
    val secondary = Color.Green
    val tertiary = Color.Red
}

// Reusable Button Component Function with default values
@Composable
fun ButtonComp(
    text: String = "Button",
    onClick: () -> Unit,
    enabled: Boolean = true,
    contentPadding: PaddingValues = PaddingValues(
        start = 14.dp,
        end = 14.dp,
        top = 0.dp,
        bottom = 0.dp
    ),
    modifier: Modifier = Modifier,
    shape: RoundedCornerShape = RoundedCornerShape(16.dp),
    style: TextStyle = TextStyle(fontSize = 16.sp, color = Color.Black),
    IconStart: @Composable (() -> Unit)? = null,
    IconEnd: @Composable (() -> Unit)? = null,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier,
        shape = shape,
        colors = colors,
        contentPadding = contentPadding
    )
    {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (IconStart != null) {
                IconStart()
            }
            Text(
                text = text,
                style = style
            )
            if (IconEnd != null) {
                IconEnd()
            }
        }
    }
}

