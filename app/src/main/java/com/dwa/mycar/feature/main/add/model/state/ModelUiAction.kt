package com.dwa.mycar.feature.main.add.model.state

import com.dwa.mycar.domain.model.Model

sealed class ModelUiAction {
    data class LoadModels(val brand: String) : ModelUiAction()
    data class SelectModel(val model: String) : ModelUiAction()

}