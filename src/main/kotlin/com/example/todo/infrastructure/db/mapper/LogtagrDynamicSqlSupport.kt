/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.todo.infrastructure.db.mapper

import java.sql.JDBCType
import org.mybatis.dynamic.sql.SqlTable

object LogtagrDynamicSqlSupport {
    object Logtagr : SqlTable("logtagR") {
        val logtagrid = column<Int>("logtagRId", JDBCType.INTEGER)

        val logid = column<Int>("logId", JDBCType.INTEGER)

        val logtagid = column<Int>("logtagId", JDBCType.INTEGER)
    }
}