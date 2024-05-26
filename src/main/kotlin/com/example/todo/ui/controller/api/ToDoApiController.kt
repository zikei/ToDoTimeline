package com.example.todo.ui.controller.api

import com.example.todo.domain.model.Login
import com.example.todo.domain.service.TodoService
import com.example.todo.ui.form.GetTodoListResponse
import com.example.todo.ui.form.TodoInfo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/** ToDoコントローラ */
@RestController
@RequestMapping("/api/todo")
class ToDoApiController(
    @Autowired val todoService: TodoService
) {

    /** ToDo一覧の取得 */
    @GetMapping("/list")
    fun getList(@AuthenticationPrincipal loginUser: Login) : GetTodoListResponse {
        val bookList = todoService.getList(loginUser.user.userId).map {
            TodoInfo(it)
        }
        return GetTodoListResponse(bookList)
    }
}