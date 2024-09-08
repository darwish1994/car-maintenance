package com.dwa.mycar.feature.main.add.profile.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dwa.mycar.R
import com.dwa.mycar.feature.main.add.CreateProfileViewModel
import com.dwa.mycar.feature.main.add.nav.AddCarScreens
import com.dwa.mycar.ui.element.ToolbarAddScreen
import com.dwa.mycar.ui.theme.BlackColor
import com.dwa.mycar.ui.theme.PrimaryColor
import com.dwa.mycar.ui.theme.WhiteColor

@Composable
fun AddProfileScreen(navController: NavController, viewModel: CreateProfileViewModel) {
    LaunchedEffect(viewModel.profileState.finished) {
        if (viewModel.profileState.finished)
            navController.popBackStack("home", false)

    }
    Column(modifier = Modifier.fillMaxSize()) {
        ToolbarAddScreen(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            title = stringResource(id = R.string.create_profile_title)
        ) {
            navController.popBackStack()
        }

        OutlinedTextField(
            value = viewModel.profileState.profile,
            onValueChange = {
                viewModel.profileTypeChange(it)
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = BlackColor,
                focusedBorderColor = Color.LightGray,
                unfocusedBorderColor = Color.LightGray,
            ),
            shape = RoundedCornerShape(25.dp),
            label = {
                Text(text = stringResource(R.string.title_input))
            }
        )


        Button(
            onClick = {
                viewModel.saveProfile()
            }, modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = PrimaryColor,
                contentColor = WhiteColor
            ),
            enabled = viewModel.profileState.enable
        ) {
            Text(stringResource(R.string.btn_save))
        }

    }

}