package com.dwa.mycar.feature.add

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.dwa.mycar.ui.theme.MyCarTheme
import com.dwa.mycar.ui.theme.WhiteColor
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddProfileActivity : ComponentActivity() {
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
                        navHostController = navController
                    )


                }
            }
        }


    }
}