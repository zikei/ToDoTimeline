/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.todo.infrastructure.db.mapper

import com.example.todo.infrastructure.db.mapper.TasktagDynamicSqlSupport.Tasktag
import com.example.todo.infrastructure.db.mapper.TasktagDynamicSqlSupport.Tasktag.tagname
import com.example.todo.infrastructure.db.mapper.TasktagDynamicSqlSupport.Tasktag.tasktagid
import com.example.todo.infrastructure.db.mapper.TasktagDynamicSqlSupport.Tasktag.userid
import com.example.todo.infrastructure.db.record.TasktagRecord
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun TasktagMapper.count(completer: CountCompleter) =
    countFrom(this::count, Tasktag, completer)

fun TasktagMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, Tasktag, completer)

fun TasktagMapper.deleteByPrimaryKey(tasktagid_: Int) =
    delete {
        where(tasktagid, isEqualTo(tasktagid_))
    }

fun TasktagMapper.insert(record: TasktagRecord) =
    insert(this::insert, record, Tasktag) {
        map(tasktagid).toProperty("tasktagid")
        map(tagname).toProperty("tagname")
        map(userid).toProperty("userid")
    }

fun TasktagMapper.insertMultiple(records: Collection<TasktagRecord>) =
    insertMultiple(this::insertMultiple, records, Tasktag) {
        map(tasktagid).toProperty("tasktagid")
        map(tagname).toProperty("tagname")
        map(userid).toProperty("userid")
    }

fun TasktagMapper.insertMultiple(vararg records: TasktagRecord) =
    insertMultiple(records.toList())

fun TasktagMapper.insertSelective(record: TasktagRecord) =
    insert(this::insert, record, Tasktag) {
        map(tasktagid).toPropertyWhenPresent("tasktagid", record::tasktagid)
        map(tagname).toPropertyWhenPresent("tagname", record::tagname)
        map(userid).toPropertyWhenPresent("userid", record::userid)
    }

private val columnList = listOf(tasktagid, tagname, userid)

fun TasktagMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, Tasktag, completer)

fun TasktagMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, Tasktag, completer)

fun TasktagMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, Tasktag, completer)

fun TasktagMapper.selectByPrimaryKey(tasktagid_: Int) =
    selectOne {
        where(tasktagid, isEqualTo(tasktagid_))
    }

fun TasktagMapper.update(completer: UpdateCompleter) =
    update(this::update, Tasktag, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: TasktagRecord) =
    apply {
        set(tasktagid).equalTo(record::tasktagid)
        set(tagname).equalTo(record::tagname)
        set(userid).equalTo(record::userid)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: TasktagRecord) =
    apply {
        set(tasktagid).equalToWhenPresent(record::tasktagid)
        set(tagname).equalToWhenPresent(record::tagname)
        set(userid).equalToWhenPresent(record::userid)
    }

fun TasktagMapper.updateByPrimaryKey(record: TasktagRecord) =
    update {
        set(tagname).equalTo(record::tagname)
        set(userid).equalTo(record::userid)
        where(tasktagid, isEqualTo(record::tasktagid))
    }

fun TasktagMapper.updateByPrimaryKeySelective(record: TasktagRecord) =
    update {
        set(tagname).equalToWhenPresent(record::tagname)
        set(userid).equalToWhenPresent(record::userid)
        where(tasktagid, isEqualTo(record::tasktagid))
    }