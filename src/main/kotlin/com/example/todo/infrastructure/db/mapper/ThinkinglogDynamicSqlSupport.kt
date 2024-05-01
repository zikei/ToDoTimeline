/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.todo.infrastructure.db.mapper

import java.sql.JDBCType
import java.time.LocalDateTime
import org.mybatis.dynamic.sql.SqlTable

object ThinkinglogDynamicSqlSupport {
    object Thinkinglog : SqlTable("thinkingLog") {
        val logid = column<Int>("logId", JDBCType.INTEGER)

        val taskid = column<Int>("taskId", JDBCType.INTEGER)

        val userid = column<Int>("userId", JDBCType.INTEGER)

        val createdate = column<LocalDateTime>("createDate", JDBCType.TIMESTAMP)

        val contents = column<String>("contents", JDBCType.VARCHAR)
    }
}