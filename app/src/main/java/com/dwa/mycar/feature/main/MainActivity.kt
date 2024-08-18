package com.dwa.mycar.feature.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.dwa.mycar.feature.main.add.AppNav
import com.dwa.mycar.feature.main.add.nav.AddCarScreens
import com.dwa.mycar.feature.main.home.CarListScreen
import com.dwa.mycar.ui.theme.SecondaryColor
import com.dwa.mycar.ui.theme.MyCarTheme
import com.dwa.mycar.ui.theme.PrimaryColor
import com.dwa.mycar.ui.theme.WhiteColor
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            MyCarTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    innerPadding.calculateTopPadding()
                    AppNav(
                        modifier = Modifier
                            .background(WhiteColor)
                            .padding(innerPadding)
                            .fillMaxSize(),
                        navHostController = navController, startDestination = "home"
                    )


                }
            }
        }


    }


}

