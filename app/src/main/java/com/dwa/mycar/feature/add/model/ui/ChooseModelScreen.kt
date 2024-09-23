package com.dwa.mycar.feature.add.model.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dwa.mycar.R
import com.dwa.mycar.feature.add.CreateProfileViewModel
import com.dwa.mycar.feature.add.model.state.ModelUiAction
import com.dwa.mycar.feature.add.nav.AddCarScreens
import com.dwa.mycar.ui.element.SelectorItem
import com.dwa.mycar.ui.element.ToolbarAddScreen

@Composable
fun ChooseModelScreen(
    navController: NavController,
    brand: String,
    viewModel: CreateProfileViewModel
) {
    LaunchedEffect(key1 = brand) {
        viewModel.onModelUiAction(ModelUiAction.LoadModels(brand))
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        ToolbarAddScreen(
            modifier = Modifier.fillMaxWidth(),
            title = stringResource(id = R.string.choose_model_title)
        ) {
            navController.popBackStack()
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(viewModel.modelUiState.models) {
                SelectorItem(
                    modifier = Modifier,
                    title = it,
                    selected = it == viewModel.modelUiState.selectedMode
                ) {
                    viewModel.onModelUiAction(ModelUiAction.SelectModel(it))
                    navController.navigate(AddCarScreens.ProfileScreen.route)
                }
            }
        }

    }

}