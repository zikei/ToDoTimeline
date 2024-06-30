package com.example.todo.ui.validator

import com.example.todo.domain.model.Login
import com.example.todo.domain.service.TodoService
import com.example.todo.ui.form.RegisterPostRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.validation.Errors
import org.springframework.validation.Validator

@Component
class ThinkingLogPostValidator(
    @Autowired private val todoService: TodoService
) : Validator {
    override fun supports(clazz: Class<*>): Boolean {
        return RegisterPostRequest::class.java == clazz
    }

    override fun validate(target: Any, errors: Errors) {
        val form = target as RegisterPostRequest
        val loginUser = SecurityContextHolder.getContext().authentication.principal as Login

        val taskId = form.taskid ?: return

        val task = todoService.getTodo(taskId)
        if (task == null || task.userId != loginUser.user.userId) {
            errors.rejectValue("taskid", "com.example.todo.validator.notFound.message")
        }
    }
}