package com.xinchen.ssm.controller;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @Description:
 * @author xinchen
 * @date 2016年9月20日 下午10:07:35
 * @version V1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:springmvc-context.xml","classpath*:applicationcontext-*.xml"})
public class UserControllerTests {
	private static final Log log = LogFactory.getLog(UserControllerTests.class);
	private MockMvc mockMvc;
	public static String BASE_URL = "";
	@Autowired
	protected WebApplicationContext wac;
	// @Autowired
	// private UserController userController;

	MockHttpServletRequest request;

	@Before
	public void setup() {
		// 获取mockMvc实例
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	@Test
	public void simple() throws Exception {
		MvcResult result = mockMvc.perform(post("/test")).andExpect(status().isOk()) // 执行一个RequestBuilder请求
				.andDo(print()).andExpect(view().name("test")).andReturn();
		log.info(result);
	}

}
