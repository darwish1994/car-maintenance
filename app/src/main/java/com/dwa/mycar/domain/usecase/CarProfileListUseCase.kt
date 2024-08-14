package com.dwa.mycar.domain.usecase

import com.dwa.mycar.domain.model.CarProfile
import com.dwa.mycar.domain.repo.CarProfileRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CarProfileListUseCase @Inject constructor(
    private val carProfileRepo: CarProfileRepo
) : BaseUseCase<Flow<List<CarProfile>>,Unit >() {
    override suspend fun execute(params: Unit):Flow<List<CarProfile>>  = carProfileRepo.getAllCarProfiles()

}