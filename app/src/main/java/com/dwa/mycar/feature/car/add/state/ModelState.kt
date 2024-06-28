package com.dwa.mycar.feature.car.add.state

data class ModelState(
    val brands: List<String> = arrayListOf(),
    val selectedBrand: String? = null,
)
