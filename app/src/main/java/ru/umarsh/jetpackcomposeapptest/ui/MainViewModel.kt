package ru.umarsh.jetpackcomposeapptest.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import ru.umarsh.jetpackcomposeapptest.PersonalItem

class MainViewModel : ViewModel() {

    var isCurrentlyDragging by mutableStateOf(false)
    var items by mutableStateOf(emptyList<PersonalItem>())
        private set
    var addedPersonals = mutableStateListOf<PersonalItem>()
        private set

    init {
        items = listOf(
            PersonalItem(name = "Test_1", id = "1", backgroundColor = Color.Red),
            PersonalItem(name = "Test_2", id = "2", backgroundColor = Color.Gray),
            PersonalItem(name = "Test_3", id = "3", backgroundColor = Color.Green)
        )
    }

    fun startDragging() {
        isCurrentlyDragging = true
    }

    fun stopDragging() {
        isCurrentlyDragging = false
    }

    fun addPerson(personalItem: PersonalItem) {
        addedPersonals.add(personalItem)
    }

}