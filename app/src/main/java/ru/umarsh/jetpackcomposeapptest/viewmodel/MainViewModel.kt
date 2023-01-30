package ru.umarsh.jetpackcomposeapptest.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val countDownFlow = flow {
        val countStart = 10
        var currentCount = countStart
        emit(countStart)
        while (currentCount > 0) {
            delay(1000L)
            currentCount--
            emit(currentCount)
        }
    }

    init {
        collectionFlow()
    }

    private fun collectionFlow() {
        val flow = flow {
            delay(250L)
            emit("Закуски")
            delay(1000L)
            emit("Основное блюдо")
            delay(100L)
            emit("Десерт")
        }
        viewModelScope.launch {
            flow.onEach {
                println("FLOW: $it доставлен")
            }
                .buffer()
               // .conflate()
                .collect {
                    println("FLOW: Сейчас едим: $it")
                    delay(1500L)
                    println("FLOW: Закончили есть: $it")
                }

//            countDownFlow
//                .filter {
//                    it % 2 == 0
//                }
//                .map {
//                    it * it
//                }
//                .collect {
//                println("Current time: $it")
//            }
        }
    }


}