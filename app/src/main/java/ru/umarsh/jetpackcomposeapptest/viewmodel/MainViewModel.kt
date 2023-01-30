package ru.umarsh.jetpackcomposeapptest.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import ru.umarsh.jetpackcomposeapptest.DefaultDispatchers
import ru.umarsh.jetpackcomposeapptest.DispatcherProvider

class MainViewModel(
  private val dispatcher: DispatcherProvider
) : ViewModel() {

    private val _countStateFlow = MutableStateFlow(0)
    val countStateFlow = _countStateFlow.asStateFlow()

    private val _countSharedFlow = MutableSharedFlow<Int>(replay = 2)
    val countSharedFlow = _countSharedFlow.asSharedFlow()

    val countDownFlow = flow {
        val countStart = 10
        var currentCount = countStart
        emit(countStart)
        while (currentCount > 0) {
            delay(1000L)
            currentCount--
            emit(currentCount)
        }
    }.flowOn(dispatcher.main)

    init {
        //collectionFlow()
        squareNumber(3)
       // squareNumber(4)
        viewModelScope.launch(dispatcher.main) {
            countSharedFlow.collect {
                delay(2000L)
                println("FLOW_1: Number: $it")
            }
        }
        viewModelScope.launch(dispatcher.main) {
            countSharedFlow.collect {
                delay(3000L)
                println("FLOW_2: Number: $it")
            }
        }
//        squareNumber(3)

    }

    fun squareNumber(number: Int) {
        viewModelScope.launch(dispatcher.main) {
            _countSharedFlow.emit(number * number)
        }
    }

    fun incrementCount() {
        _countStateFlow.value += 1
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