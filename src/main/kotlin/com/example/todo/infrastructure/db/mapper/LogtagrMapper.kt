/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.todo.infrastructure.db.mapper

import com.example.todo.infrastructure.db.mapper.LogtagrDynamicSqlSupport.logid
import com.example.todo.infrastructure.db.mapper.LogtagrDynamicSqlSupport.logtagid
import com.example.todo.infrastructure.db.mapper.LogtagrDynamicSqlSupport.logtagr
import com.example.todo.infrastructure.db.mapper.LogtagrDynamicSqlSupport.logtagrid
import com.example.todo.infrastructure.db.record.Logtagr
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
interface LogtagrMapper : CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<Logtagr>, CommonUpdateMapper {
    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @Results(id="LogtagrResult", value = [
        Result(column="logtagRId", property="logtagrid", jdbcType=JdbcType.INTEGER, id=true),
        Result(column="logId", property="logid", jdbcType=JdbcType.INTEGER),
        Result(column="logtagId", property="logtagid", jdbcType=JdbcType.INTEGER)
    ])
    fun selectMany(selectStatement: SelectStatementProvider): List<Logtagr>

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @ResultMap("LogtagrResult")
    fun selectOne(selectStatement: SelectStatementProvider): Logtagr?
}

fun LogtagrMapper.count(completer: CountCompleter) =
    countFrom(this::count, logtagr, completer)

fun LogtagrMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, logtagr, completer)

fun LogtagrMapper.deleteByPrimaryKey(logtagrid_: Int) =
    delete {
        where { logtagrid isEqualTo logtagrid_ }
    }

fun LogtagrMapper.insert(row: Logtagr) =
    insert(this::insert, row, logtagr) {
        map(logtagrid) toProperty "logtagrid"
        map(logid) toProperty "logid"
        map(logtagid) toProperty "logtagid"
    }

fun LogtagrMapper.insertMultiple(records: Collection<Logtagr>) =
    insertMultiple(this::insertMultiple, records, logtagr) {
        map(logtagrid) toProperty "logtagrid"
        map(logid) toProperty "logid"
        map(logtagid) toProperty "logtagid"
    }

fun LogtagrMapper.insertMultiple(vararg records: Logtagr) =
    insertMultiple(records.toList())

fun LogtagrMapper.insertSelective(row: Logtagr) =
    insert(this::insert, row, logtagr) {
        map(logtagrid).toPropertyWhenPresent("logtagrid", row::logtagrid)
        map(logid).toPropertyWhenPresent("logid", row::logid)
        map(logtagid).toPropertyWhenPresent("logtagid", row::logtagid)
    }

private val columnList = listOf(logtagrid, logid, logtagid)

fun LogtagrMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, logtagr, completer)

fun LogtagrMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, logtagr, completer)

fun LogtagrMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, logtagr, completer)

fun LogtagrMapper.selectByPrimaryKey(logtagrid_: Int) =
    selectOne {
        where { logtagrid isEqualTo logtagrid_ }
    }

fun LogtagrMapper.update(completer: UpdateCompleter) =
    update(this::update, logtagr, completer)

fun KotlinUpdateBuilder.updateAllColumns(row: Logtagr) =
    apply {
        set(logtagrid) equalToOrNull row::logtagrid
        set(logid) equalToOrNull row::logid
        set(logtagid) equalToOrNull row::logtagid
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(row: Logtagr) =
    apply {
        set(logtagrid) equalToWhenPresent row::logtagrid
        set(logid) equalToWhenPresent row::logid
        set(logtagid) equalToWhenPresent row::logtagid
    }

fun LogtagrMapper.updateByPrimaryKey(row: Logtagr) =
    update {
        set(logid) equalToOrNull row::logid
        set(logtagid) equalToOrNull row::logtagid
        where { logtagrid isEqualTo row.logtagrid!! }
    }

fun LogtagrMapper.updateByPrimaryKeySelective(row: Logtagr) =
    update {
        set(logid) equalToWhenPresent row::logid
        set(logtagid) equalToWhenPresent row::logtagid
        where { logtagrid isEqualTo row.logtagrid!! }
    }