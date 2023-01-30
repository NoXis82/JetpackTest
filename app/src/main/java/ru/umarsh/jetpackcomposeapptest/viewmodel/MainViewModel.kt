package ru.umarsh.jetpackcomposeapptest.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
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
        viewModelScope.launch {
            countDownFlow.collect {
                println("Current time: $it")
            }
        }
    }


}