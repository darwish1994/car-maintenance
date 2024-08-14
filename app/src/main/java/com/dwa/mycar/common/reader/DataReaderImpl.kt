package com.dwa.mycar.common.reader

import android.content.Context
import com.dwa.mycar.common.extention.readJsonAsset
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class DataReaderImpl @Inject constructor(private val context:Context,private val gson: Gson) :
    DataReader {
    override suspend fun readBrands(): List<String> {
        try {
            val data = context.readJsonAsset("car_list.json")
            val stringListToken = object : TypeToken<List<String>>() {}
           return gson.fromJson<List<String>>(data,stringListToken)

        }catch (e:Exception){
            return emptyList()
        }


    }

    override suspend fun readModel(): List<String> {
        TODO("Not yet implemented")
    }
}