/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.todo.infrastructure.db.mapper

import java.sql.JDBCType
import org.mybatis.dynamic.sql.SqlTable

object TasktagDynamicSqlSupport {
    object Tasktag : SqlTable("tasktag") {
        val tasktagid = column<Int>("tasktagId", JDBCType.INTEGER)

        val tagname = column<String>("tagName", JDBCType.VARCHAR)

        val userid = column<Int>("userId", JDBCType.INTEGER)
    }
}