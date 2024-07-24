/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.todo.infrastructure.db.mapper

import com.example.todo.infrastructure.db.mapper.UserDynamicSqlSupport.dspname
import com.example.todo.infrastructure.db.mapper.UserDynamicSqlSupport.password
import com.example.todo.infrastructure.db.mapper.UserDynamicSqlSupport.role
import com.example.todo.infrastructure.db.mapper.UserDynamicSqlSupport.user
import com.example.todo.infrastructure.db.mapper.UserDynamicSqlSupport.userid
import com.example.todo.infrastructure.db.mapper.UserDynamicSqlSupport.username
import com.example.todo.infrastructure.db.record.User
import org.apache.ibatis.annotations.*
import org.apache.ibatis.type.EnumTypeHandler
import org.apache.ibatis.type.JdbcType
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
import org.mybatis.dynamic.sql.util.SqlProviderAdapter
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper

@Mapper
interface UserMapper : CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<User>, CommonUpdateMapper {
    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @Results(id="UserResult", value = [
        Result(column="userId", property="userid", jdbcType=JdbcType.INTEGER, id=true),
        Result(column="userName", property="username", jdbcType=JdbcType.VARCHAR),
        Result(column="dspName", property="dspname", jdbcType=JdbcType.VARCHAR),
        Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        Result(column="role", property="role", typeHandler=EnumTypeHandler::class, jdbcType=JdbcType.CHAR)
    ])
    fun selectMany(selectStatement: SelectStatementProvider): List<User>

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @ResultMap("UserResult")
    fun selectOne(selectStatement: SelectStatementProvider): User?
}

fun UserMapper.count(completer: CountCompleter) =
    countFrom(this::count, user, completer)

fun UserMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, user, completer)

fun UserMapper.deleteByPrimaryKey(userid_: Int) =
    delete {
        where { userid isEqualTo userid_ }
    }

fun UserMapper.insert(row: User) =
    insert(this::insert, row, user) {
        map(userid) toProperty "userid"
        map(username) toProperty "username"
        map(dspname) toProperty "dspname"
        map(password) toProperty "password"
        map(role) toProperty "role"
    }

fun UserMapper.insertMultiple(records: Collection<User>) =
    insertMultiple(this::insertMultiple, records, user) {
        map(userid) toProperty "userid"
        map(username) toProperty "username"
        map(dspname) toProperty "dspname"
        map(password) toProperty "password"
        map(role) toProperty "role"
    }

fun UserMapper.insertMultiple(vararg records: User) =
    insertMultiple(records.toList())

fun UserMapper.insertSelective(row: User) =
    insert(this::insert, row, user) {
        map(userid).toPropertyWhenPresent("userid", row::userid)
        map(username).toPropertyWhenPresent("username", row::username)
        map(dspname).toPropertyWhenPresent("dspname", row::dspname)
        map(password).toPropertyWhenPresent("password", row::password)
        map(role).toPropertyWhenPresent("role", row::role)
    }

private val columnList = listOf(userid, username, dspname, password, role)

fun UserMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, user, completer)

fun UserMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, user, completer)

fun UserMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, user, completer)

fun UserMapper.selectByPrimaryKey(userid_: Int) =
    selectOne {
        where { userid isEqualTo userid_ }
    }

fun UserMapper.update(completer: UpdateCompleter) =
    update(this::update, user, completer)

fun KotlinUpdateBuilder.updateAllColumns(row: User) =
    apply {
        set(userid) equalToOrNull row::userid
        set(username) equalToOrNull row::username
        set(dspname) equalToOrNull row::dspname
        set(password) equalToOrNull row::password
        set(role) equalToOrNull row::role
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(row: User) =
    apply {
        set(userid) equalToWhenPresent row::userid
        set(username) equalToWhenPresent row::username
        set(dspname) equalToWhenPresent row::dspname
        set(password) equalToWhenPresent row::password
        set(role) equalToWhenPresent row::role
    }

fun UserMapper.updateByPrimaryKey(row: User) =
    update {
        set(username) equalToOrNull row::username
        set(dspname) equalToOrNull row::dspname
        set(password) equalToOrNull row::password
        set(role) equalToOrNull row::role
        where { userid isEqualTo row.userid!! }
    }

fun UserMapper.updateByPrimaryKeySelective(row: User) =
    update {
        set(username) equalToWhenPresent row::username
        set(dspname) equalToWhenPresent row::dspname
        set(password) equalToWhenPresent row::password
        set(role) equalToWhenPresent row::role
        where { userid isEqualTo row.userid!! }
    }