package com.example.todo.infrastructure.db.repository

import com.example.todo.domain.enums.MenStatus
import com.example.todo.domain.model.User
import com.example.todo.domain.repository.UserRepository
import com.example.todo.infrastructure.db.mapper.UserMapper
import com.example.todo.infrastructure.db.mapper.selectByPrimaryKey
import com.example.todo.infrastructure.db.mapper.selectDistinct
import com.example.todo.infrastructure.db.mapper.selectOne
import org.springframework.stereotype.Repository
import com.example.todo.infrastructure.db.mapper.MemberDynamicSqlSupport as MemberSql
import com.example.todo.infrastructure.db.mapper.MemberDynamicSqlSupport.member as MemberTable
import com.example.todo.infrastructure.db.mapper.TaskDynamicSqlSupport as TaskSql
import com.example.todo.infrastructure.db.mapper.TaskDynamicSqlSupport.task as taskTable
import com.example.todo.infrastructure.db.mapper.UserDynamicSqlSupport as UserSql
import com.example.todo.infrastructure.db.record.User as UserRecord

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
            where{ UserSql.username isEqualTo name }
        }
        return record?.let { toModel(it) }
    }

    override fun findByTaskId(taskId: Int): List<User> {
        val record = mapper.selectDistinct {
            leftJoin(taskTable) {
                on(UserSql.userid) equalTo TaskSql.userid
            }
            leftJoin(MemberTable){
                on(UserSql.userid) equalTo MemberSql.userid
            }
            where {
                TaskSql.taskid isEqualTo taskId
                or{
                    MemberSql.taskid isEqualTo taskId
                    and{
                        MemberSql.menstatus isEqualTo MenStatus.member
                    }
                }
            }
        }
        return record.map { toModel(it) }
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