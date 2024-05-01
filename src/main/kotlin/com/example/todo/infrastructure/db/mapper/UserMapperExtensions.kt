/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.todo.infrastructure.db.mapper

import com.example.todo.infrastructure.db.mapper.UserDynamicSqlSupport.User
import com.example.todo.infrastructure.db.mapper.UserDynamicSqlSupport.User.dspname
import com.example.todo.infrastructure.db.mapper.UserDynamicSqlSupport.User.password
import com.example.todo.infrastructure.db.mapper.UserDynamicSqlSupport.User.role
import com.example.todo.infrastructure.db.mapper.UserDynamicSqlSupport.User.userid
import com.example.todo.infrastructure.db.mapper.UserDynamicSqlSupport.User.username
import com.example.todo.infrastructure.db.record.UserRecord
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun UserMapper.count(completer: CountCompleter) =
    countFrom(this::count, User, completer)

fun UserMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, User, completer)

fun UserMapper.deleteByPrimaryKey(userid_: Int) =
    delete {
        where(userid, isEqualTo(userid_))
    }

fun UserMapper.insert(record: UserRecord) =
    insert(this::insert, record, User) {
        map(userid).toProperty("userid")
        map(username).toProperty("username")
        map(dspname).toProperty("dspname")
        map(password).toProperty("password")
        map(role).toProperty("role")
    }

fun UserMapper.insertMultiple(records: Collection<UserRecord>) =
    insertMultiple(this::insertMultiple, records, User) {
        map(userid).toProperty("userid")
        map(username).toProperty("username")
        map(dspname).toProperty("dspname")
        map(password).toProperty("password")
        map(role).toProperty("role")
    }

fun UserMapper.insertMultiple(vararg records: UserRecord) =
    insertMultiple(records.toList())

fun UserMapper.insertSelective(record: UserRecord) =
    insert(this::insert, record, User) {
        map(userid).toPropertyWhenPresent("userid", record::userid)
        map(username).toPropertyWhenPresent("username", record::username)
        map(dspname).toPropertyWhenPresent("dspname", record::dspname)
        map(password).toPropertyWhenPresent("password", record::password)
        map(role).toPropertyWhenPresent("role", record::role)
    }

private val columnList = listOf(userid, username, dspname, password, role)

fun UserMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, User, completer)

fun UserMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, User, completer)

fun UserMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, User, completer)

fun UserMapper.selectByPrimaryKey(userid_: Int) =
    selectOne {
        where(userid, isEqualTo(userid_))
    }

fun UserMapper.update(completer: UpdateCompleter) =
    update(this::update, User, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: UserRecord) =
    apply {
        set(userid).equalTo(record::userid)
        set(username).equalTo(record::username)
        set(dspname).equalTo(record::dspname)
        set(password).equalTo(record::password)
        set(role).equalTo(record::role)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: UserRecord) =
    apply {
        set(userid).equalToWhenPresent(record::userid)
        set(username).equalToWhenPresent(record::username)
        set(dspname).equalToWhenPresent(record::dspname)
        set(password).equalToWhenPresent(record::password)
        set(role).equalToWhenPresent(record::role)
    }

fun UserMapper.updateByPrimaryKey(record: UserRecord) =
    update {
        set(username).equalTo(record::username)
        set(dspname).equalTo(record::dspname)
        set(password).equalTo(record::password)
        set(role).equalTo(record::role)
        where(userid, isEqualTo(record::userid))
    }

fun UserMapper.updateByPrimaryKeySelective(record: UserRecord) =
    update {
        set(username).equalToWhenPresent(record::username)
        set(dspname).equalToWhenPresent(record::dspname)
        set(password).equalToWhenPresent(record::password)
        set(role).equalToWhenPresent(record::role)
        where(userid, isEqualTo(record::userid))
    }