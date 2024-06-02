package com.example.todo.infrastructure.db.repository

import com.example.todo.domain.model.Task
import com.example.todo.domain.model.Todo
import com.example.todo.domain.repository.TodoRepository
import com.example.todo.infrastructure.db.mapper.TaskMapper
import com.example.todo.infrastructure.db.mapper.custom.TodoMapper
import com.example.todo.infrastructure.db.mapper.custom.selectByPrimaryKey
import com.example.todo.infrastructure.db.mapper.custom.selectByUserId
import com.example.todo.infrastructure.db.mapper.insert
import com.example.todo.infrastructure.db.record.TaskRecord
import com.example.todo.infrastructure.db.record.custom.TodoRecord
import org.springframework.stereotype.Repository

@Repository
class TodoRepositoryImpl(
    private val todoMapper: TodoMapper,
    private val taskMapper: TaskMapper
) : TodoRepository {
    override fun findById(taskId: Int): Todo? {
        return todoMapper.selectByPrimaryKey(taskId)?.let { toModel(it) }
    }

    override fun findListByUserId(userId: Int): List<Todo> {
        return todoMapper.selectByUserId(userId).map { toModel(it) }
    }

    override fun create(task: Task) {
        taskMapper.insert(toRecord(task))
    }

    /** TodoレコードをTodoモデルに変換 */
    private fun toModel(record: TodoRecord): Todo {
        val parent: Todo? = record.ptaskid?.let {
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
            parent
        )
    }

    /** TaskモデルをTaskレコードに変換 */
    fun toRecord(model: Task): TaskRecord {
        return TaskRecord(
            model.taskId,
            model.userId,
            model.taskName,
            model.createDate,
            model.severity,
            model.deadline,
            model.taskStatus,
            model.parentId
        )
    }
}