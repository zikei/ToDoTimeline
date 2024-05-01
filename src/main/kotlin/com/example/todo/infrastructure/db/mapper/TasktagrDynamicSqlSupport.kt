/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.todo.infrastructure.db.mapper

import java.sql.JDBCType
import org.mybatis.dynamic.sql.SqlTable

object TasktagrDynamicSqlSupport {
    object Tasktagr : SqlTable("tasktagR") {
        val tasktagrid = column<Int>("tasktagRId", JDBCType.INTEGER)

        val taskid = column<Int>("taskId", JDBCType.INTEGER)

        val tasktagid = column<Int>("tasktagId", JDBCType.INTEGER)
    }
}