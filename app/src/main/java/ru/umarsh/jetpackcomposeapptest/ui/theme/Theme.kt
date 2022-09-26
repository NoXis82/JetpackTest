package ru.umarsh.jetpackcomposeapptest.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import ru.umarsh.jetpackcomposeapptest.ui.theme.Shapes
import ru.umarsh.jetpackcomposeapptest.ui.theme.Typography

@Composable
fun MeditationUIYouTubeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    MaterialTheme(
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}