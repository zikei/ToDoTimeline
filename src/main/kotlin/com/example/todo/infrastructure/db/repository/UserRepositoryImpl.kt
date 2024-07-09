package com.example.todo.infrastructure.db.repository

import com.example.todo.domain.enums.MenStatus
import com.example.todo.domain.model.User
import com.example.todo.domain.repository.UserRepository
import com.example.todo.infrastructure.db.mapper.*
import com.example.todo.infrastructure.db.mapper.MemberDynamicSqlSupport.Member
import com.example.todo.infrastructure.db.mapper.TaskDynamicSqlSupport.Task
import com.example.todo.infrastructure.db.record.UserRecord
import org.mybatis.dynamic.sql.SqlBuilder.equalTo
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(
    private val mapper: UserMapper
) : UserRepository{

    override fun findById(id: Int): User? {
        val record = mapper.selectByPrimaryKey(id)
        return record?.let { toModel(it) }
    }

    override fun findByUserName(name: String): User? {
        val record = mapper.selectOne{
            where(UserDynamicSqlSupport.User.username, isEqualTo(name))
        }
        return record?.let { toModel(it) }
    }

    override fun findByTaskId(taskId: Int): List<User> {
        val records = mapper.selectDistinct {
            leftJoin(Task) {
                on(UserDynamicSqlSupport.User.userid, equalTo(Task.userid))
            }
            where(Task.taskid, isEqualTo(taskId))
        }.toMutableList()

        records += mapper.selectDistinct {
            leftJoin(Member){
                on(UserDynamicSqlSupport.User.userid, equalTo(Member.userid))
            }
            where(Member.taskid, isEqualTo(taskId))
                .and(Member.menstatus, isEqualTo(MenStatus.member))
        }.toMutableList()

        return records.map { toModel(it) }.distinct()
    }

    private fun toModel(record: UserRecord): User {
        return User(
            record.userid!!,
            record.username!!,
            record.dspname!!,
            record.password!!,
            record.role!!
        )
    }
}