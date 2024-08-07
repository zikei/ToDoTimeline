package com.example.todo.app.service

import com.example.todo.domain.enums.TaskStatus
import com.example.todo.domain.model.Task
import com.example.todo.domain.model.Todo
import com.example.todo.domain.model.User
import com.example.todo.domain.repository.TodoRepository
import com.example.todo.domain.repository.UserRepository
import com.example.todo.domain.service.TodoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TodoServiceImpl(
    @Autowired val todoRepo: TodoRepository,
    @Autowired val userRepo: UserRepository
) : TodoService {

    override fun getList(userId: Int): List<Todo> {
        return todoRepo.findListByUserId(userId)
    }

    override fun getTodo(taskId: Int): Todo? {
        return todoRepo.findById(taskId)
    }

    override fun getTodo(taskId: Int, user: User): Todo?{
        val todo = getTodo(taskId)?.let { todo ->
            val usersId = userRepo.findByTaskId(todo.taskId).map { user -> user.userId }
            if(usersId.contains(user.userId)){
                todo
            }else{
                null
            }
        }

        return todo
    }

    override fun create(task: Task): Int {
        return todoRepo.create(task)
    }

    override fun updTaskStatus(taskId: Int, taskStatus: TaskStatus){
        todoRepo.updTaskStatus(taskId, taskStatus)
    }
}