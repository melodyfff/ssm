package com.xinchen.ssm.controller;

import java.io.PrintWriter;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xinchen.ssm.entity.User;

/**
 * @Description:
 * @author xinchen
 * @date 2016年10月17日 下午4:36:21
 * @version V1.0
 */
@Controller
public class TestController {
	// pass the parameters to front-end
	@RequestMapping("mvc/show")
	public String showPerson(Map<String, Object> map) {
		User p = new User();
		map.put("p", p);
		p.setId(1);
		p.setUsername("test");
		p.setPassword("123");
		return "mvc/show";
	}

	// pass the parameters to front-end using ajax
	@RequestMapping("mvc/getPerson")
	public void getPerson(String name, PrintWriter pw) {
		pw.write("hello," + name);
	}

	@RequestMapping("mvc/name")
	public String sayHello() {
		return "mvc/name";
	}

	// redirect
	@RequestMapping("/redirect")
	public String redirect() {
		return "redirect:mvc/show";
	}

}
