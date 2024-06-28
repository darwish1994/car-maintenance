package com.dwa.mycar.feature.car.add

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

@HiltViewModel
class AddCarViewModel @Inject constructor(
    @ActivityContext private val context: Context,

    ) :ViewModel() {


suspend fun readBrands(data:String){

}



}