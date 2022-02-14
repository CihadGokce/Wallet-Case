package com.cihadgokce.wallet.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.ExperimentalUnitApi

private val DarkColorPalette = darkColors(
        primary = Teal200,
        primaryVariant = Purple700,
        secondary = Purple500
)

private val LightColorPalette = lightColors(
        primary = Teal200,
        primaryVariant = Purple700,
        secondary = Purple500

        /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@ExperimentalUnitApi
@Composable
fun WalletTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
            colors = colors,
            typography = typography,
            shapes = Shapes,
            content = content
    )
}