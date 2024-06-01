package com.example.todo.domain.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class NotFoundException(msg: String? = null) : RuntimeException(msg)

@ResponseStatus(HttpStatus.FORBIDDEN)
class AccessDeniedException(msg: String? = null) : RuntimeException(msg)