package ru.umarsh.jetpackcomposeapptest.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import ru.umarsh.jetpackcomposeapptest.DraggableScreen
import ru.umarsh.jetpackcomposeapptest.MainScreen
import ru.umarsh.jetpackcomposeapptest.ui.MainViewModel

class MainActivity : ComponentActivity() {

    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DraggableScreen(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.8f))
            ) {
                MainScreen(mainViewModel = viewModel)
            }
        }
    }
}
