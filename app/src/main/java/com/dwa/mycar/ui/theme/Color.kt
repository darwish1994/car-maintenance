package com.dwa.mycar.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val PrimaryColor = Color(0xFFFF191B)
val SecondaryColor = Color(0xFF0C2635)
val BlackColor = Color(0xFF222327)
val WhiteColor = Color(0xFFFFFFFF)

val sky_bg = Brush.verticalGradient(
    listOf(
        PrimaryColor,
        WhiteColor,
        PrimaryColor,
    )
)