package com.xinchen.ssm.controller;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
/**   
* @Description: 
* @author xinchen   
* @date 2016年10月17日 下午4:41:20 
* @version V1.0   
*/
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:springmvc-context.xml","classpath*:applicationcontext-*.xml"})
public class MVCTestController {
	private static final Log log = LogFactory.getLog(MVCTestController.class);
	
	private MockMvc mockMvc;
	
	@Autowired
	protected WebApplicationContext wac;
	
	MockHttpServletRequest request;
	
	@Before
	public void setup() {
		// 获取mockMvc实例
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void show() throws Exception{
		mockMvc.perform(get("/mvc/show")).andExpect(status().isOk()).andDo(print());
	}
	@Test
	public void ajax() throws Exception{
		mockMvc.perform(get("/mvc/getPerson")).andExpect(status().isOk()).andDo(print());
	}
	@Test
	public void test() throws Exception{
		mockMvc.perform(get("/redirect")).andDo(print());
	}
}
