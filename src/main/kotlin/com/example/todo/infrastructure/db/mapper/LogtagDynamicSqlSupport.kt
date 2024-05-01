/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.todo.infrastructure.db.mapper

import java.sql.JDBCType
import org.mybatis.dynamic.sql.SqlTable

object LogtagDynamicSqlSupport {
    object Logtag : SqlTable("logtag") {
        val logtagid = column<Int>("logtagId", JDBCType.INTEGER)

        val tagname = column<String>("tagName", JDBCType.VARCHAR)

        val userid = column<Int>("userId", JDBCType.INTEGER)

        val tageventid = column<Int>("tagEventId", JDBCType.INTEGER)
    }
}