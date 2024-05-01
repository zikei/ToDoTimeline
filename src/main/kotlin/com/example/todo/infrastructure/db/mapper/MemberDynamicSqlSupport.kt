/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.todo.infrastructure.db.mapper

import com.example.todo.domain.enums.MenStatus
import java.sql.JDBCType
import org.mybatis.dynamic.sql.SqlTable

object MemberDynamicSqlSupport {
    object Member : SqlTable("member") {
        val menid = column<Int>("menId", JDBCType.INTEGER)

        val taskid = column<Int>("taskId", JDBCType.INTEGER)

        val userid = column<Int>("userId", JDBCType.INTEGER)

        val menstatus = column<MenStatus>("menStatus", JDBCType.CHAR, "org.apache.ibatis.type.EnumTypeHandler")
    }
}