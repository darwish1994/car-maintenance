package com.dwa.mycar.feature.main.add.profile.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.dwa.mycar.R
import com.dwa.mycar.ui.element.ToolbarAddScreen

@Composable
fun AddProfileScreen(navController: NavController){
    Column(modifier = Modifier.fillMaxSize()) {
        ToolbarAddScreen(
            modifier = Modifier.fillMaxWidth(),
            title = stringResource(id = R.string.create_profile_title)
        ) {
            navController.popBackStack()
        }





    }

}