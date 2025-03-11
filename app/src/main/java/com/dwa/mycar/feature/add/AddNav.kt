package com.dwa.mycar.feature.add

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dwa.mycar.feature.add.brands.ui.ChooseBrandScreen
import com.dwa.mycar.feature.add.model.ui.ChooseModelScreen
import com.dwa.mycar.feature.add.nav.AddCarScreens
import com.dwa.mycar.feature.add.profile.ui.AddProfileScreen

@Composable
fun AppNav(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
) {
    val viewModel: CreateProfileViewModel = hiltViewModel()
    NavHost(
        navController = navHostController,
        startDestination = AddCarScreens.BrandScreen.route,
        modifier = modifier
    ) {
        composable(AddCarScreens.BrandScreen.route) {
            ChooseBrandScreen(navController = navHostController, viewModel = viewModel)
        }
        composable(AddCarScreens.ModelScreen.route) {
            it.arguments?.getString("brand")?.let { brand ->
                ChooseModelScreen(
                    navController = navHostController,
                    brand = brand,
                    viewModel = viewModel
                )
            } ?: navHostController.popBackStack()
        }

        composable(AddCarScreens.ProfileScreen.route) {
            AddProfileScreen(navController = navHostController, viewModel = viewModel)


        }

    }


}

