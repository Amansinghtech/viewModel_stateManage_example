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
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.androidprac.R
import com.example.androidprac.presentation.NavigationRoute
import com.example.androidprac.presentation.components.ButtonComp

@Composable
// Login Page
fun LoginScreen(
    navController: NavController,
    onboardingViewModel: OnboardingViewModel = hiltViewModel()
) {

    //Checkbox for Remember Me
    var checked by remember { mutableStateOf(true) }

    //Main Column
    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 50.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    //Column for Screen
    {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.Top),
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                // Text for APP Name
                Text(
                    text = "Hey, Hello 👋🏻 ",
                    style = TextStyle(
                        fontSize = 24.sp,
                        lineHeight = 32.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight(700),
                        color = Color.Gray
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .fillMaxWidth()
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
                    // Email Field
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
                        .fillMaxWidth()
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
                        // Password Field
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
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Checkbox for Remember Me
                    Checkbox(
                        checked = checked,
                        onCheckedChange = { checked = it }
                    )
                    Text(text = "Remember Me")
                }
            }
            Column(
                Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(32.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally,
            )
            {
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
                    // Custom Button For Login
                    ButtonComp(onClick = { navController.navigate(NavigationRoute.Home) },
                        text = "LOG IN",
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
                            // Right Icon For Login Button
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
                    Modifier
                        .align(Alignment.CenterHorizontally),
                    horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.Start),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    // Text for New Here
                    Text(text = "New here? Create an account.")
                    //Clickable Text for Sign Up
                    Text(
                        text = "Sign up",
                        textAlign = TextAlign.Center,
                        color = Color.Blue,
                        modifier = Modifier
                            .width(66.dp)
                            .clickable { navController.navigate(NavigationRoute.Account) }
                    )
                }
            }
        }
    }
}



