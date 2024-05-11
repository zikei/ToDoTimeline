package com.example.todo

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.test.context.support.WithAnonymousUser
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
class TodoApplicationTests(@Autowired private val mockMvc: MockMvc) {

	@Test
	@WithAnonymousUser
	fun `home page is not protected`() {
		mockMvc.get("/")
			.andExpect {
				status { isOk() }
			}
	}

	@Test
	@WithAnonymousUser
	fun `login page is not protected`() {
		mockMvc.get("/login")
			.andExpect {
				status { isOk() }
			}
	}
  
  @Test
	@WithAnonymousUser
	fun `todo page redirects to login`() {
		mockMvc.get("/todo")
			.andExpect {
				status { is3xxRedirection() }
				header {
					redirectedUrlPattern("**/login")
				}
			}
	}

	@Test
	@WithMockUser(authorities = ["USER"])
	fun `logged in user can access todo page`() {
		mockMvc.get("/todo")
			.andExpect {
				status { isOk() }
			}
	}
  
}
