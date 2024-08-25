package com.dwa.mycar.feature.main.add.model.state

import com.dwa.mycar.domain.model.Model

data class ModelState(
    val models: List<Model> = arrayListOf(),
    val selectedMode: Model? = null,
)
