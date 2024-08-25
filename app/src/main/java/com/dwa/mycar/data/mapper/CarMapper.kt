package com.dwa.mycar.data.mapper

import com.dwa.mycar.data.model.ModelDt
import com.dwa.mycar.domain.model.Model
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class CarMapper @Inject constructor() : ModelMapper<Model, ModelDt> {
    override fun mapToModel(model: ModelDt): Model = Model(
        brand = model.brand,
        models = model.models
    )

    override fun mapToDomainModel(model: Model): ModelDt = ModelDt(
        brand = model.brand,
        models = model.models
    )

    override fun mapListToModel(model: List<ModelDt>): List<Model> = model.map { mapToModel(it) }
}