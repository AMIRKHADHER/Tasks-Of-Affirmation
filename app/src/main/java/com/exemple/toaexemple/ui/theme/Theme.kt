package com.exemple.toaexemple.ui.theme

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.os.BuildCompat


@SuppressLint("NewApi")
@Composable
fun TOAExempleTheme(
    isDark: Boolean = isSystemInDarkTheme(),
    dynamic: Boolean = BuildCompat.isAtLeastS(),
    content: @Composable () -> Unit,
) {
    val colors = when {
        dynamic && isDark -> dynamicDarkColorScheme(LocalContext.current)
        dynamic && !isDark -> dynamicLightColorScheme(LocalContext.current)
        isDark -> DarkThemeColors
        else -> LightThemeColors
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content,
    )
}
