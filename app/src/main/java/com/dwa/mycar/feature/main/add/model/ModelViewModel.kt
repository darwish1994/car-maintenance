package com.dwa.mycar.feature.main.add.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dwa.mycar.common.reader.DataReader
import com.dwa.mycar.feature.main.add.brands.state.BrandState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ModelViewModel @Inject constructor(private val dataReader: DataReader) : ViewModel() {

    var uiBrandState by mutableStateOf(BrandState())
        private set


    private fun loadBrands() {
        viewModelScope.launch {
            uiBrandState = uiBrandState.copy(brands = dataReader.readBrands())
        }
    }


}