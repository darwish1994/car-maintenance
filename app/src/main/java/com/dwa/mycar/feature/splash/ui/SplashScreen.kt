package com.dwa.mycar.feature.splash.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.dwa.mycar.R
import com.dwa.mycar.ui.theme.WhiteColor

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun SplashScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(WhiteColor)
    ) {

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .align(Alignment.Center),
            contentScale = ContentScale.FillWidth
        )


    }
}