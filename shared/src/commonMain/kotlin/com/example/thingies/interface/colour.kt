package com.example.thingies.`interface`

import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.ui.graphics.Color

// win 98 = 0xFFFF3200
val lightColours = lightColorScheme (
    primary = Color(0xFFDBDBDB),
    onPrimary = Color(0xFF000000),

    primaryContainer = Color(0xFFFF3200),
    onPrimaryContainer = Color(0xFFFF3200),

    secondary = Color(0xFFFF3200),
    onSecondary = Color(0xFFFF3200),

    secondaryContainer = Color(0xFFFF3200),
    onSecondaryContainer = Color(0xFFFF3200),

    tertiary = Color(0xFFFF3200),
    onTertiary = Color(0xFFFF3200),

    tertiaryContainer = Color(0xFFFF3200),
    onTertiaryContainer = Color(0xFFFF3200),

    background = Color(0xFFFFFFFFF),
    onBackground = Color(0xFFFF3200),

    surface = Color(0xFFFF3200),
    onSurface = Color(0xFFFF3200),
)

val darkColours = darkColorScheme(
    primary = Color(0xFF6D6D6D),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFF000000),
    onPrimaryContainer = Color(0xFF000000),

    secondary = Color(0xFF000000),
    secondaryContainer = Color(0xFF000000),
    onSecondary = Color(0xFF000000),
    onSecondaryContainer = Color(0xFF000000),

    tertiary = Color(0xFF000000),
    onTertiary = Color(0xFF000000),
    onTertiaryContainer = Color(0xFF000000),

    background = Color(0xFF000000),
    surface = Color(0xFF000000),
)