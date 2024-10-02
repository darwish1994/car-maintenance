package com.dwa.mycar.feature.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dwa.mycar.ui.element.AuthButton
import com.dwa.mycar.ui.theme.BlackColor
import com.dwa.mycar.ui.theme.Title_1_Color
import com.dwa.mycar.ui.theme.WhiteColor
import com.dwa.mycar.ui.theme.appFont

@Composable
@Preview(showBackground = true)
fun AuthScreen() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Text(
            "Stay on top of your car’s health!",
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth(),
            color = Title_1_Color,
            fontSize = 16.sp,
            fontFamily = appFont,
            fontWeight = FontWeight.Normal
        )
        Text(
            "Welcome to Car Care App!",
            modifier = Modifier
                .padding(top = 32.dp, bottom = 20.dp)
                .fillMaxWidth(),
            color = Title_1_Color,
            fontSize = 32.sp,
            fontFamily = appFont,
            fontWeight = FontWeight.SemiBold
        )

        AuthButton(
            modifier = Modifier.fillMaxWidth(), text = "Continue with Google"
        ) { }
        AuthButton(
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(), text = "Continue with Facebook"
        ) { }
        AuthButton(
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(), text = "Continue with Email"
        ) { }
        Text(
            "or", modifier = Modifier
                .padding(top = 20.dp),
            fontSize = 16.sp,
            fontFamily = appFont,
            fontWeight = FontWeight.Normal
        )
        AuthButton(
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(), text = "Continue as Guest"
        ) { }


    }


}