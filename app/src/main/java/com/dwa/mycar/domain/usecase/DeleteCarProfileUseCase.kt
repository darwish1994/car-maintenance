package com.dwa.mycar.domain.usecase

import com.dwa.mycar.domain.model.CarProfile
import com.dwa.mycar.domain.repo.CarProfileRepo
import javax.inject.Inject

class DeleteCarProfileUseCase @Inject constructor(
    private val carProfileRepo: CarProfileRepo
) : BaseUseCase<Unit, Int>() {
    override suspend fun execute(params: Int) {
        carProfileRepo.deleteCarProfile(params)
    }

}