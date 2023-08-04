package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.Matchers
import org.hamcrest.Matchers.`is`
import org.junit.Assert.*
import org.junit.Test

class StatisticsUtilsTest {

    @Test
    fun getActiveAndCompleteStats_noCompleted_returnsHundredZero() {
        //create an active task
        //call your function
        //check the result

        //Given
        val tasks = listOf<Task>(
            Task(
                title = "title",
                description = "desc",
                isCompleted = false
            )
        )

        //When (the list of tasks is computed with an active task
        val result = getActiveAndCompletedStats(tasks)

        //Then (the percentages are 100 and 0
//        assertEquals(result.completedTasksPercent,0f)
//        assertEquals(result.activeTasksPercent,100f)
        assertThat(result.activeTasksPercent, Matchers.`is`(100f))
        assertThat(result.completedTasksPercent, Matchers.`is`(0f))
    }

    @Test
    fun getActivesAndCompletedStats_noActive_returnsZeroHundred() {

        //given
        val tasks = listOf<Task>(
            Task(
            title = "title", description = "desc", isCompleted = true
            )
        )
        //when (quando a lista de tasks tem uma completed task
        val result = getActiveAndCompletedStats(tasks)

        //then
        assertThat(result.activeTasksPercent, `is` (0f))
        assertThat(result.completedTasksPercent, `is` (100f))

    }

    @Test
    fun getActivesAndCompletedStats_both_returnsFortySixty() {

        //given 3 completed tasks and 2 active tasks
        val tasks = listOf<Task>(
            Task(
                title = "title", description = "desc", isCompleted = true
            ),
            Task(
                title = "title", description = "desc", isCompleted = true
            ),
            Task(
                title = "title", description = "desc", isCompleted = true
            ),
            Task(
                title = "title", description = "desc", isCompleted = false
            ),
            Task(
                title = "title", description = "desc", isCompleted = false
            )

        )
        //when
        val result = getActiveAndCompletedStats(tasks)

        //then (the result is 40-60
        assertThat(result.activeTasksPercent, `is` (40f))
        assertThat(result.completedTasksPercent, `is` (60f))
    }

    //se tiver uma lista vazia
    @Test
    fun getActivesAndCompletedStats_empty_returnsZeros() {

        //when (não tem tasks
        val result = getActiveAndCompletedStats(emptyList())

        //then
        assertThat(result.activeTasksPercent, `is` (0f))
        assertThat(result.completedTasksPercent, `is` (0f))
    }

    //erro ao carregar listas
    @Test
    fun getActivesAndCompletedStats_error_returnsZeros() {

        //when
        val result = getActiveAndCompletedStats(tasks = null)

        //then
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }



}