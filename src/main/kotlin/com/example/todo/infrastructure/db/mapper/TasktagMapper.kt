/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.todo.infrastructure.db.mapper

import com.example.todo.infrastructure.db.mapper.TasktagDynamicSqlSupport.tagname
import com.example.todo.infrastructure.db.mapper.TasktagDynamicSqlSupport.tasktag
import com.example.todo.infrastructure.db.mapper.TasktagDynamicSqlSupport.tasktagid
import com.example.todo.infrastructure.db.mapper.TasktagDynamicSqlSupport.userid
import com.example.todo.infrastructure.db.record.Tasktag
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
interface TasktagMapper : CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<Tasktag>, CommonUpdateMapper {
    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @Results(id="TasktagResult", value = [
        Result(column="tasktagId", property="tasktagid", jdbcType=JdbcType.INTEGER, id=true),
        Result(column="tagName", property="tagname", jdbcType=JdbcType.VARCHAR),
        Result(column="userId", property="userid", jdbcType=JdbcType.INTEGER)
    ])
    fun selectMany(selectStatement: SelectStatementProvider): List<Tasktag>

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @ResultMap("TasktagResult")
    fun selectOne(selectStatement: SelectStatementProvider): Tasktag?
}

fun TasktagMapper.count(completer: CountCompleter) =
    countFrom(this::count, tasktag, completer)

fun TasktagMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, tasktag, completer)

fun TasktagMapper.deleteByPrimaryKey(tasktagid_: Int) =
    delete {
        where { tasktagid isEqualTo tasktagid_ }
    }

fun TasktagMapper.insert(row: Tasktag) =
    insert(this::insert, row, tasktag) {
        map(tasktagid) toProperty "tasktagid"
        map(tagname) toProperty "tagname"
        map(userid) toProperty "userid"
    }

fun TasktagMapper.insertMultiple(records: Collection<Tasktag>) =
    insertMultiple(this::insertMultiple, records, tasktag) {
        map(tasktagid) toProperty "tasktagid"
        map(tagname) toProperty "tagname"
        map(userid) toProperty "userid"
    }

fun TasktagMapper.insertMultiple(vararg records: Tasktag) =
    insertMultiple(records.toList())

fun TasktagMapper.insertSelective(row: Tasktag) =
    insert(this::insert, row, tasktag) {
        map(tasktagid).toPropertyWhenPresent("tasktagid", row::tasktagid)
        map(tagname).toPropertyWhenPresent("tagname", row::tagname)
        map(userid).toPropertyWhenPresent("userid", row::userid)
    }

private val columnList = listOf(tasktagid, tagname, userid)

fun TasktagMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, tasktag, completer)

fun TasktagMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, tasktag, completer)

fun TasktagMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, tasktag, completer)

fun TasktagMapper.selectByPrimaryKey(tasktagid_: Int) =
    selectOne {
        where { tasktagid isEqualTo tasktagid_ }
    }

fun TasktagMapper.update(completer: UpdateCompleter) =
    update(this::update, tasktag, completer)

fun KotlinUpdateBuilder.updateAllColumns(row: Tasktag) =
    apply {
        set(tasktagid) equalToOrNull row::tasktagid
        set(tagname) equalToOrNull row::tagname
        set(userid) equalToOrNull row::userid
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(row: Tasktag) =
    apply {
        set(tasktagid) equalToWhenPresent row::tasktagid
        set(tagname) equalToWhenPresent row::tagname
        set(userid) equalToWhenPresent row::userid
    }

fun TasktagMapper.updateByPrimaryKey(row: Tasktag) =
    update {
        set(tagname) equalToOrNull row::tagname
        set(userid) equalToOrNull row::userid
        where { tasktagid isEqualTo row.tasktagid!! }
    }

fun TasktagMapper.updateByPrimaryKeySelective(row: Tasktag) =
    update {
        set(tagname) equalToWhenPresent row::tagname
        set(userid) equalToWhenPresent row::userid
        where { tasktagid isEqualTo row.tasktagid!! }
    }