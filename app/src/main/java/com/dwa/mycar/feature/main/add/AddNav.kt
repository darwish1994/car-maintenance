package com.dwa.mycar.feature.main.add

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dwa.mycar.feature.main.add.brands.ui.ChooseBrandScreen
import com.dwa.mycar.feature.main.add.model.ui.ChooseModelScreen
import com.dwa.mycar.feature.main.add.nav.AddCarScreens
import com.dwa.mycar.feature.main.add.profile.ui.AddProfileScreen
import com.dwa.mycar.feature.main.home.CarListScreen

@Composable
fun AppNav(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    startDestination: String
) {
    val viewModel:CreateProfileViewModel = hiltViewModel()
    NavHost(
        navController = navHostController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable("home") {
            CarListScreen(modifier = Modifier.fillMaxSize(), navController = navHostController)
        }
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

