/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.todo.infrastructure.db.mapper

import org.mybatis.dynamic.sql.AliasableSqlTable
import org.mybatis.dynamic.sql.util.kotlin.elements.column
import java.sql.JDBCType

object TasktagrDynamicSqlSupport {
    val tasktagr = Tasktagr()

    val tasktagrid = tasktagr.tasktagrid

    val taskid = tasktagr.taskid

    val tasktagid = tasktagr.tasktagid

    class Tasktagr : AliasableSqlTable<Tasktagr>("tasktagR", ::Tasktagr) {
        val tasktagrid = column<Int>(name = "tasktagRId", jdbcType = JDBCType.INTEGER)

        val taskid = column<Int>(name = "taskId", jdbcType = JDBCType.INTEGER)

        val tasktagid = column<Int>(name = "tasktagId", jdbcType = JDBCType.INTEGER)
    }
}