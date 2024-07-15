package com.example.todo.ui.config

import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
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
import org.springframework.security.web.savedrequest.DefaultSavedRequest
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping


@Profile("default")
@Configuration
@EnableWebSecurity
class WebSecurityConfig(@Autowired val userDetailsService: UserDetailsService) {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain? {
        http {
            authorizeHttpRequests {
                authorize(PathRequest.toStaticResources().atCommonLocations(), permitAll)
                authorize("/img/**", permitAll)
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
            csrf {
                // TODO:CSRFの設定
                disable()
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
class WebSecurityConfigNoAuth(@Autowired val userDetailsService: UserDetailsService) {
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain? {
        http {
            authorizeHttpRequests {
                authorize(anyRequest, authenticated)
            }
            formLogin {
                loginPage = "/dev/login"
                permitAll = true
            }
            csrf {
                disable()
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
@Controller
@RequestMapping("/dev")
class DevLoginController(
    @Value("\${dev.user.name}") private val userName: String,
    @Value("\${dev.user.pass}") private val userPass: String
) {
    @GetMapping("/login")
    fun login(request: HttpServletRequest): String {
        request.login(userName, userPass)

        val savedRequest =
            request.getSession(false)?.getAttribute("SPRING_SECURITY_SAVED_REQUEST") as? DefaultSavedRequest
        val url = savedRequest?.redirectUrl ?: "/"

        return "redirect:$url"
    }
}