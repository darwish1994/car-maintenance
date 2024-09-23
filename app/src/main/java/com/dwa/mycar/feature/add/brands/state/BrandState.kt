package com.dwa.mycar.feature.add.brands.state

data class BrandState(
    val brands: List<String> = arrayListOf(),
    val selectedBrand: String? = null,
)
