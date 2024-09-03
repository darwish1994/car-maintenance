package com.dwa.mycar.ui.element

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dwa.mycar.common.extention.conditionalModifier
import com.dwa.mycar.feature.main.add.model.state.ModelUiAction
import com.dwa.mycar.ui.theme.BlackColor
import com.dwa.mycar.ui.theme.SelectedColor
import com.dwa.mycar.ui.theme.WhiteColor

@Composable
fun SelectorItem(
    modifier: Modifier = Modifier,
    title: String,
    selected: Boolean = false,
    onClicked: () -> Unit
) {
    Text(
        text = title,
        modifier = modifier
            .clickable {
                onClicked()
            }
            .fillMaxWidth()
            .conditionalModifier(
                selected
            ) {
                background(color = SelectedColor, shape = RoundedCornerShape(15.dp))
            }
            .padding(16.dp),
        color = if (selected) WhiteColor else BlackColor,
        fontSize = 16.sp,

        )

}