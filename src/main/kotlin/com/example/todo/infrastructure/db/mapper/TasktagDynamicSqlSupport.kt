/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.todo.infrastructure.db.mapper

import org.mybatis.dynamic.sql.AliasableSqlTable
import org.mybatis.dynamic.sql.util.kotlin.elements.column
import java.sql.JDBCType

object TasktagDynamicSqlSupport {
    val tasktag = Tasktag()

    val tasktagid = tasktag.tasktagid

    val tagname = tasktag.tagname

    val userid = tasktag.userid

    class Tasktag : AliasableSqlTable<Tasktag>("tasktag", ::Tasktag) {
        val tasktagid = column<Int>(name = "tasktagId", jdbcType = JDBCType.INTEGER)

        val tagname = column<String>(name = "tagName", jdbcType = JDBCType.VARCHAR)

        val userid = column<Int>(name = "userId", jdbcType = JDBCType.INTEGER)
    }
}