package com.dwa.mycar.feature.main.add.brands.state

data class BrandState(
    val brands: List<String> = arrayListOf(),
    val selectedBrand: String? = null,
)
