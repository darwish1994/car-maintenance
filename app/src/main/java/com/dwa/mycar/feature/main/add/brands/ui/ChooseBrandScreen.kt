package com.dwa.mycar.feature.main.add.brands.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dwa.mycar.R
import com.dwa.mycar.feature.main.add.CreateProfileViewModel
import com.dwa.mycar.feature.main.add.brands.state.BrandAction
import com.dwa.mycar.feature.main.add.nav.AddCarScreens
import com.dwa.mycar.ui.element.SelectorItem
import com.dwa.mycar.ui.element.ToolbarAddScreen

@Composable
fun ChooseBrandScreen(navController: NavController, viewModel: CreateProfileViewModel ) {
    LaunchedEffect(key1 = LocalContext.current) {
        viewModel.onBrandUiAction(BrandAction.LoadBrands)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        ToolbarAddScreen(
            modifier = Modifier.fillMaxWidth(),
            title = stringResource(id = R.string.choose_brand_title)
        ) {
            navController.popBackStack()
        }

        LazyColumn(modifier = Modifier.fillMaxSize().padding(top = 16.dp)) {
            items(viewModel.brandUiState.brands) {
                SelectorItem(
                    modifier = Modifier,
                    title = it,
                    selected = it == viewModel.brandUiState.selectedBrand
                ){
                    viewModel.onBrandUiAction(BrandAction.SelectBrand(it))
                    navController.navigate(AddCarScreens.ModelScreen.buildRoute(it))
                }
            }

        }

    }

}