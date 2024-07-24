/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.todo.infrastructure.db.mapper

import com.example.todo.infrastructure.db.mapper.MemberDynamicSqlSupport.member
import com.example.todo.infrastructure.db.mapper.MemberDynamicSqlSupport.menid
import com.example.todo.infrastructure.db.mapper.MemberDynamicSqlSupport.menstatus
import com.example.todo.infrastructure.db.mapper.MemberDynamicSqlSupport.taskid
import com.example.todo.infrastructure.db.mapper.MemberDynamicSqlSupport.userid
import com.example.todo.infrastructure.db.record.Member
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
interface MemberMapper : CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<Member>, CommonUpdateMapper {
    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @Results(id="MemberResult", value = [
        Result(column="menId", property="menid", jdbcType=JdbcType.INTEGER, id=true),
        Result(column="taskId", property="taskid", jdbcType=JdbcType.INTEGER),
        Result(column="userId", property="userid", jdbcType=JdbcType.INTEGER),
        Result(column="menStatus", property="menstatus", typeHandler=EnumTypeHandler::class, jdbcType=JdbcType.CHAR)
    ])
    fun selectMany(selectStatement: SelectStatementProvider): List<Member>

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @ResultMap("MemberResult")
    fun selectOne(selectStatement: SelectStatementProvider): Member?
}

fun MemberMapper.count(completer: CountCompleter) =
    countFrom(this::count, member, completer)

fun MemberMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, member, completer)

fun MemberMapper.deleteByPrimaryKey(menid_: Int) =
    delete {
        where { menid isEqualTo menid_ }
    }

fun MemberMapper.insert(row: Member) =
    insert(this::insert, row, member) {
        map(menid) toProperty "menid"
        map(taskid) toProperty "taskid"
        map(userid) toProperty "userid"
        map(menstatus) toProperty "menstatus"
    }

fun MemberMapper.insertMultiple(records: Collection<Member>) =
    insertMultiple(this::insertMultiple, records, member) {
        map(menid) toProperty "menid"
        map(taskid) toProperty "taskid"
        map(userid) toProperty "userid"
        map(menstatus) toProperty "menstatus"
    }

fun MemberMapper.insertMultiple(vararg records: Member) =
    insertMultiple(records.toList())

fun MemberMapper.insertSelective(row: Member) =
    insert(this::insert, row, member) {
        map(menid).toPropertyWhenPresent("menid", row::menid)
        map(taskid).toPropertyWhenPresent("taskid", row::taskid)
        map(userid).toPropertyWhenPresent("userid", row::userid)
        map(menstatus).toPropertyWhenPresent("menstatus", row::menstatus)
    }

private val columnList = listOf(menid, taskid, userid, menstatus)

fun MemberMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, member, completer)

fun MemberMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, member, completer)

fun MemberMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, member, completer)

fun MemberMapper.selectByPrimaryKey(menid_: Int) =
    selectOne {
        where { menid isEqualTo menid_ }
    }

fun MemberMapper.update(completer: UpdateCompleter) =
    update(this::update, member, completer)

fun KotlinUpdateBuilder.updateAllColumns(row: Member) =
    apply {
        set(menid) equalToOrNull row::menid
        set(taskid) equalToOrNull row::taskid
        set(userid) equalToOrNull row::userid
        set(menstatus) equalToOrNull row::menstatus
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(row: Member) =
    apply {
        set(menid) equalToWhenPresent row::menid
        set(taskid) equalToWhenPresent row::taskid
        set(userid) equalToWhenPresent row::userid
        set(menstatus) equalToWhenPresent row::menstatus
    }

fun MemberMapper.updateByPrimaryKey(row: Member) =
    update {
        set(taskid) equalToOrNull row::taskid
        set(userid) equalToOrNull row::userid
        set(menstatus) equalToOrNull row::menstatus
        where { menid isEqualTo row.menid!! }
    }

fun MemberMapper.updateByPrimaryKeySelective(row: Member) =
    update {
        set(taskid) equalToWhenPresent row::taskid
        set(userid) equalToWhenPresent row::userid
        set(menstatus) equalToWhenPresent row::menstatus
        where { menid isEqualTo row.menid!! }
    }