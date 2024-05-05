package com.example.todo.ui.controller

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.servlet.view.InternalResourceViewResolver

@SpringBootTest
class HomeControllerTests {
    private val homeController = HomeController()
    private lateinit var mockMvc : MockMvc

    @BeforeEach
    fun setup() {
        val viewResolver = InternalResourceViewResolver()
        viewResolver.setPrefix("/WEB-INF/views/")
        viewResolver.setSuffix(".html")
        mockMvc = MockMvcBuilders.standaloneSetup(homeController).setViewResolvers(viewResolver).build()
    }


    @Test
    fun `home page is success`() {
        mockMvc.get("/")
            .andExpect {
                status { isOk() }
            }
    }
}