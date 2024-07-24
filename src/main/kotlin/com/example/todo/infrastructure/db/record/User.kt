/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.todo.infrastructure.db.record

import com.example.todo.domain.enums.Role

data class User(
    var userid: Int? = null,
    var username: String? = null,
    var dspname: String? = null,
    var password: String? = null,
    var role: Role? = null
)