package com.example.androidprac.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun CustomInputField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    textStyle: TextStyle = TextStyle.Default,
    label: String? = null,
    placeholder: String? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    singleLine: Boolean = false,
    modifier: Modifier = Modifier.fillMaxWidth(),
    shape: Shape = OutlinedTextFieldDefaults.shape,
    colors: TextFieldColors = TextFieldDefaults.colors(),
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        textStyle = textStyle,
        label = { label?.let { Text(it) } },
        placeholder = { placeholder?.let { Text(it) } },
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        visualTransformation = visualTransformation,
        enabled = enabled,
        readOnly = readOnly,
        singleLine = singleLine,
        modifier = modifier.padding(top = 0.dp),
        shape = shape,
        colors = colors,
        keyboardActions = keyboardActions,
        //interactionSource = interactionSource,

    )
}

@Composable
fun MyCustomInputField() {
    var text by remember { mutableStateOf(TextFieldValue()) }
    CustomInputField(
        value = text,
        onValueChange = {
            text = it
        },
        label = "Email",
        placeholder = "johnexample@123",
        leadingIcon = { Icon(Icons.Filled.Email, contentDescription = "emailIcon") },
        trailingIcon = { Icon(Icons.Filled.Check, contentDescription = "checkIcon") },
        singleLine = true,
        textStyle = TextStyle.Default,
        shape = ShapeDefaults.Medium
    )
}


