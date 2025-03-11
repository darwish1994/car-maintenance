package com.dwa.mycar.feature.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dwa.mycar.feature.main.home.HomeScreenUi
import com.dwa.mycar.feature.main.more.MoreScreenUi
import com.dwa.mycar.feature.main.service.ServiceScreenUi
import kotlinx.serialization.Serializable


@Serializable
object HomeScreen

@Serializable
object ServiceScreen

@Serializable
object MoreScreen


@Composable
fun MainNavGraph(modifier: Modifier, navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = HomeScreen, modifier = modifier) {
        composable<HomeScreen> {
            HomeScreenUi(hiltViewModel())
        }
        composable<ServiceScreen> {
            ServiceScreenUi(navHostController)
        }
        composable<MoreScreen> {
            MoreScreenUi(navHostController)
        }
    }
}

@Composable
fun MainBottomBar(modifier: Modifier, navController: NavController) {
    var selectedItem by remember { mutableStateOf(0) }
    NavigationBar(modifier = modifier) {
        NavigationBarItem(
            selected = selectedItem == 0,
            onClick = {
                selectedItem = 0
                navController.navigate(HomeScreen)
            },
            icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
            label = { Text("Home") }
        )

        NavigationBarItem(
            selected = selectedItem == 1,
            onClick = {
                selectedItem = 1
                navController.navigate(ServiceScreen)
            },
            icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
            label = { Text("Service") }
        )

        NavigationBarItem(
            selected = selectedItem == 2,
            onClick = {
                selectedItem = 2
                navController.navigate(MoreScreen)
            },
            icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
            label = { Text("More") }
        )


    }

}