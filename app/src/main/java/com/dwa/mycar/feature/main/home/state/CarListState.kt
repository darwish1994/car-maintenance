package com.dwa.mycar.feature.main.home.state

import com.dwa.mycar.domain.model.Car

data class CarListState(
    val carList: List<Car> = emptyList()

)
