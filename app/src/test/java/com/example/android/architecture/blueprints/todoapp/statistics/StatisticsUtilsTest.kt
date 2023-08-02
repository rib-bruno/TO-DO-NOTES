package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.Matchers
import org.junit.Assert.*
import org.junit.Test

/**
 * TODO verificar:
 * se não houver tarefas concluídas e uma tarefa ativa;
 * que a porcentagem de tstes ativos é 100%;
 * que a porcentagem de tasks concluídas é 0%.
 */

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

        //When
        val result = getActiveAndCompletedStats(tasks)

        //Then
//        assertEquals(result.completedTasksPercent,0f)
//        assertEquals(result.activeTasksPercent,100f)
        assertThat(result.activeTasksPercent, Matchers.`is`(100f))
        assertThat(result.completedTasksPercent, Matchers.`is`(0f))
    }

}