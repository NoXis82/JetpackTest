package ru.umarsh.jetpackcomposeapptest.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
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
                .background(Color.Gray)
                .border(5.dp, Color.Magenta)
                .padding(5.dp)
                .border(5.dp, Color.Red)
                .padding(5.dp)
                .border(5.dp, Color.Cyan),
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
                .background(Color.Green)
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Text(text = "Hello", modifier = Modifier.clickable {
                
            })
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "World!", modifier = Modifier
                    .border(5.dp, Color.Magenta)
                    .padding(5.dp)
                    .offset(10.dp, 10.dp)
                    .border(5.dp, Color.Red)
                    .padding(5.dp)
            )
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
