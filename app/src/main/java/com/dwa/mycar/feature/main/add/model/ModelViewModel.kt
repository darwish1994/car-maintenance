package com.dwa.mycar.feature.main.add.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dwa.mycar.domain.model.Model
import com.dwa.mycar.domain.usecase.FetchModelUseCase
import com.dwa.mycar.feature.main.add.model.state.ModelState
import com.dwa.mycar.feature.main.add.model.state.ModelUiAction
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ModelViewModel @Inject constructor(private val fetchModelUseCase: FetchModelUseCase) :
    ViewModel() {

    var uiSTate by mutableStateOf(ModelState())
        private set

    fun onUiAction(it: ModelUiAction) {
        when (it) {
            is ModelUiAction.LoadModels -> loadModels(it.brand)
            is ModelUiAction.SelectModel -> selectModel(it.model)


        }

    }

    private fun loadModels(brand: String) {
        viewModelScope.launch {
            uiSTate = uiSTate.copy(models = fetchModelUseCase.invoke(brand))
        }
    }

    private fun selectModel(model: Model) {
        uiSTate = uiSTate.copy(selectedMode = model)

    }


}