package com.dwa.mycar.feature.main.add.nav

sealed class AddCarScreens(val route: String) {
    object BrandScreen : AddCarScreens("brand")
    object ModelScreen : AddCarScreens("model/{brand}") {
        fun buildRoute(brand: String) = "model/$brand"
    }

}