/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.todo.infrastructure.db.mapper

import com.example.todo.domain.enums.Role
import java.sql.JDBCType
import org.mybatis.dynamic.sql.SqlTable

object UserDynamicSqlSupport {
    object User : SqlTable("user") {
        val userid = column<Int>("userId", JDBCType.INTEGER)

        val username = column<String>("userName", JDBCType.VARCHAR)

        val dspname = column<String>("dspName", JDBCType.VARCHAR)

        val password = column<String>("password", JDBCType.VARCHAR)

        val role = column<Role>("role", JDBCType.CHAR, "org.apache.ibatis.type.EnumTypeHandler")
    }
}