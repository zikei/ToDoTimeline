package com.example.todo.ui.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.web.SecurityFilterChain

@Profile("default")
@Configuration
@EnableWebSecurity
class WebSecurityConfig {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain? {
        http{
            authorizeHttpRequests{
                authorize(anyRequest, authenticated)
            }
        }
        return http.build()
    }
}

@Profile("div")
@Configuration
@EnableWebSecurity
class WebSecurityConfigNoAuth {
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain? {
        http{
            authorizeHttpRequests{
                authorize(anyRequest, permitAll)
            }
        }
        return http.build()
    }
}