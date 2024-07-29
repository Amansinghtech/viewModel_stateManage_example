package com.example.androidprac.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androidprac.R

@Composable
fun SearchAndAvatar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 0.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        OutlinedTextField(
            modifier = Modifier.weight(1f),
            value = "", onValueChange = {},
            placeholder = { Text(text = "Search for Parts") },
            shape = RoundedCornerShape(999.dp),
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.newkilo),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(0.dp)
                        .width(23.00031.dp)
                        .height(20.90515.dp)
                )
            },
            trailingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.mic),
                    contentDescription = "MicIcon", modifier = Modifier
                        .padding(1.dp)
                        .width(24.dp)
                        .height(24.dp)
                )
            },
            //.height(50.dp)
        )
        IconButton(
            modifier = Modifier.size(60.dp),
            onClick = { /*TODO*/ }) {
            Image(
                painter = painterResource(id = R.drawable.ic_man),
                contentDescription = "AvatarIcon",
            )
        }
    }
}