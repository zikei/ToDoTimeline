package com.example.todo.domain.model

import com.example.todo.domain.enums.Role
import java.time.LocalDateTime

/** タイムラインエンティティ */
data class Timeline(
    var logid: Int?,
    var taskid: Int?,
    var userid: Int,
    var role: Role,
    var createdate: LocalDateTime,
    var contents: String,
    var taskname: String?,
    var dspname:String
)