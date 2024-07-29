package com.example.androidprac.presentation.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.androidprac.R
import com.example.androidprac.presentation.NavigationRoute
import com.example.androidprac.presentation.components.ButtonComp

@Composable
// Account Page
fun SignUpScreen(navController: NavController) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 50.dp), verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Column(
                Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(32.dp, Alignment.Top),
                horizontalAlignment = Alignment.Start,
            ) {
                // Text for APP Name
                Text(
                    text = "Create Account",
                    Modifier
                        .fillMaxWidth(),
                    style = TextStyle(
                        fontSize = 24.sp,
                        lineHeight = 32.sp,
                        fontWeight = FontWeight(700),
                        color = Color.Gray,
                    )
                )
                Column(
                    Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
                    horizontalAlignment = Alignment.Start,
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                        verticalAlignment = Alignment.Top,
                    ) {
                        // Text for Full Name
                        Text(
                            text = "Full Name ",
                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 20.sp,
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight(600),
                                color = Color.Black,
                            ),
                            modifier = Modifier
                                .width(66.dp)
                                .height(20.dp)
                        )
                        // Text for *
                        Text(
                            text = "*",
                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 20.sp,
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight(600),
                                color = Color.Red
                            )
                        )
                    }
                    // Text Field for Full Name
                    OutlinedTextField(modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        placeholder = {
                            Text(text = "john Doe")
                        },
                        leadingIcon = {
                            // Account Icon
                            Icon(
                                imageVector = Icons.Default.AccountCircle,
                                contentDescription = "AccountIcon"
                            )
                        }
                    )
                }
                Column(
                    Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
                    horizontalAlignment = Alignment.Start,
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                        verticalAlignment = Alignment.Top,
                    ) {
                        // Text for Email
                        Text(
                            text = "Email ",
                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 20.sp,
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight(600),
                                color = Color.Black,
                            ),
                            modifier = Modifier
                                .width(38.dp)
                        )
                        // Text for *
                        Text(
                            text = "*",
                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 20.sp,
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight(600),
                                color = Color.Red
                            )
                        )
                    }
                    // Text Field for Email
                    OutlinedTextField(modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        placeholder = {
                            Text(text = "john@example.com")
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Email,
                                contentDescription = "EmailIcon"
                            )
                        }
                    )
                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                        verticalAlignment = Alignment.Top,
                    ) {
                        // Text for Password
                        Text(
                            text = "Password ",
                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 20.sp,
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight(600),
                                color = Color.Black
                            ),
                            modifier = Modifier
                                .width(66.dp)
                                .height(20.dp)
                        )
                        // Text for *
                        Text(
                            text = "*",
                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 20.sp,
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight(600),
                                color = Color.Red
                            )
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(
                            12.dp,
                            Alignment.CenterHorizontally
                        ),
                        verticalAlignment = Alignment.CenterVertically,
                    )
                    {
                        // Text Field for Password
                        OutlinedTextField(modifier = Modifier.fillMaxWidth(),
                            value = "",
                            onValueChange = {},
                            placeholder = {
                                Text(text = "********")
                            },
                            leadingIcon = {
                                // Password Icon
                                Image(
                                    painter = painterResource(id = R.drawable.password),
                                    contentDescription = "PassIcon",
                                    modifier = Modifier
                                        .width(24.dp)
                                        .height(24.dp)
                                )
                            }
                        )
                    }
                }
            }

            Column(
                Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(32.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(
                        8.dp,
                        Alignment.CenterHorizontally
                    ),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                ) {
                    // Custom Button for Continue With Email
                    ButtonComp(onClick = { navController.navigate(NavigationRoute.Login) },
                        text = "Continue With Email",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight(400),
                            color = Variables.textIconographyDarkActive,
                            textAlign = TextAlign.Center,
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        colors = ButtonDefaults.buttonColors(Variables.primary500),
                        shape = RoundedCornerShape(999.dp),
                        IconEnd = {
                            // Right Icon
                            Image(
                                painter = painterResource(id = R.drawable.righthdicon),
                                contentDescription = "RightIcon",
                                modifier = Modifier
                                    .padding(1.dp)
                                    .width(20.dp)
                                    .height(20.dp)
                            )
                        }
                    )
                }
                Row(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.Start),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    // Text for New Here
                    Text(text = "New here? Create an account.")
                    // Clickable Text for Log in
                    Text(
                        color = Color.Blue,
                        text = "Log in",
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .width(66.dp)
                            .clickable { navController.navigate(NavigationRoute.Login) }
                    )
                }
            }
        }
    }
}