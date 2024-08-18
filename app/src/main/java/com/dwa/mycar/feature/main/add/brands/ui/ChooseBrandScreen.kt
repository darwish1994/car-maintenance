package com.dwa.mycar.feature.main.add.brands.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.dwa.mycar.feature.main.add.brands.BrandsViewModel
import com.dwa.mycar.feature.main.add.brands.state.BrandAction
import com.dwa.mycar.feature.main.add.model.ModelViewModel
import com.dwa.mycar.feature.main.add.nav.AddCarScreens
import com.dwa.mycar.ui.theme.BlackColor

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
        Row {
            Icon(
                imageVector = Icons.Outlined.ArrowBack,
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(end = 16.dp)
                    .clickable {
                        navController.popBackStack()
                    })


            Text(text = stringResource(id = R.string.choose_brand_title))

        }
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(viewModel.uiState.brands) {
                Text(
                    text = it,
                    modifier = Modifier
                        .clickable {
                            viewModel.uiAction(BrandAction.SelectBrand(it))
                            navController.navigate(AddCarScreens.ModelScreen.buildRoute(it))
                        }
                        .fillMaxWidth()

                        .padding(16.dp),
                    color = BlackColor,
                    fontSize = 16.sp,

                )


            }

        }

    }

}