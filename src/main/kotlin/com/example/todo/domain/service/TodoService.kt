package com.example.todo.domain.service

import com.example.todo.domain.model.Todo

/** ToDo関連処理クラス */
interface TodoService {
    /** ToDo一覧の取得 */
    fun getList(userId: Int) : List<Todo>
}