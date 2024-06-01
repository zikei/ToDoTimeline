package com.example.todo.ui.form

import com.example.todo.domain.enums.TaskStatus
import com.example.todo.domain.model.Todo
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import java.time.LocalDate

/** ToDo一覧返却 */
data class GetTodoListResponse(val todoList: List<TodoInfo>)

/** Todo詳細返却 */
data class GetTodoDetailResponse(val todo: TodoInfo)


/** ToDo情報 */
data class TodoInfo(
    val taskId: Int,
    val userId: Int,
    val taskName: String,
    val createDate: LocalDate,
    val severity: String,
    val deadline: LocalDate?,
    val taskStatus: TaskStatusResponse,
    val parentId: Int?,
    val parentName: String?
){
    constructor(todo: Todo): this(todo.taskId, todo.userId, todo.taskName, todo.createDate, todo.severity.severityName,
        todo.deadline, TaskStatusResponse(todo.taskStatus), todo.parent?.taskId, todo.parent?.taskName)
}

data class TaskStatusResponse(
    val status: String,
    val statusName: String
){
    constructor(taskStatus: TaskStatus): this(taskStatus.status, taskStatus.statusName)
}