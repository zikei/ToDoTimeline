/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.example.todo.infrastructure.db.mapper

import com.example.todo.infrastructure.db.mapper.MemberDynamicSqlSupport.Member
import com.example.todo.infrastructure.db.mapper.MemberDynamicSqlSupport.Member.menid
import com.example.todo.infrastructure.db.mapper.MemberDynamicSqlSupport.Member.menstatus
import com.example.todo.infrastructure.db.mapper.MemberDynamicSqlSupport.Member.taskid
import com.example.todo.infrastructure.db.mapper.MemberDynamicSqlSupport.Member.userid
import com.example.todo.infrastructure.db.record.MemberRecord
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun MemberMapper.count(completer: CountCompleter) =
    countFrom(this::count, Member, completer)

fun MemberMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, Member, completer)

fun MemberMapper.deleteByPrimaryKey(menid_: Int) =
    delete {
        where(menid, isEqualTo(menid_))
    }

fun MemberMapper.insert(record: MemberRecord) =
    insert(this::insert, record, Member) {
        map(menid).toProperty("menid")
        map(taskid).toProperty("taskid")
        map(userid).toProperty("userid")
        map(menstatus).toProperty("menstatus")
    }

fun MemberMapper.insertMultiple(records: Collection<MemberRecord>) =
    insertMultiple(this::insertMultiple, records, Member) {
        map(menid).toProperty("menid")
        map(taskid).toProperty("taskid")
        map(userid).toProperty("userid")
        map(menstatus).toProperty("menstatus")
    }

fun MemberMapper.insertMultiple(vararg records: MemberRecord) =
    insertMultiple(records.toList())

fun MemberMapper.insertSelective(record: MemberRecord) =
    insert(this::insert, record, Member) {
        map(menid).toPropertyWhenPresent("menid", record::menid)
        map(taskid).toPropertyWhenPresent("taskid", record::taskid)
        map(userid).toPropertyWhenPresent("userid", record::userid)
        map(menstatus).toPropertyWhenPresent("menstatus", record::menstatus)
    }

private val columnList = listOf(menid, taskid, userid, menstatus)

fun MemberMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, Member, completer)

fun MemberMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, Member, completer)

fun MemberMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, Member, completer)

fun MemberMapper.selectByPrimaryKey(menid_: Int) =
    selectOne {
        where(menid, isEqualTo(menid_))
    }

fun MemberMapper.update(completer: UpdateCompleter) =
    update(this::update, Member, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: MemberRecord) =
    apply {
        set(menid).equalTo(record::menid)
        set(taskid).equalTo(record::taskid)
        set(userid).equalTo(record::userid)
        set(menstatus).equalTo(record::menstatus)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: MemberRecord) =
    apply {
        set(menid).equalToWhenPresent(record::menid)
        set(taskid).equalToWhenPresent(record::taskid)
        set(userid).equalToWhenPresent(record::userid)
        set(menstatus).equalToWhenPresent(record::menstatus)
    }

fun MemberMapper.updateByPrimaryKey(record: MemberRecord) =
    update {
        set(taskid).equalTo(record::taskid)
        set(userid).equalTo(record::userid)
        set(menstatus).equalTo(record::menstatus)
        where(menid, isEqualTo(record::menid))
    }

fun MemberMapper.updateByPrimaryKeySelective(record: MemberRecord) =
    update {
        set(taskid).equalToWhenPresent(record::taskid)
        set(userid).equalToWhenPresent(record::userid)
        set(menstatus).equalToWhenPresent(record::menstatus)
        where(menid, isEqualTo(record::menid))
    }