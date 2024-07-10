package com.dwa.mycar.feature.main.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.dwa.mycar.feature.main.home.state.CarListState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CarListViewModel @Inject constructor() : ViewModel() {

    var uiState by mutableStateOf(CarListState())
        private set






}