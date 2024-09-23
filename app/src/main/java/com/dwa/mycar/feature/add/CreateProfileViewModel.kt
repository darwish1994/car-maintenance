package com.dwa.mycar.feature.add

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dwa.mycar.common.reader.DataReader
import com.dwa.mycar.domain.model.CarProfile
import com.dwa.mycar.domain.usecase.CreateCarProfileUseCase
import com.dwa.mycar.domain.usecase.FetchModelUseCase
import com.dwa.mycar.feature.add.brands.state.BrandAction
import com.dwa.mycar.feature.add.brands.state.BrandState
import com.dwa.mycar.feature.add.model.state.ModelState
import com.dwa.mycar.feature.add.model.state.ModelUiAction
import com.dwa.mycar.feature.add.profile.state.CreateProfileState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateProfileViewModel @Inject constructor(
    private val fetchModelUseCase: FetchModelUseCase,
    private val dataReader: DataReader,
    private val createProfileUseCase: CreateCarProfileUseCase
) : ViewModel() {
    var modelUiState by mutableStateOf(ModelState())
        private set
    var brandUiState by mutableStateOf(BrandState())
        private set
    var profileState by mutableStateOf(CreateProfileState())
        private set


    fun onModelUiAction(it: ModelUiAction) {
        when (it) {
            is ModelUiAction.LoadModels -> loadModels(it.brand)
            is ModelUiAction.SelectModel -> selectModel(it.model)
        }

    }

    fun onBrandUiAction(it: BrandAction) {
        when (it) {
            is BrandAction.LoadBrands -> loadBrands()
            is BrandAction.SelectBrand -> selectBrand(it.brand)
        }
    }

    private fun loadModels(brand: String) {
        viewModelScope.launch {
            modelUiState = modelUiState.copy(models = fetchModelUseCase.invoke(brand).models)
        }
    }

    private fun selectModel(model: String) {
        modelUiState = modelUiState.copy(selectedMode = model)

    }


    private fun selectBrand(brand: String) {
        brandUiState = brandUiState.copy(selectedBrand = brand)

    }

    private fun loadBrands() {
        viewModelScope.launch {
            brandUiState = brandUiState.copy(brands = dataReader.readModel().map { it.brand })
        }
    }

    fun profileTypeChange(name: String) {
        profileState = profileState.copy(profile = name, error = null)

    }

    fun saveProfile() {
        if (profileState.profile.isBlank()) {
            profileState = profileState.copy(error = "please enter a valid name")
            return
        }

        profileState = profileState.copy(enable = false)
        // save car to db
        viewModelScope.launch {
            createProfileUseCase.invoke(
                CarProfile(
                    name = profileState.profile,
                    model = modelUiState.selectedMode ?: "",
                    brand = brandUiState.selectedBrand ?: "",
                    distance = 0.0
                )

            )
            profileState = profileState.copy(finished = true)
        }
    }


}