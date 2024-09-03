package com.dwa.mycar.feature.main.add.brands.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.dwa.mycar.R
import com.dwa.mycar.common.extention.conditionalModifier
import com.dwa.mycar.feature.main.add.brands.BrandsViewModel
import com.dwa.mycar.feature.main.add.brands.state.BrandAction
import com.dwa.mycar.feature.main.add.model.ModelViewModel
import com.dwa.mycar.feature.main.add.nav.AddCarScreens
import com.dwa.mycar.ui.element.SelectorItem
import com.dwa.mycar.ui.element.ToolbarAddScreen
import com.dwa.mycar.ui.theme.BlackColor
import com.dwa.mycar.ui.theme.SelectedColor

@Composable
fun ChooseBrandScreen(navController: NavController, viewModel: BrandsViewModel = hiltViewModel()) {
    LaunchedEffect(key1 = LocalContext.current) {
        viewModel.uiAction(BrandAction.LoadBrands)
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
            items(viewModel.uiState.brands) {
                SelectorItem(
                    modifier = Modifier,
                    title = it,
                    selected = it == viewModel.uiState.selectedBrand
                ){
                    viewModel.uiAction(BrandAction.SelectBrand(it))
                    navController.navigate(AddCarScreens.ModelScreen.buildRoute(it))
                }
            }

        }

    }

}