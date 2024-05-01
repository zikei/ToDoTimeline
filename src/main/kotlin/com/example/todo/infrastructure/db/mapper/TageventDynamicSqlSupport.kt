/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.todo.infrastructure.db.mapper

import java.sql.JDBCType
import org.mybatis.dynamic.sql.SqlTable

object TageventDynamicSqlSupport {
    object Tagevent : SqlTable("tagEvent") {
        val tageventid = column<Int>("tagEventId", JDBCType.INTEGER)

        val eventname = column<String>("eventName", JDBCType.VARCHAR)

        val eventoutline = column<String>("eventOutline", JDBCType.VARCHAR)
    }
}