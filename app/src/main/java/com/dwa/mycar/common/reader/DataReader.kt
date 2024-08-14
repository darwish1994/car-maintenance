package com.dwa.mycar.common.reader


interface DataReader {

    suspend fun readBrands(): List<String>
    suspend fun readModel(): List<String>

}