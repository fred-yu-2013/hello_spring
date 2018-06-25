package com.fred.tutorialspoint;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans-springmvc.xml" })
public class HelloWorldTest2 {

	private MockMvc mockMvc;

	@Mock
	private HelloService helloService;

	@InjectMocks
	private HelloController helloController;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(helloController).build();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIndex() throws Exception {
		// mock 行为
		Mockito.doReturn(null).when(helloService).getAll();

		// 构建请求
		RequestBuilder request = MockMvcRequestBuilders.get("/helloworld");

		// 断言结果
		mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.view().name("error")).andReturn();
	}

}
