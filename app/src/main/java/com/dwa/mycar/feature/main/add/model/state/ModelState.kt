package com.dwa.mycar.feature.main.add.model.state

data class ModelState(
    val brands: List<String> = arrayListOf(),
    val selectedBrand: String? = null,
)
