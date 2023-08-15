package com.example.android.architecture.blueprints.todoapp.tasks

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@Config(sdk = [30])
@RunWith(AndroidJUnit4::class)
class TasksViewModelTest {

    //criando o viewmodel/Given
    private lateinit var tasksViewModel: TasksViewModel

    // Executes each task synchronously using Architecture Components.
   @get:Rule
   var instantExecutorRule = InstantTaskExecutorRule()

    //
    @Before
    fun setupViewModel() {
        tasksViewModel = TasksViewModel(ApplicationProvider.getApplicationContext())
    }


    @Test
    fun addNewTask_setsNewTaskEvent() {

            // When adding a new task
            tasksViewModel.addNewTask()

            // Then the new task event is triggered. obtendo o livedata para o newtask
            val value = tasksViewModel.newTaskEvent.getOrAwaitValue()
            //getContentIfNotHandled - one time: obtem o conteúdo do arquivo Event, quaisquer chamadas adicionais, retornarão null
            assertThat(value.getContentIfNotHandled(), (not(nullValue())))
        }

    @Test
    //verifica se definiu seu tipo de filtro para mostrar todas as tarefas, se o
    //botão Adiconar tarefa está visível
    fun setFilterAllTasks_tasksAddViewVisible() {

        //When the filter type is ALL_TASK - passando a enumeração de filtro
        tasksViewModel.setFiltering(TasksFilterType.ALL_TASKS)

        //Then the "Add task" action is visible
        assertThat(tasksViewModel.tasksAddViewVisible.getOrAwaitValue(), `is`(true))


    }

    }
