package com.dwa.mycar.data.mapper

import com.dwa.mycar.data.model.CarProfileDT
import com.dwa.mycar.domain.model.CarProfile
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject


@ViewModelScoped
class CarProfileMapper @Inject constructor() : ModelMapper<CarProfile, CarProfileDT> {
    override fun mapToModel(model: CarProfileDT): CarProfile = CarProfile(
        id = model.id,
        name = model.name,
        brand = model.brand,
        model = model.model,
        distance = model.distance
    )

    override fun mapToDomainModel(model: CarProfile): CarProfileDT = CarProfileDT(
        id = model.id,
        name = model.name,
        brand = model.brand,
        model = model.model,
        distance = model.distance
    )

    override fun mapListToModel(model: List<CarProfileDT>): List<CarProfile> =
        model.map { mapToModel(it) }


}