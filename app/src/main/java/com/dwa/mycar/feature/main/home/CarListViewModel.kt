package com.dwa.mycar.feature.main.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dwa.mycar.domain.usecase.CarProfileListUseCase
import com.dwa.mycar.feature.main.home.state.CarListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CarListViewModel @Inject constructor(
    private val carListProfiles: CarProfileListUseCase
) : ViewModel() {

    var uiState by mutableStateOf(CarListState())
        private set


    fun fetchAllCars() {
        viewModelScope.launch {
            carListProfiles.invoke(Unit).onEach {
                Log.v("CarListViewModel","data: $it")
                uiState = uiState.copy(carProfileList = it)
            }.launchIn(this)
        }

    }


}