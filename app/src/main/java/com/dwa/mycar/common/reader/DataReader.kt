package com.dwa.mycar.common.reader

import com.dwa.mycar.data.model.CarDt


interface DataReader {

    suspend fun readBrands(): List<String>
    suspend fun readModel(): List<CarDt>

}