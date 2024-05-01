/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.todo.infrastructure.db.mapper

import com.example.todo.infrastructure.db.mapper.ThinkinglogDynamicSqlSupport.Thinkinglog
import com.example.todo.infrastructure.db.mapper.ThinkinglogDynamicSqlSupport.Thinkinglog.contents
import com.example.todo.infrastructure.db.mapper.ThinkinglogDynamicSqlSupport.Thinkinglog.createdate
import com.example.todo.infrastructure.db.mapper.ThinkinglogDynamicSqlSupport.Thinkinglog.logid
import com.example.todo.infrastructure.db.mapper.ThinkinglogDynamicSqlSupport.Thinkinglog.taskid
import com.example.todo.infrastructure.db.mapper.ThinkinglogDynamicSqlSupport.Thinkinglog.userid
import com.example.todo.infrastructure.db.record.ThinkinglogRecord
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun ThinkinglogMapper.count(completer: CountCompleter) =
    countFrom(this::count, Thinkinglog, completer)

fun ThinkinglogMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, Thinkinglog, completer)

fun ThinkinglogMapper.deleteByPrimaryKey(logid_: Int) =
    delete {
        where(logid, isEqualTo(logid_))
    }

fun ThinkinglogMapper.insert(record: ThinkinglogRecord) =
    insert(this::insert, record, Thinkinglog) {
        map(logid).toProperty("logid")
        map(taskid).toProperty("taskid")
        map(userid).toProperty("userid")
        map(createdate).toProperty("createdate")
        map(contents).toProperty("contents")
    }

fun ThinkinglogMapper.insertMultiple(records: Collection<ThinkinglogRecord>) =
    insertMultiple(this::insertMultiple, records, Thinkinglog) {
        map(logid).toProperty("logid")
        map(taskid).toProperty("taskid")
        map(userid).toProperty("userid")
        map(createdate).toProperty("createdate")
        map(contents).toProperty("contents")
    }

fun ThinkinglogMapper.insertMultiple(vararg records: ThinkinglogRecord) =
    insertMultiple(records.toList())

fun ThinkinglogMapper.insertSelective(record: ThinkinglogRecord) =
    insert(this::insert, record, Thinkinglog) {
        map(logid).toPropertyWhenPresent("logid", record::logid)
        map(taskid).toPropertyWhenPresent("taskid", record::taskid)
        map(userid).toPropertyWhenPresent("userid", record::userid)
        map(createdate).toPropertyWhenPresent("createdate", record::createdate)
        map(contents).toPropertyWhenPresent("contents", record::contents)
    }

private val columnList = listOf(logid, taskid, userid, createdate, contents)

fun ThinkinglogMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, Thinkinglog, completer)

fun ThinkinglogMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, Thinkinglog, completer)

fun ThinkinglogMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, Thinkinglog, completer)

fun ThinkinglogMapper.selectByPrimaryKey(logid_: Int) =
    selectOne {
        where(logid, isEqualTo(logid_))
    }

fun ThinkinglogMapper.update(completer: UpdateCompleter) =
    update(this::update, Thinkinglog, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: ThinkinglogRecord) =
    apply {
        set(logid).equalTo(record::logid)
        set(taskid).equalTo(record::taskid)
        set(userid).equalTo(record::userid)
        set(createdate).equalTo(record::createdate)
        set(contents).equalTo(record::contents)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: ThinkinglogRecord) =
    apply {
        set(logid).equalToWhenPresent(record::logid)
        set(taskid).equalToWhenPresent(record::taskid)
        set(userid).equalToWhenPresent(record::userid)
        set(createdate).equalToWhenPresent(record::createdate)
        set(contents).equalToWhenPresent(record::contents)
    }

fun ThinkinglogMapper.updateByPrimaryKey(record: ThinkinglogRecord) =
    update {
        set(taskid).equalTo(record::taskid)
        set(userid).equalTo(record::userid)
        set(createdate).equalTo(record::createdate)
        set(contents).equalTo(record::contents)
        where(logid, isEqualTo(record::logid))
    }

fun ThinkinglogMapper.updateByPrimaryKeySelective(record: ThinkinglogRecord) =
    update {
        set(taskid).equalToWhenPresent(record::taskid)
        set(userid).equalToWhenPresent(record::userid)
        set(createdate).equalToWhenPresent(record::createdate)
        set(contents).equalToWhenPresent(record::contents)
        where(logid, isEqualTo(record::logid))
    }