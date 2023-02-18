package io.vanite.android.compose.ui


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object VaniteColors {

    @Composable
    fun getScreenBackgroundColor(): Color {
        return when (isSystemInDarkTheme()) {
            true -> Color(0xFF1D1D1D)
            false -> Color(0xFFF1F1F1)
        }
    }

    @Composable
    fun getTextColor(): Color {
        return when (!isSystemInDarkTheme()) {
            true -> Color(0xFF000000)
            false -> Color(0xFFFFFFFF)
        }
    }

    @Composable
    fun getSeconderyCardsColor(): Color {
        return MaterialTheme.colorScheme.background
    }

    @Composable
    fun getPrimaryColor(): Color {
        return MaterialTheme.colorScheme.primary
    }

    @Composable
    fun getApplicationColor(): Color {
        return when (isSystemInDarkTheme()) {
            true -> Color(0xFFFFD600)
            false -> Color(0xFFFF5252)
        }
    }

    @Composable
    fun getApplicationSecondColor(): Color {
        return Color(0xFFF18484)
    }

    @Composable
    fun getSecondColor(): Color {
        return MaterialTheme.colorScheme.primaryContainer
    }

    @Composable
    fun getBackgroundSecondColor(): Color {
        return when (isSystemInDarkTheme()) {
            true -> Color(0xFF2C2C2C)
            false -> Color(0xFFECECEC)
        }
    }

    @Composable
    fun getOutlineColor(): Color {
        return MaterialTheme.colorScheme.outline
    }

}