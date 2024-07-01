package com.example.todo.ui.controller

import com.example.todo.domain.enums.Severity
import com.example.todo.domain.enums.TaskStatus
import com.example.todo.domain.exception.AccessDeniedException
import com.example.todo.domain.model.Login
import com.example.todo.domain.service.TodoService
import com.example.todo.ui.form.RegisterPostRequest
import com.example.todo.ui.form.RegisterTaskRequest
import com.example.todo.ui.form.UpdTaskStatusRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/todo")
class TodoController(
    @Autowired private val todoService: TodoService
) {
    @ModelAttribute
    fun setUpRegisterTaskRequest(): RegisterTaskRequest {
        return RegisterTaskRequest()
    }

    @ModelAttribute
    fun setUpUpdTaskStatusRequest(): UpdTaskStatusRequest {
        return UpdTaskStatusRequest()
    }

    @ModelAttribute
    fun setupRegisterPostRequest(): RegisterPostRequest {
        return RegisterPostRequest()
    }

    /** Todo一覧ページ */
    @GetMapping
    fun todoHome(): String {
        return "todo"
    }

    /** Todo詳細 */
    @GetMapping("/detail/{taskId}")
    fun todoDetail(
        @PathVariable("taskId") taskId: Int,
        model: Model,
        updTaskForm: UpdTaskStatusRequest,
        postForm: RegisterPostRequest
    ): String {
        updTaskForm.taskId = taskId
        postForm.taskid = taskId

        val taskStatusList = TaskStatus.entries.toTypedArray()
        model.addAttribute("taskStatusList", taskStatusList)
        model.addAttribute("taskId", taskId)
        return "todoDetail"
    }

    /** Todo作成 */
    @GetMapping("/new")
    fun todoCreate(
        model: Model,
        @AuthenticationPrincipal loginUser: Login,
        @RequestParam(required = false) pid: Int? = null
    ): String {
        pid?.let {
            val task = todoService.getTodo(it)
            if (task == null || task.userId != loginUser.user.userId) {
                throw AccessDeniedException()
            }
            model.addAttribute("ptask", task)
        }

        val severityList = Severity.entries.toTypedArray()
        model.addAttribute("severityList", severityList)

        return "todoCreate"
    }
}