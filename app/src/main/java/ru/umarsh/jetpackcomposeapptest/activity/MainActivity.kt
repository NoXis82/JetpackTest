package ru.umarsh.jetpackcomposeapptest.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.umarsh.jetpackcomposeapptest.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = viewModel<MainViewModel>()
            //val time = viewModel.countDownFlow.collectAsState(initial = 10)
            val count = viewModel.countStateFlow.collectAsState(0)
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
              //  Text(text = time.value.toString(), fontSize = 30.sp)
                Button(onClick = { viewModel.incrementCount()}) {
                    Text(text = "Count: ${count.value}")
                }
            }
        }
    }
}
