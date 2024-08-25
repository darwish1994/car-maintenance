package com.dwa.mycar.domain.usecase

import com.dwa.mycar.common.reader.DataReader
import com.dwa.mycar.data.mapper.CarMapper
import com.dwa.mycar.domain.model.Model
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FetchModelUseCase @Inject constructor(
    private val dataReader: DataReader,
    private val carMapper: CarMapper
) : BaseUseCase<List<Model>, String>() {
    override suspend fun execute(params: String): List<Model> {
        return withContext(Dispatchers.IO) {
            val carDts = dataReader.readModel().filter { it.brand == params }
            carMapper.mapListToModel(carDts)
        }
    }
}