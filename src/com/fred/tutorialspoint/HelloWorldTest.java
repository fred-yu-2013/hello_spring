package com.fred.tutorialspoint;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:beans-springmvc.xml"})
public class HelloWorldTest {

	private MockMvc mockMvc;
	
	@Autowired  
    private HelloController helloController;  

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(helloController).build();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test  
    public void testIndex() throws Exception {  
        mockMvc.perform(MockMvcRequestBuilders.get("/helloworld"))  
                .andExpect(MockMvcResultMatchers.view().name("success"))
                .andReturn();
//        fail();
    }

}
