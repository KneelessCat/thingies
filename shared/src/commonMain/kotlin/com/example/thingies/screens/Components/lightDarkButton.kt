package com.example.thingies.screens.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun lightDarkButton(lm: Boolean, toggle: () -> Unit)
{
    var lightDarkText = if (lm) "Light Mode" else "Dark Mode"

    Row(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .safeContentPadding()
            .fillMaxSize(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Bottom,
    )
    {
        Button(
            onClick = { toggle() },
            shape = RoundedCornerShape(35),
            modifier = Modifier.padding(vertical = 15.dp, horizontal = 15.dp),
            contentPadding = PaddingValues(5.dp)
        ) { Text(lightDarkText) }
    }
}