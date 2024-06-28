package com.dwa.mycar.reader


interface DataReader {

    suspend fun readBrands(): List<String>
    suspend fun readModel(): List<String>

}