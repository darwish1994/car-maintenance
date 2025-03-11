package com.dwa.mycar.ui.element

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.dwa.mycar.ui.theme.GrayColor
import com.dwa.mycar.ui.theme.PrimaryColor
import com.dwa.mycar.ui.theme.SecondaryColor
import com.dwa.mycar.ui.theme.WhiteColor

@Composable
fun InputTextLayout(
    modifier: Modifier,
    config: InputConfig = InputConfig(),
    value: String,
    onChange: (String) -> Unit
) {
    TextField(
        modifier = modifier,
        value = value,
        onValueChange = onChange,
        label = config.label?.let { { Text(text = config.label) } },
        placeholder = config.placeholder?.let { { Text(text = config.placeholder) } },
        keyboardOptions = KeyboardOptions(imeAction = config.imAction),
        maxLines = config.maxLines,
        colors = TextFieldDefaults.colors(
            focusedTextColor = PrimaryColor,
            focusedLabelColor = PrimaryColor,
            unfocusedLabelColor = GrayColor
        )
    )

}

@Composable
fun OutLineInputTextLayout(
    modifier: Modifier,
    config: InputConfig = InputConfig(),
    value: String,
    onChange: (String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onChange,
        label = config.label?.let { { Text(text = config.label) } },
        placeholder = config.placeholder?.let { { Text(text = config.placeholder) } },
        keyboardOptions = KeyboardOptions(imeAction = config.imAction),
        maxLines = config.maxLines,
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = PrimaryColor,
            focusedLabelColor = PrimaryColor,
            unfocusedLabelColor = GrayColor,
            focusedBorderColor = SecondaryColor,
            unfocusedContainerColor = WhiteColor,
            focusedContainerColor = WhiteColor
        ),
        shape = RoundedCornerShape(15.dp)
    )

}

data class InputConfig(
    val label: String? = null,
    val placeholder: String? = null,
    val imAction: ImeAction = ImeAction.Next,
    val maxLines: Int = 1

)