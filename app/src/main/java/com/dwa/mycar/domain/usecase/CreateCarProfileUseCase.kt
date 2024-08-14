package com.dwa.mycar.domain.usecase

import com.dwa.mycar.domain.model.CarProfile
import com.dwa.mycar.domain.repo.CarProfileRepo
import javax.inject.Inject

class CreateCarProfileUseCase @Inject constructor(
    private val carProfileRepo: CarProfileRepo
) : BaseUseCase<Unit, CarProfile>() {
    override suspend fun execute(params: CarProfile) {
        carProfileRepo.createCarProfile(params)
    }

}