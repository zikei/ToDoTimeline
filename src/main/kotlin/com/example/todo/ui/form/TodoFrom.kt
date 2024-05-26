package com.example.todo.ui.form

import com.example.todo.domain.enums.Severity
import com.example.todo.domain.enums.TaskStatus
import com.example.todo.domain.model.Todo
import java.time.LocalDate

/** ToDo一覧返却 */
data class GetTodoListResponse(val todoList: List<TodoInfo>)

/** ToDo情報 */
data class TodoInfo(
    val taskId: Int,
    val userId: Int,
    val taskName: String,
    val createDate: LocalDate,
    val severity: Severity?,
    val deadline: LocalDate?,
    val taskStatus: TaskStatus,
    val parentId: Int?,
    val parentName: String?
){
    constructor(todo: Todo): this(todo.taskId, todo.userId, todo.taskName, todo.createDate, todo.severity,
        todo.deadline, todo.taskStatus, todo.parent?.taskId, todo.parent?.taskName)
}