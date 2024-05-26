package com.example.todo.app.service

import com.example.todo.domain.model.Todo
import com.example.todo.domain.repository.TodoRepository
import com.example.todo.domain.service.TodoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TodoServiceImpl(
    @Autowired val todoRepo: TodoRepository
) : TodoService {

    override fun getList(userId: Int): List<Todo> {
        return todoRepo.findListByUserId(userId)
    }
}