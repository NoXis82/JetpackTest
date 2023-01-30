package ru.umarsh.jetpackcomposeapptest.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import ru.umarsh.jetpackcomposeapptest.DefaultDispatchers
import ru.umarsh.jetpackcomposeapptest.DispatcherProvider

class MainViewModel : ViewModel() {

    private val flow1 = (1..10).asFlow().onEach { delay(1000L) }
    private val flow2 = (10..20).asFlow().onEach { delay(400L) }
    var numberString by mutableStateOf("")
        private set

    init {
      //  flow1.zip(flow2) { number1, number2 ->
      //      numberString += "($number1, $number2)\n"
      //  }.launchIn(viewModelScope)

    //    merge(flow1, flow2).onEach {
    //        numberString += "$it\n"
    //    }.launchIn(viewModelScope)

        flow1.combine(flow2) { num1, num2 ->
            numberString += "($num1, $num2)\n"
        }.launchIn(viewModelScope)


    }




}