package com.dwa.mycar.common.reader

import com.dwa.mycar.data.model.ModelDt


interface DataReader {

    suspend fun readModel(): List<ModelDt>

}