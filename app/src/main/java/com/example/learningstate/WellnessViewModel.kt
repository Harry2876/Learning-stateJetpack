package com.example.learningstate

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class WellnessViewModel : ViewModel() {
    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks : List<WellnessTask>
        get() = _tasks

    //adding function for removing tasks
    fun remove(item : WellnessTask) {
        _tasks.remove(item)
    }

    fun changeTaskStatus(item: WellnessTask, checked:Boolean) =
        _tasks.find { it.id == item.id }?.let { tasks -> tasks.checked = checked }
}

private fun getWellnessTask() = List(15) {i -> WellnessTask(i, "Task $i")}