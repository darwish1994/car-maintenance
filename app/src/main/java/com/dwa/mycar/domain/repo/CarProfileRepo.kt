package com.dwa.mycar.domain.repo

import com.dwa.mycar.domain.model.CarProfile
import kotlinx.coroutines.flow.Flow

interface CarProfileRepo {

    suspend fun createCarProfile(carProfile: CarProfile)
    suspend fun deleteCarProfile(id:Int)
    suspend fun updateCarProfile(carProfile: CarProfile)
    fun getAllCarProfiles():Flow<List<CarProfile>>

}