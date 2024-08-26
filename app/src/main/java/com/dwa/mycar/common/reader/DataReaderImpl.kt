package com.dwa.mycar.common.reader

import android.content.Context
import com.dwa.mycar.common.dispatcher.DispatcherProvider
import com.dwa.mycar.common.extention.readJsonAsset
import com.dwa.mycar.data.model.ModelDt
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DataReaderImpl @Inject constructor(
    private val context: Context,
    private val gson: Gson,
    private val dispatcherProvider: DispatcherProvider

) :
    DataReader {
    override suspend fun readBrands(): List<String> = withContext(dispatcherProvider.io) {
        try {
            val data = context.readJsonAsset("car_brands.json")
            val stringListToken = object : TypeToken<List<String>>() {}
            gson.fromJson<List<String>>(data, stringListToken)

        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun readModel(): List<ModelDt> = withContext(dispatcherProvider.io) {
        try {
            val data = context.readJsonAsset("car_list.json")
            val stringListToken = object : TypeToken<List<ModelDt>>() {}
            gson.fromJson(data, stringListToken)

        } catch (e: Exception) {
            emptyList()
        }
    }
}