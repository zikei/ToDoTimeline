package com.example.todo.domain.model

import com.example.todo.domain.enums.Severity
import com.example.todo.domain.enums.TaskStatus
import java.time.LocalDate

/** ToDoエンティティ */
data class Todo(
    val taskId: Int,
    val userId: Int,
    val taskName: String,
    val createDate: LocalDate,
    val severity: Severity?,
    val deadline: LocalDate?,
    val taskStatus: TaskStatus,
    val parent: Todo?
)
