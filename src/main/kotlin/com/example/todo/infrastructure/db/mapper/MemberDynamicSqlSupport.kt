/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.todo.infrastructure.db.mapper

import com.example.todo.domain.enums.MenStatus
import org.mybatis.dynamic.sql.AliasableSqlTable
import org.mybatis.dynamic.sql.util.kotlin.elements.column
import java.sql.JDBCType

object MemberDynamicSqlSupport {
    val member = Member()

    val menid = member.menid

    val taskid = member.taskid

    val userid = member.userid

    val menstatus = member.menstatus

    class Member : AliasableSqlTable<Member>("member", ::Member) {
        val menid = column<Int>(name = "menId", jdbcType = JDBCType.INTEGER)

        val taskid = column<Int>(name = "taskId", jdbcType = JDBCType.INTEGER)

        val userid = column<Int>(name = "userId", jdbcType = JDBCType.INTEGER)

        val menstatus = column<MenStatus>(name = "menStatus", jdbcType = JDBCType.CHAR, typeHandler = "org.apache.ibatis.type.EnumTypeHandler")
    }
}