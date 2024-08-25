/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.todo.infrastructure.db.mapper

import org.mybatis.dynamic.sql.AliasableSqlTable
import org.mybatis.dynamic.sql.util.kotlin.elements.column
import java.sql.JDBCType
import java.time.LocalDateTime

object ThinkinglogDynamicSqlSupport {
    val thinkinglog = Thinkinglog()

    val logid = thinkinglog.logid

    val taskid = thinkinglog.taskid

    val userid = thinkinglog.userid

    val createdate = thinkinglog.createdate

    val contents = thinkinglog.contents

    class Thinkinglog : AliasableSqlTable<Thinkinglog>("thinkingLog", ::Thinkinglog) {
        val logid = column<Int>(name = "logId", jdbcType = JDBCType.INTEGER)

        val taskid = column<Int>(name = "taskId", jdbcType = JDBCType.INTEGER)

        val userid = column<Int>(name = "userId", jdbcType = JDBCType.INTEGER)

        val createdate = column<LocalDateTime>(name = "createDate", jdbcType = JDBCType.TIMESTAMP)

        val contents = column<String>(name = "contents", jdbcType = JDBCType.VARCHAR)
    }
}