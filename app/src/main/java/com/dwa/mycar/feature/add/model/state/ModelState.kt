package com.dwa.mycar.feature.add.model.state

import com.dwa.mycar.domain.model.Model

data class ModelState(
    val models: List<String> = arrayListOf(),
    val selectedMode: String? = null,
)
