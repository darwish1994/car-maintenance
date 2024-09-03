package com.dwa.mycar.ui.element

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dwa.mycar.R
import com.dwa.mycar.ui.theme.BlackColor

@Composable
fun ToolbarAddScreen(modifier: Modifier=Modifier,title:String,onBack:()->Unit){
    Row {
        Icon(
            imageVector = Icons.Outlined.ArrowBack,
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(end = 16.dp)
                .clickable {
                    onBack()
                })


        Text(text = title, color = BlackColor, fontSize = 16.sp)

    }
}