package ru.umarsh.jetpackcomposeapptest

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import kotlinx.coroutines.delay

@Composable
fun RememberUpdateScopeDemo(
    onTimeout: () -> Unit
) {
    val updateOnTimeout by rememberUpdatedState(newValue = onTimeout)
    LaunchedEffect(key1 = true) {
        delay(3000)
        updateOnTimeout()
    }
}