package com.example.androidprac.presentation.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.androidprac.R
import com.example.androidprac.presentation.NavigationRoute
import com.example.androidprac.presentation.components.ButtonComp

// object for Colors and Dimensions
object Variables {
    val xSm: Dp = 8.dp
    val sm: Dp = 12.dp
    val Grey200: Color = Color(0xFFEEEEEE)
    val Grey900: Color = Color(0xFF212121)
    val textInactive: Color = Color(0x99000000)
    val primary500: Color = Color(0xFF6366F1)
    val textIconographyDarkActive: Color = Color(0xDEFFFFFF)
}

// Welcome Page
@Composable
fun WelcomePage(
    navController: NavController,
    onboardingViewModel: OnboardingViewModel = hiltViewModel()
) {

    val counter = onboardingViewModel.counter.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .padding(horizontal = 15.dp, vertical = 50.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
    )
    {
        // Text for APP Name
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .height(32.dp),
            text = "Hey Hello!",
            style = TextStyle(
                fontSize = 24.sp,
                lineHeight = 32.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(700),
                color = Color(0x99000000),
            ),
        )
        // Image for Splash Screen
        Image(
            painter = painterResource(id = R.drawable.splash),
            contentDescription = "SplashPic"
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(256.dp)
                .padding(
                    start = Variables.xSm,
                    top = Variables.xSm,
                    end = Variables.xSm,
                    bottom = Variables.xSm
                ),
            verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            // Custom Button for Login With Google
            ButtonComp(
                text = "  Continue With Google",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                onClick = { },
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight(600),
                    color = Variables.Grey900,
                ),
                shape = RoundedCornerShape(999.dp),
                colors = ButtonDefaults.buttonColors(Variables.Grey200),
                IconStart = {
                    Image(
                        painter = painterResource(id = R.drawable.ic_google),
                        contentDescription = "GoogleIcon", modifier = Modifier
                            .width(24.dp)
                            .height(24.dp)
                    )
                }
            )
            // Custom Button for Login With Github

            ButtonComp(onClick = { },
                text = "  Continue With Github",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight(600),
                    color = Variables.Grey900,
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(Variables.Grey200),
                shape = RoundedCornerShape(999.dp),
                IconStart = {
                    Image(
                        painter = painterResource(id = R.drawable.ic_github),
                        contentDescription = "GithubIcon", modifier = Modifier
                            .width(24.dp)
                            .height(24.dp)
                            .padding(2.dp)
                    )
                }
            )
            // Text for OR
            Text(
                text = "OR",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight(600),
                    color = Variables.textInactive,
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier
                    .width(23.dp)
                    .height(24.dp)
            )
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
                // Custom Button for Login With Email
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
                        // Right Icon For Custom Button
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
        }
    }
}
