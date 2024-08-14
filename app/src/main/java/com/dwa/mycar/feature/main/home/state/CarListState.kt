package com.dwa.mycar.feature.main.home.state

import com.dwa.mycar.domain.model.CarProfile

data class CarListState(
    val carProfileList: List<CarProfile> = emptyList()

)
