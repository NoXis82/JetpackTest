package ru.umarsh.jetpackcomposeapptest.product_state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import kotlinx.coroutines.delay

@Composable
fun productStateDemo(countUpTo: Int): State<Int> {
    return produceState(initialValue = 0) {
        while (countUpTo > value) {
            delay(1000L)
            this.value++
        }
    }

//    return flow<Int> {
//        var value = 0
//        while (value < countUpTo) {
//            delay(1000)
//            value++
//            emit(value)
//        }
//    }.collectAsState(initial = 0)
}