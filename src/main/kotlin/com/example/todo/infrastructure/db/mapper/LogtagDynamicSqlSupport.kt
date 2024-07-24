/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.todo.infrastructure.db.mapper

import org.mybatis.dynamic.sql.AliasableSqlTable
import org.mybatis.dynamic.sql.util.kotlin.elements.column
import java.sql.JDBCType

object LogtagDynamicSqlSupport {
    val logtag = Logtag()

    val logtagid = logtag.logtagid

    val tagname = logtag.tagname

    val userid = logtag.userid

    val tageventid = logtag.tageventid

    class Logtag : AliasableSqlTable<Logtag>("logtag", ::Logtag) {
        val logtagid = column<Int>(name = "logtagId", jdbcType = JDBCType.INTEGER)

        val tagname = column<String>(name = "tagName", jdbcType = JDBCType.VARCHAR)

        val userid = column<Int>(name = "userId", jdbcType = JDBCType.INTEGER)

        val tageventid = column<Int>(name = "tagEventId", jdbcType = JDBCType.INTEGER)
    }
}