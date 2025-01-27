package com.example.learningstate

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WellnessScreen(modifier: Modifier = Modifier,
                   wellnessViewModel: WellnessViewModel = viewModel()
) {
    Column(modifier = modifier) {
        StatefulCounter()

        val list = remember { getWellnesTasks().toMutableStateList() }

//        if want to use mutableStateListof Api
//        val list = remember {
//
//            mutableStateListOf<WellnessTask>().apply { addAll(getWellnessTasks()) }
//
//        }

        wellnessTasksList(list = list, onCloseTask = {task -> wellnessViewModel.remove(task) })
    }
}

private fun getWellnesTasks() = List(15)
{i -> WellnessTask(i, "Task $i")}

