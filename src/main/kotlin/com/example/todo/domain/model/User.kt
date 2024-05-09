package com.example.todo.domain.model

import com.example.todo.domain.enums.Role

data class User(
    val userId: Int,
    val userName: String,
    val dspName: String,
    val password: String,
    val role: Role
)
