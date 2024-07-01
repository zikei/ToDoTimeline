package com.example.todo.domain.service

import com.example.todo.domain.enums.TaskStatus
import com.example.todo.domain.model.Task
import com.example.todo.domain.model.Todo
import com.example.todo.domain.model.User

/** ToDo関連処理クラス */
interface TodoService {
    /** ToDo一覧の取得 */
    fun getList(userId: Int): List<Todo>

    /** Todoの取得 */
    fun getTodo(taskId: Int): Todo?

    /**
     * Todoを取得しユーザの確認を行い返却
     * todoが見つからない・ユーザーが違う場合 : null
     */
    fun getTodo(taskId: Int, user: User): Todo?

    /**
     * Todoの登録
     * @return 登録ID
     */
    fun create(task: Task): Int

    /** タスク状態の更新 */
    fun updTaskStatus(taskId: Int, taskStatus: TaskStatus)
}