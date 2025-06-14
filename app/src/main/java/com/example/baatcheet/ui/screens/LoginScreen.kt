package com.example.baatcheet.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.baatcheet.R
import com.example.baatcheet.ui.components.AppButton
import com.example.baatcheet.ui.components.HeadingText
import com.example.baatcheet.ui.components.LoginField
import com.example.baatcheet.ui.components.NormalText
import com.example.baatcheet.ui.components.TermText
import com.example.baatcheet.ui.theme.navigation.NavigationItem
import com.example.baatcheet.ui.theme.white

@Composable
fun LoginScreen(navController: NavController? = null) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = white
    ) {
        var phoneNumber by remember { mutableStateOf("") }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp)
        ) {
            HeadingText(
                stringResource(id = R.string.login),
                MaterialTheme.typography.headlineLarge
            )
            Spacer(modifier = Modifier.height(20.dp))

            NormalText(stringResource(id = R.string.login_subheading), TextAlign.Start)
            LoginField(
                value = phoneNumber,
                onChange = { newValue ->
                    if (newValue.length <= 10) {
                        phoneNumber = newValue
                    }
                }
            )

            Spacer(modifier = Modifier.height(10.dp))
            TermText(stringResource(id = R.string.terms_and_conditions), TextAlign.Center, 12.sp)

            AppButton(stringResource(id = R.string.login), onClick = {


                navController?.navigate(NavigationItem.OTP.route) {
                    popUpTo(NavigationItem.Splash.route) { inclusive = true }
                }
            })
        }
    }
}


@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}