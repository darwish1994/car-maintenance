package com.dwa.mycar.feature.car.add

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.dwa.mycar.R

@Composable
fun ChooseModelScreen(){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = stringResource(id = R.string.choose_model_title))
        



    }

}