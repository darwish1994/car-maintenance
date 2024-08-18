package com.dwa.mycar.feature.main.add.brands

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dwa.mycar.common.reader.DataReader
import com.dwa.mycar.feature.main.add.brands.state.BrandAction
import com.dwa.mycar.feature.main.add.brands.state.BrandState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BrandsViewModel @Inject constructor(private val dataReader: DataReader) : ViewModel() {

    var uiState by mutableStateOf(BrandState())
        private set


    fun uiAction(it: BrandAction) {
        when (it) {
            is BrandAction.LoadBrands -> loadBrands()
            is BrandAction.SelectBrand -> selectBrand(it.brand)
        }
    }

    private fun selectBrand(brand: String) {
        uiState = uiState.copy(selectedBrand = brand)

    }

    private fun loadBrands() {
        viewModelScope.launch {
            uiState = uiState.copy(brands = dataReader.readBrands())
        }
    }


}