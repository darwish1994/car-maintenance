package com.dwa.mycar.ui.element

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dwa.mycar.R
import com.dwa.mycar.ui.theme.BlackColor
import com.dwa.mycar.ui.theme.PrimaryColor
import com.dwa.mycar.ui.theme.SecondaryColor
import com.dwa.mycar.ui.theme.regularFont

@Composable
fun ToolbarAddScreen(modifier: Modifier = Modifier, title: String, onBack: () -> Unit) {
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


@Composable
fun ToolBarHomeScreen(
    modifier: Modifier
) {
    Row(modifier, verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = Icons.Outlined.Menu,
            "more",
            modifier = Modifier
                .background(PrimaryColor.copy(alpha = 0.25f), shape = CircleShape)
                .padding(2.5.dp),
            tint = SecondaryColor
        )

        Text(
            "My Car",
            color = SecondaryColor,
            fontSize = 24.sp,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center,
            fontFamily = regularFont
        )

        Icon(
            imageVector = Icons.Outlined.Notifications,
            "notification",
            modifier = Modifier
                .background(PrimaryColor.copy(alpha = 0.25f), shape = CircleShape)
                .padding(2.5.dp),
            tint = SecondaryColor
        )

    }
}