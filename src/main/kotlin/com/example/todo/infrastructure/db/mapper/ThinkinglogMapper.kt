/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.todo.infrastructure.db.mapper

import com.example.todo.infrastructure.db.mapper.ThinkinglogDynamicSqlSupport.contents
import com.example.todo.infrastructure.db.mapper.ThinkinglogDynamicSqlSupport.createdate
import com.example.todo.infrastructure.db.mapper.ThinkinglogDynamicSqlSupport.logid
import com.example.todo.infrastructure.db.mapper.ThinkinglogDynamicSqlSupport.taskid
import com.example.todo.infrastructure.db.mapper.ThinkinglogDynamicSqlSupport.thinkinglog
import com.example.todo.infrastructure.db.mapper.ThinkinglogDynamicSqlSupport.userid
import com.example.todo.infrastructure.db.record.Thinkinglog
import org.apache.ibatis.annotations.*
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
interface ThinkinglogMapper : CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<Thinkinglog>, CommonUpdateMapper {
    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @Results(id="ThinkinglogResult", value = [
        Result(column="logId", property="logid", jdbcType=JdbcType.INTEGER, id=true),
        Result(column="taskId", property="taskid", jdbcType=JdbcType.INTEGER),
        Result(column="userId", property="userid", jdbcType=JdbcType.INTEGER),
        Result(column="createDate", property="createdate", jdbcType=JdbcType.TIMESTAMP),
        Result(column="contents", property="contents", jdbcType=JdbcType.VARCHAR)
    ])
    fun selectMany(selectStatement: SelectStatementProvider): List<Thinkinglog>

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @ResultMap("ThinkinglogResult")
    fun selectOne(selectStatement: SelectStatementProvider): Thinkinglog?
}

fun ThinkinglogMapper.count(completer: CountCompleter) =
    countFrom(this::count, thinkinglog, completer)

fun ThinkinglogMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, thinkinglog, completer)

fun ThinkinglogMapper.deleteByPrimaryKey(logid_: Int) =
    delete {
        where { logid isEqualTo logid_ }
    }

fun ThinkinglogMapper.insert(row: Thinkinglog) =
    insert(this::insert, row, thinkinglog) {
        map(logid) toProperty "logid"
        map(taskid) toProperty "taskid"
        map(userid) toProperty "userid"
        map(createdate) toProperty "createdate"
        map(contents) toProperty "contents"
    }

fun ThinkinglogMapper.insertMultiple(records: Collection<Thinkinglog>) =
    insertMultiple(this::insertMultiple, records, thinkinglog) {
        map(logid) toProperty "logid"
        map(taskid) toProperty "taskid"
        map(userid) toProperty "userid"
        map(createdate) toProperty "createdate"
        map(contents) toProperty "contents"
    }

fun ThinkinglogMapper.insertMultiple(vararg records: Thinkinglog) =
    insertMultiple(records.toList())

fun ThinkinglogMapper.insertSelective(row: Thinkinglog) =
    insert(this::insert, row, thinkinglog) {
        map(logid).toPropertyWhenPresent("logid", row::logid)
        map(taskid).toPropertyWhenPresent("taskid", row::taskid)
        map(userid).toPropertyWhenPresent("userid", row::userid)
        map(createdate).toPropertyWhenPresent("createdate", row::createdate)
        map(contents).toPropertyWhenPresent("contents", row::contents)
    }

private val columnList = listOf(logid, taskid, userid, createdate, contents)

fun ThinkinglogMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, thinkinglog, completer)

fun ThinkinglogMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, thinkinglog, completer)

fun ThinkinglogMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, thinkinglog, completer)

fun ThinkinglogMapper.selectByPrimaryKey(logid_: Int) =
    selectOne {
        where { logid isEqualTo logid_ }
    }

fun ThinkinglogMapper.update(completer: UpdateCompleter) =
    update(this::update, thinkinglog, completer)

fun KotlinUpdateBuilder.updateAllColumns(row: Thinkinglog) =
    apply {
        set(logid) equalToOrNull row::logid
        set(taskid) equalToOrNull row::taskid
        set(userid) equalToOrNull row::userid
        set(createdate) equalToOrNull row::createdate
        set(contents) equalToOrNull row::contents
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(row: Thinkinglog) =
    apply {
        set(logid) equalToWhenPresent row::logid
        set(taskid) equalToWhenPresent row::taskid
        set(userid) equalToWhenPresent row::userid
        set(createdate) equalToWhenPresent row::createdate
        set(contents) equalToWhenPresent row::contents
    }

fun ThinkinglogMapper.updateByPrimaryKey(row: Thinkinglog) =
    update {
        set(taskid) equalToOrNull row::taskid
        set(userid) equalToOrNull row::userid
        set(createdate) equalToOrNull row::createdate
        set(contents) equalToOrNull row::contents
        where { logid isEqualTo row.logid!! }
    }

fun ThinkinglogMapper.updateByPrimaryKeySelective(row: Thinkinglog) =
    update {
        set(taskid) equalToWhenPresent row::taskid
        set(userid) equalToWhenPresent row::userid
        set(createdate) equalToWhenPresent row::createdate
        set(contents) equalToWhenPresent row::contents
        where { logid isEqualTo row.logid!! }
    }