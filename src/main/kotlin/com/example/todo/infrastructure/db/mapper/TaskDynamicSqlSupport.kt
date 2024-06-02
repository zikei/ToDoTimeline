/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.todo.infrastructure.db.mapper

import com.example.todo.domain.enums.Severity
import com.example.todo.domain.enums.TaskStatus
import java.sql.JDBCType
import java.time.LocalDate
import org.mybatis.dynamic.sql.SqlTable

object TaskDynamicSqlSupport {
    object Task : SqlTable("task") {
        val taskid = column<Int>("taskId", JDBCType.INTEGER)

        val userid = column<Int>("userId", JDBCType.INTEGER)

        val taskname = column<String>("taskName", JDBCType.VARCHAR)

        val memo = column<String>("memo", JDBCType.VARCHAR)

        val createdate = column<LocalDate>("createDate", JDBCType.DATE)

        val severity = column<Severity>("severity", JDBCType.CHAR, "org.apache.ibatis.type.EnumTypeHandler")

        val deadline = column<LocalDate>("deadline", JDBCType.DATE)

        val taskstatus = column<TaskStatus>("taskStatus", JDBCType.CHAR, "org.apache.ibatis.type.EnumTypeHandler")

        val parentid = column<Int>("parentId", JDBCType.INTEGER)
    }
}