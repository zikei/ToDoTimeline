package com.example.todo.app.service

import com.example.todo.domain.model.Login
import com.example.todo.domain.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DbUserDetailsService(
    @Autowired val userRepo: UserRepository
): UserDetailsService {

    @Transactional(readOnly =  true)
    override fun loadUserByUsername(username: String?): UserDetails {
        val user = username?.let { userRepo.findByUserName(it) }
        user ?: throw UsernameNotFoundException("username NotFound: $username")
        return Login(user)
    }
}
