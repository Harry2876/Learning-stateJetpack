package com.example.learningstate

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

fun getWellnessTasks() = List(30) {
    i -> WellnessTask(i, "Task $i")}

@Composable
fun wellnessTasksList(modifier: Modifier = Modifier,
                      list: List<WellnessTask>,
                      onCloseTask : (WellnessTask) -> Unit,
                      onCheckedTask : (WellnessTask, Boolean) -> Unit) {
    LazyColumn(modifier = modifier) {
      items(
          items = list,
          key= {task -> task.id}
      ) {
          task -> WellnessTaskItem(taskName = task.label,
          onClose = {onCloseTask(task)},
              checked = task.checked,
              onCheckChange = {checked -> onCheckedTask(task, checked)})
      }
    }
}