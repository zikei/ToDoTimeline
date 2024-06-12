package com.example.todo.domain.service

import com.example.todo.domain.enums.TaskStatus
import com.example.todo.domain.model.Task
import com.example.todo.domain.model.Todo

/** ToDo関連処理クラス */
interface TodoService {
    /** ToDo一覧の取得 */
    fun getList(userId: Int): List<Todo>

    /** Todoの取得 */
    fun getTodo(taskId: Int): Todo?

    /**
     * Todoの登録
     * @return 登録ID
     */
    fun create(task: Task): Int

    /** タスク状態の更新 */
    fun updTaskStatus(taskId: Int, taskStatus: TaskStatus)
}