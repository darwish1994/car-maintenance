package com.dwa.mycar.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val CloudColor = Color(0xFF98a7bc)
val BlueColor = Color(0xFF4455FB)
val BlackColor = Color(0xFF222327)
val WhiteColor = Color(0xFFFAFAFA)

val sky_bg= Brush.verticalGradient(
    listOf(
        CloudColor,
        CloudColor,
        WhiteColor
    )
)