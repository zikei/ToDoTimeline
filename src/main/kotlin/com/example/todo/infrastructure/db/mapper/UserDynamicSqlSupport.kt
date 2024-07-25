/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.todo.infrastructure.db.mapper

import com.example.todo.domain.enums.Role
import org.mybatis.dynamic.sql.AliasableSqlTable
import org.mybatis.dynamic.sql.util.kotlin.elements.column
import java.sql.JDBCType

object UserDynamicSqlSupport {
    val user = User()

    val userid = user.userid

    val username = user.username

    val dspname = user.dspname

    val password = user.password

    val role = user.role

    class User : AliasableSqlTable<User>("user", ::User) {
        val userid = column<Int>(name = "userId", jdbcType = JDBCType.INTEGER)

        val username = column<String>(name = "userName", jdbcType = JDBCType.VARCHAR)

        val dspname = column<String>(name = "dspName", jdbcType = JDBCType.VARCHAR)

        val password = column<String>(name = "password", jdbcType = JDBCType.VARCHAR)

        val role = column<Role>(name = "role", jdbcType = JDBCType.CHAR, typeHandler = "org.apache.ibatis.type.EnumTypeHandler")
    }
}