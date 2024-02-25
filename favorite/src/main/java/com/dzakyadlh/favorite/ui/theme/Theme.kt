package com.dzakyadlh.favorite.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColorScheme = lightColorScheme(
    primary = com.dzakyadlh.gamestoreapp.theme.md_theme_light_primary,
    onPrimary = com.dzakyadlh.gamestoreapp.theme.md_theme_light_onPrimary,
    primaryContainer = com.dzakyadlh.gamestoreapp.theme.md_theme_light_primaryContainer,
    onPrimaryContainer = com.dzakyadlh.gamestoreapp.theme.md_theme_light_onPrimaryContainer,
    secondary = com.dzakyadlh.gamestoreapp.theme.md_theme_light_secondary,
    onSecondary = com.dzakyadlh.gamestoreapp.theme.md_theme_light_onSecondary,
    secondaryContainer = com.dzakyadlh.gamestoreapp.theme.md_theme_light_secondaryContainer,
    onSecondaryContainer = com.dzakyadlh.gamestoreapp.theme.md_theme_light_onSecondaryContainer,
    tertiary = com.dzakyadlh.gamestoreapp.theme.md_theme_light_tertiary,
    onTertiary = com.dzakyadlh.gamestoreapp.theme.md_theme_light_onTertiary,
    tertiaryContainer = com.dzakyadlh.gamestoreapp.theme.md_theme_light_tertiaryContainer,
    onTertiaryContainer = com.dzakyadlh.gamestoreapp.theme.md_theme_light_onTertiaryContainer,
    error = com.dzakyadlh.gamestoreapp.theme.md_theme_light_error,
    errorContainer = com.dzakyadlh.gamestoreapp.theme.md_theme_light_errorContainer,
    onError = com.dzakyadlh.gamestoreapp.theme.md_theme_light_onError,
    onErrorContainer = com.dzakyadlh.gamestoreapp.theme.md_theme_light_onErrorContainer,
    background = com.dzakyadlh.gamestoreapp.theme.md_theme_light_background,
    onBackground = com.dzakyadlh.gamestoreapp.theme.md_theme_light_onBackground,
    surface = com.dzakyadlh.gamestoreapp.theme.md_theme_light_surface,
    onSurface = com.dzakyadlh.gamestoreapp.theme.md_theme_light_onSurface,
    surfaceVariant = com.dzakyadlh.gamestoreapp.theme.md_theme_light_surfaceVariant,
    onSurfaceVariant = com.dzakyadlh.gamestoreapp.theme.md_theme_light_onSurfaceVariant,
    outline = com.dzakyadlh.gamestoreapp.theme.md_theme_light_outline,
    inverseOnSurface = com.dzakyadlh.gamestoreapp.theme.md_theme_light_inverseOnSurface,
    inverseSurface = com.dzakyadlh.gamestoreapp.theme.md_theme_light_inverseSurface,
    inversePrimary = com.dzakyadlh.gamestoreapp.theme.md_theme_light_inversePrimary,
    surfaceTint = com.dzakyadlh.gamestoreapp.theme.md_theme_light_surfaceTint,
    outlineVariant = com.dzakyadlh.gamestoreapp.theme.md_theme_light_outlineVariant,
    scrim = com.dzakyadlh.gamestoreapp.theme.md_theme_light_scrim,
)


private val DarkColorScheme = darkColorScheme(
    primary = com.dzakyadlh.gamestoreapp.theme.md_theme_dark_primary,
    onPrimary = com.dzakyadlh.gamestoreapp.theme.md_theme_dark_onPrimary,
    primaryContainer = com.dzakyadlh.gamestoreapp.theme.md_theme_dark_primaryContainer,
    onPrimaryContainer = com.dzakyadlh.gamestoreapp.theme.md_theme_dark_onPrimaryContainer,
    secondary = com.dzakyadlh.gamestoreapp.theme.md_theme_dark_secondary,
    onSecondary = com.dzakyadlh.gamestoreapp.theme.md_theme_dark_onSecondary,
    secondaryContainer = com.dzakyadlh.gamestoreapp.theme.md_theme_dark_secondaryContainer,
    onSecondaryContainer = com.dzakyadlh.gamestoreapp.theme.md_theme_dark_onSecondaryContainer,
    tertiary = com.dzakyadlh.gamestoreapp.theme.md_theme_dark_tertiary,
    onTertiary = com.dzakyadlh.gamestoreapp.theme.md_theme_dark_onTertiary,
    tertiaryContainer = com.dzakyadlh.gamestoreapp.theme.md_theme_dark_tertiaryContainer,
    onTertiaryContainer = com.dzakyadlh.gamestoreapp.theme.md_theme_dark_onTertiaryContainer,
    error = com.dzakyadlh.gamestoreapp.theme.md_theme_dark_error,
    errorContainer = com.dzakyadlh.gamestoreapp.theme.md_theme_dark_errorContainer,
    onError = com.dzakyadlh.gamestoreapp.theme.md_theme_dark_onError,
    onErrorContainer = com.dzakyadlh.gamestoreapp.theme.md_theme_dark_onErrorContainer,
    background = com.dzakyadlh.gamestoreapp.theme.md_theme_dark_background,
    onBackground = com.dzakyadlh.gamestoreapp.theme.md_theme_dark_onBackground,
    surface = com.dzakyadlh.gamestoreapp.theme.md_theme_dark_surface,
    onSurface = com.dzakyadlh.gamestoreapp.theme.md_theme_dark_onSurface,
    surfaceVariant = com.dzakyadlh.gamestoreapp.theme.md_theme_dark_surfaceVariant,
    onSurfaceVariant = com.dzakyadlh.gamestoreapp.theme.md_theme_dark_onSurfaceVariant,
    outline = com.dzakyadlh.gamestoreapp.theme.md_theme_dark_outline,
    inverseOnSurface = com.dzakyadlh.gamestoreapp.theme.md_theme_dark_inverseOnSurface,
    inverseSurface = com.dzakyadlh.gamestoreapp.theme.md_theme_dark_inverseSurface,
    inversePrimary = com.dzakyadlh.gamestoreapp.theme.md_theme_dark_inversePrimary,
    surfaceTint = com.dzakyadlh.gamestoreapp.theme.md_theme_dark_surfaceTint,
    outlineVariant = com.dzakyadlh.gamestoreapp.theme.md_theme_dark_outlineVariant,
    scrim = com.dzakyadlh.gamestoreapp.theme.md_theme_dark_scrim,
)

@Composable
fun GameStoreAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = DarkColorScheme
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = com.dzakyadlh.gamestoreapp.theme.Typography,
        content = content
    )
}