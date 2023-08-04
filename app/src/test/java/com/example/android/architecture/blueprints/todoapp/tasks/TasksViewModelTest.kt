package com.example.android.architecture.blueprints.todoapp.tasks

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@Config(sdk = [30])
@RunWith(AndroidJUnit4::class)
class TasksViewModelTest {

    @Test
    fun addNewTask_setNewTaskEvent() {
        //given a fresh taskViewModel
        val tasksViewModel = TasksViewModel(ApplicationProvider.getApplicationContext())

        //when adding a new task
        tasksViewModel.addNewTask()

        //then the new task event is triggered
        //TODO test LiveData


    }
}