/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.todo.infrastructure.db.mapper

import java.sql.JDBCType
import java.time.LocalDateTime
import org.mybatis.dynamic.sql.SqlTable

object NewsDynamicSqlSupport {
    object News : SqlTable("news") {
        val newsid = column<Int>("newsId", JDBCType.INTEGER)

        val contents = column<String>("contents", JDBCType.VARCHAR)

        val createdate = column<LocalDateTime>("createDate", JDBCType.TIMESTAMP)
    }
}