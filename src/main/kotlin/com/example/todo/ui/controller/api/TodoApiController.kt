package com.example.todo.ui.controller.api

import com.example.todo.domain.enums.Severity
import com.example.todo.domain.enums.TaskStatus
import com.example.todo.domain.exception.BadRequestException
import com.example.todo.domain.exception.NotFoundException
import com.example.todo.domain.model.Login
import com.example.todo.domain.model.Task
import com.example.todo.domain.service.TodoService
import com.example.todo.ui.form.GetTodoDetailResponse
import com.example.todo.ui.form.GetTodoListResponse
import com.example.todo.ui.form.RegisterTaskRequest
import com.example.todo.ui.form.TodoInfo
import com.example.todo.ui.validator.TodoCreateValidator
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.*
import java.time.LocalDate


/** ToDoコントローラ */
@RestController
@RequestMapping("/api/todo")
class TodoApiController(
    @Autowired private val todoService: TodoService,
    @Autowired private val todoCreateValidator: TodoCreateValidator
) {
    @InitBinder("registerTaskRequest")
    fun initBinder(webDataBinder: WebDataBinder) {
        webDataBinder.addValidators(todoCreateValidator)
    }


    /** ToDo一覧の取得 */
    @GetMapping("/list")
    fun getList(@AuthenticationPrincipal loginUser: Login): GetTodoListResponse {
        val todoList = todoService.getList(loginUser.user.userId).map {
            TodoInfo(it)
        }
        return GetTodoListResponse(todoList)
    }

    /** ToDo詳細取得 */
    @GetMapping("/detail/{taskId}")
    fun getDetail(
        @PathVariable("taskId") taskId: Int,
        @AuthenticationPrincipal loginUser: Login
    ): GetTodoDetailResponse {
        val todo = todoService.getTodo(taskId)?.let {
            TodoInfo(it)
        }

        // Todoが見つからない場合・Todoのユーザとログインユーザが違う場合例外
        todo ?: throw NotFoundException()
        if (todo.userId != loginUser.user.userId) throw NotFoundException()


        return GetTodoDetailResponse(todo)
    }

    /** Taskの登録 */
    @PostMapping("/new")
    fun create(
        @Validated @RequestBody req: RegisterTaskRequest,
        bindingResult: BindingResult,
        @AuthenticationPrincipal loginUser: Login,
        response: HttpServletResponse
    ) {
        if (bindingResult.hasErrors()) throw BadRequestException()

        val taskId = todoService.create(
            Task(
                null,
                loginUser.user.userId,
                req.taskName!!,
                req.memo,
                LocalDate.now(),
                Severity.getSeverity(req.severity),
                req.deadline,
                TaskStatus.open,
                req.parentId
            )
        )

        response.sendRedirect("/todo/detail/$taskId")
    }
}