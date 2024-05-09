package com.example.todo.domain.model

import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.User


data class Login(val user: com.example.todo.domain.model.User)
    : User(
        user.userName,
        user.password,
        AuthorityUtils.createAuthorityList(user.role.toString())
    )