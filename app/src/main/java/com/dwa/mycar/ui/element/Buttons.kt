package com.dwa.mycar.ui.element

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dwa.mycar.ui.theme.BlackColor
import com.dwa.mycar.ui.theme.WhiteColor
import com.dwa.mycar.ui.theme.appFont

@Composable
fun AuthButton(modifier: Modifier,text:String,onClick:()->Unit){
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            contentColor = WhiteColor,
            containerColor = BlackColor
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(
            text,
            fontSize = 18.sp,
            fontFamily = appFont,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(8.dp)
        )
    }

}