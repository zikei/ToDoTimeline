package com.example.todo.domain.repository

import com.example.todo.domain.model.User


interface UserRepository {
    fun findById(id: Int): User?
    fun findByUserName(name: String): User?
}