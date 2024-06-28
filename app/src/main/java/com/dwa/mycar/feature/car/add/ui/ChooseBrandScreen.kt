package com.dwa.mycar.feature.car.add.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.dwa.mycar.R
import com.dwa.mycar.feature.car.add.AddCarViewModel

@Composable
fun ChooseBrandScreen(viewModel: AddCarViewModel=hiltViewModel()){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = stringResource(id = R.string.choose_brand_title))




    }

}