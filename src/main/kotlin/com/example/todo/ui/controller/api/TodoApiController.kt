package com.example.todo.ui.controller.api

import com.example.todo.domain.enums.Severity
import com.example.todo.domain.enums.TaskStatus
import com.example.todo.domain.exception.BadRequestException
import com.example.todo.domain.exception.NotFoundException
import com.example.todo.domain.model.Login
import com.example.todo.domain.model.Task
import com.example.todo.domain.model.Thinkinglog
import com.example.todo.domain.service.TimelineService
import com.example.todo.domain.service.TodoService
import com.example.todo.ui.form.*
import com.example.todo.ui.validator.TodoCreateValidator
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.*
import java.time.LocalDate
import java.time.LocalDateTime


/** ToDoコントローラ */
@RestController
@RequestMapping("/api/todo")
class TodoApiController(
    @Autowired private val todoService: TodoService,
    @Autowired private val tlService: TimelineService,
    @Autowired private val todoCreateValidator: TodoCreateValidator,
    @Value("\${user.sys.id}") private val sysUserId: String
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
        val todo = todoService.getTodo(taskId, loginUser.user)?.let {
            TodoInfo(it)
        } ?: throw NotFoundException()

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

        tlService.thinkingLogPost(
            Thinkinglog(
                null,
                taskId,
                sysUserId.toInt(),
                LocalDateTime.now(),
                "新規: ${req.taskName} を作成"
            )
        )

        response.setHeader("hx-redirect", "/todo/detail/$taskId")
    }

    /** Taskステータスの変更 */
    @PutMapping("/upd/status")
    fun updTaskStatus(
        @RequestBody req: UpdTaskStatusRequest,
        @AuthenticationPrincipal loginUser: Login,
        response: HttpServletResponse
    ): GetTodoDetailResponse{
        val reqTaskId = req.taskId ?: throw BadRequestException()
        val task = todoService.getTodo(reqTaskId, loginUser.user) ?: throw BadRequestException()
        val taskStatus = TaskStatus.getTaskStatus(req.taskStatus) ?: throw BadRequestException()

        todoService.updTaskStatus(task.taskId, taskStatus)
        val todo = todoService.getTodo(task.taskId)?.let{
            TodoInfo(it)
        }


        tlService.thinkingLogPost(
            Thinkinglog(
                null,
                todo!!.taskId,
                sysUserId.toInt(),
                LocalDateTime.now(),
                "変更: ${todo.taskName} の状態を ${todo.taskStatus.statusName} に変更"
            )
        )

        return GetTodoDetailResponse(todo)
    }
}