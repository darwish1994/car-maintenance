package com.dwa.mycar.feature.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.dwa.mycar.ui.theme.MyCarTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            MyCarTheme {
                Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = {
                    MainBottomBar(modifier = Modifier.fillMaxWidth(), navController = navController)
                }, topBar = {

                }) { innerPadding ->
                    MainNavGraph(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(innerPadding),
                        navHostController = navController
                    )
                }
            }
        }

    }


}

