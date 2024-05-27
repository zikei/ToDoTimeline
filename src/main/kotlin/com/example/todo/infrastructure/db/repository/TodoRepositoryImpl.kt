package com.example.todo.infrastructure.db.repository

import com.example.todo.domain.model.Todo
import com.example.todo.domain.repository.TodoRepository
import com.example.todo.infrastructure.db.mapper.custom.TodoMapper
import com.example.todo.infrastructure.db.mapper.custom.selectByUserId
import com.example.todo.infrastructure.db.record.custom.TodoRecord
import org.springframework.stereotype.Repository

@Repository
class TodoRepositoryImpl(
    private val todoMapper: TodoMapper
): TodoRepository {
    override fun findListByUserId(userId: Int): List<Todo> {
        return todoMapper.selectByUserId(userId).map { toModel(it) }
    }

    private fun toModel(record: TodoRecord): Todo {
        val ptodo: Todo? = record.ptaskid?.let{
            Todo(
                record.ptaskid!!,
                record.puserid!!,
                record.ptaskname!!,
                record.pcreatedate!!,
                record.pseverity!!,
                record.pdeadline,
                record.ptaskstatus!!,
                null
            )
        }

        return Todo(
            record.taskid!!,
            record.userid!!,
            record.taskname!!,
            record.createdate!!,
            record.severity!!,
            record.deadline,
            record.taskstatus!!,
            ptodo
        )
    }
}