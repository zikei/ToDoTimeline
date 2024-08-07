package com.example.todo.ui.controller.api

import com.example.todo.domain.exception.BadRequestException
import com.example.todo.domain.model.Login
import com.example.todo.domain.model.Thinkinglog
import com.example.todo.domain.service.TimelineService
import com.example.todo.domain.service.TodoService
import com.example.todo.ui.form.GetTlListResponse
import com.example.todo.ui.form.RegisterPostRequest
import com.example.todo.ui.form.TlInfo
import com.example.todo.ui.validator.ThinkingLogPostValidator
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter
import java.time.LocalDateTime


/** Timelineコントローラ */
@RestController
@RequestMapping("/api/timeline")
class TimelineApiController(
    @Autowired private val tlService: TimelineService,
    @Autowired private val todoService: TodoService,
    @Autowired private val postValidator: ThinkingLogPostValidator
) {
    @InitBinder("registerPostRequest")
    fun initBinder(webDataBinder: WebDataBinder) {
        webDataBinder.addValidators(postValidator)
    }


    /** タイムラインの取得 */
    @GetMapping("/list")
    fun getList(@AuthenticationPrincipal loginUser: Login): GetTlListResponse {
        val tlList = tlService.getList(loginUser.user.userId).map {
            TlInfo(it)
        }
        return GetTlListResponse(tlList)
    }

    /** タスクからタイムラインを取得 */
    @GetMapping("/list/todo/{taskId}")
    fun getListByTaskId(
        @PathVariable("taskId") taskId: Int,
        @AuthenticationPrincipal loginUser: Login
    ): GetTlListResponse {
        val todo = todoService.getTodo(taskId, loginUser.user) ?: throw BadRequestException()

        val tlList = tlService.getListByTask(todo.taskId).map {
            TlInfo(it)
        }
        return GetTlListResponse(tlList)
    }

    /** 投稿の登録 */
    @PostMapping("/post")
    fun post(
        @Validated @RequestBody req: RegisterPostRequest,
        bindingResult: BindingResult,
        @AuthenticationPrincipal loginUser: Login,
        response: HttpServletResponse
    ) {
        if (bindingResult.hasErrors()) throw BadRequestException()

        tlService.thinkingLogPost(
            Thinkinglog(
                null,
                req.taskid,
                loginUser.user.userId,
                LocalDateTime.now(),
                req.contents!!
            )
        )
    }

    /** SSEの登録 */
    @GetMapping("/sse")
    fun seeRegister(@AuthenticationPrincipal loginUser: Login,
                    @RequestParam(required = false) taskId: Int? = null
    ): SseEmitter{
        taskId?.let { todoService.getTodo(it, loginUser.user) ?: throw BadRequestException() }

        return tlService.sseTimelineRegister(loginUser.user.userId, taskId)
    }
}