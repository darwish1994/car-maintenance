package com.dwa.mycar.feature.main.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.dwa.mycar.R
import com.dwa.mycar.feature.main.add.nav.AddCarScreens
import com.dwa.mycar.ui.element.CartItemUi
import com.dwa.mycar.ui.theme.PrimaryColor
import com.dwa.mycar.ui.theme.SecondaryColor
import com.dwa.mycar.ui.theme.WhiteColor

@Composable
fun CarListScreen(
    modifier: Modifier,
    navController: NavController,
    viewModel: CarListViewModel = hiltViewModel()
) {
    Box(modifier = modifier) {
        ElevatedButton(
            modifier = Modifier
                .padding(24.dp)
                .align(Alignment.BottomEnd).zIndex(30f),
            onClick = {
                navController.navigate(AddCarScreens.BrandScreen.route)
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
            Row(
                modifier = Modifier
                    .padding(8.dp)

                    .fillMaxWidth(),
            ) {
                Image(painter = painterResource(id = R.drawable.logo), contentDescription = "")
                Spacer(modifier = Modifier.weight(1f))


                Text(

                    text = "Car List",
                    color = SecondaryColor,
                    fontSize = 22.sp
                )
            }
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