package com.dwa.mycar.feature.car.add.state

data class BrandState(
    val brands: List<String> = arrayListOf(),
    val selectedBrand: String? = null,
)
