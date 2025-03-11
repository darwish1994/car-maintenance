package com.dwa.mycar.feature.main.home

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import com.dwa.mycar.feature.add.AddProfileActivity
import com.dwa.mycar.feature.main.HomeScreen
import com.dwa.mycar.ui.element.CartItemUi
import com.dwa.mycar.ui.element.ToolBarHomeScreen
import com.dwa.mycar.ui.theme.PrimaryColor
import com.dwa.mycar.ui.theme.WhiteColor

@Composable
fun HomeScreenUi(
    viewModel: CarListViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    LaunchedEffect(Lifecycle.State.RESUMED) {
        viewModel.fetchAllCars()
    }

    Box(modifier = Modifier.fillMaxSize()) {
        ElevatedButton(
            modifier = Modifier
                .padding(24.dp)
                .align(Alignment.BottomEnd)
                .zIndex(30f),
            onClick = {
                context.apply {
                    startActivity(
                        Intent(
                            this,
                            AddProfileActivity::class.java
                        )
                    )
                }
            },
            shape = RoundedCornerShape(25.dp),
            colors = ButtonDefaults.elevatedButtonColors(
                containerColor = PrimaryColor,
                contentColor = WhiteColor,

                ),
            elevation = ButtonDefaults.elevatedButtonElevation(
                defaultElevation = 10.dp,
                pressedElevation = 15.dp
            )
        ) {
            Text(text = "Add Car")
        }

        Column(modifier = Modifier.fillMaxSize()) {
            ToolBarHomeScreen(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(24.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(viewModel.uiState.carProfileList) {
                    CartItemUi(carProfile = it, modifier = Modifier.fillMaxWidth())
                }
            }


        }

    }
}