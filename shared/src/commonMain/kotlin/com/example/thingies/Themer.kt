package com.example.thingies

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable


@Composable
fun AppThemer(
    // light mode is either true or false, we have the win98 default colour scheme, or a darker one
    // This is monitored in App.kt so change happens in there
    lightMode: Boolean = true,

    // This means the AppThemer looks like:
    // AppThemer(true/false) {@Composable function}
    // Looks very similar to the Material Theme {} we initially had in the example given
    content: @Composable () -> Unit
) {
    // Edits the colour scheme, leaves the content
    MaterialTheme (
        colorScheme = if (lightMode) lightColours else darkColours,
        content = content
    )
}
