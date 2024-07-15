package com.example.todo.domain.repository

import com.example.todo.domain.model.User


interface UserRepository {
    fun findById(id: Int): User?
    fun findByUserName(name: String): User?

    /** Todoにアクセス可能なユーザを取得 */
    fun findByTaskId(taskId: Int): List<User>
}