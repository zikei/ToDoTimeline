package com.example.todo.ui.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.security.servlet.PathRequest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain


@Profile("default")
@Configuration
@EnableWebSecurity
class WebSecurityConfig(@Autowired val userDetailsService: UserDetailsService) {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain? {
        http{
            authorizeHttpRequests{
                authorize(PathRequest.toStaticResources().atCommonLocations(), permitAll)
                authorize("/", permitAll)
                authorize(anyRequest, authenticated)
            }
            formLogin {
                loginPage = "/login"
                loginProcessingUrl = "/login"
                permitAll = true
            }
            logout {
                logoutUrl = "/logout"
                logoutSuccessUrl = "/"
            }
        }
        return http.build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}

@Profile("dev")
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