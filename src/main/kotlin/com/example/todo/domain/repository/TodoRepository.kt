package com.example.todo.domain.repository

import com.example.todo.domain.model.Task
import com.example.todo.domain.model.Todo


interface TodoRepository {
    /** タスクIDからTodoを取得 */
    fun findById(taskId: Int): Todo?

    /** ユーザIDからユーザのTodoのListを取得 */
    fun findListByUserId(userId: Int): List<Todo>

    /** Task登録 */
    fun create(task: Task)
}