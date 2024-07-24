/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.todo.infrastructure.db.mapper

import org.mybatis.dynamic.sql.AliasableSqlTable
import org.mybatis.dynamic.sql.util.kotlin.elements.column
import java.sql.JDBCType

object LogtagrDynamicSqlSupport {
    val logtagr = Logtagr()

    val logtagrid = logtagr.logtagrid

    val logid = logtagr.logid

    val logtagid = logtagr.logtagid

    class Logtagr : AliasableSqlTable<Logtagr>("logtagR", ::Logtagr) {
        val logtagrid = column<Int>(name = "logtagRId", jdbcType = JDBCType.INTEGER)

        val logid = column<Int>(name = "logId", jdbcType = JDBCType.INTEGER)

        val logtagid = column<Int>(name = "logtagId", jdbcType = JDBCType.INTEGER)
    }
}