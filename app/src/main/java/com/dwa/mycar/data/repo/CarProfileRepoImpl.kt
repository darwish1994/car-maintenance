package com.dwa.mycar.data.repo

import android.util.Log
import com.dwa.mycar.data.database.CarProfileDao
import com.dwa.mycar.data.mapper.CarProfileMapper
import com.dwa.mycar.domain.model.CarProfile
import com.dwa.mycar.domain.repo.CarProfileRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CarProfileRepoImpl @Inject constructor(
    private val profileDao: CarProfileDao,
    private val mapper: CarProfileMapper,
) : CarProfileRepo {
    override suspend fun createCarProfile(carProfile: CarProfile) {
        Log.v("CarListViewModel", "save model:$carProfile")
        profileDao.createProfile(
            mapper.mapToDomainModel(carProfile)
        )
    }

    override suspend fun deleteCarProfile(id: Int) {
        profileDao.getCarProfileByIg(id)?.let {
            profileDao.deleteProfile(it)
        }
    }

    override suspend fun updateCarProfile(carProfile: CarProfile) {
        profileDao.updateProfile(
            mapper.mapToDomainModel(carProfile)
        )
    }

    override fun getAllCarProfiles(): Flow<List<CarProfile>> {
        val cars = profileDao.getProfiles()
        return cars.map { mapper.mapListToModel(it) }
    }

}