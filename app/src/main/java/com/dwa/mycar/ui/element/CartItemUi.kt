package com.dwa.mycar.ui.element

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dwa.mycar.R
import com.dwa.mycar.domain.model.Car
import com.dwa.mycar.ui.theme.BlackColor

@Composable
fun CartItemUi(modifier: Modifier = Modifier, car: Car) {
    ElevatedCard(modifier = modifier, shape = RoundedCornerShape(15.dp)) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "car",
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(15.dp))
            )

            Column(
                modifier = Modifier
                    .weight(3f)
                    .padding(8.dp)
            ) {

                Text(
                    text = car.name,
                    color = BlackColor,
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Start
                )

                Text(
                    text = car.brand,
                    color = BlackColor,
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth(),
                    fontSize = 14.sp,
                    textAlign = TextAlign.Start
                )
                Text(
                    text = car.model,
                    color = BlackColor,
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth(),
                    fontSize = 14.sp,
                    textAlign = TextAlign.Start
                )

            }


        }
    }
}