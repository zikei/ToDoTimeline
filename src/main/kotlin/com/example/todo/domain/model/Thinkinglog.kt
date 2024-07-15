package com.example.todo.domain.model

import java.time.LocalDateTime

/** 思考ログエンティティ */
data class Thinkinglog(
    val logid: Int?,
    val taskid: Int?,
    val userid: Int,
    val createdate: LocalDateTime,
    val contents: String
)
