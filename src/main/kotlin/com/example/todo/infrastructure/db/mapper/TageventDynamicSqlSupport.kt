/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.todo.infrastructure.db.mapper

import org.mybatis.dynamic.sql.AliasableSqlTable
import org.mybatis.dynamic.sql.util.kotlin.elements.column
import java.sql.JDBCType

object TageventDynamicSqlSupport {
    val tagevent = Tagevent()

    val tageventid = tagevent.tageventid

    val eventname = tagevent.eventname

    val eventoutline = tagevent.eventoutline

    class Tagevent : AliasableSqlTable<Tagevent>("tagEvent", ::Tagevent) {
        val tageventid = column<Int>(name = "tagEventId", jdbcType = JDBCType.INTEGER)

        val eventname = column<String>(name = "eventName", jdbcType = JDBCType.VARCHAR)

        val eventoutline = column<String>(name = "eventOutline", jdbcType = JDBCType.VARCHAR)
    }
}