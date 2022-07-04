package ru.umarsh.jetpackcomposeapptest.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.umarsh.jetpackcomposeapptest.ui.ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Greeting(name = "Slava")
                }
            }
        }

    }
}

@Composable
fun Greeting(name: String) {
    Row( modifier = Modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically) {
        Column(
            modifier = Modifier
                .fillMaxHeight(0.9f)
                .background(Color.Green),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        )
        {
            Text(text = "Hello $name!")
            Text(text = "Hello World!")
            Text(text = "Jetpack")
        }
        Column(
            modifier = Modifier
                .width(200.dp)
                .height(300.dp)
                .background(Color.Gray),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        )
        {
            Text(text = "Hello $name!")
            Text(text = "Hello World!")
            Text(text = "Jetpack")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTheme {
        Greeting(name = "Vyacheslav")
    }
}
