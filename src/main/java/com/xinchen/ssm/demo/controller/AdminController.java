package com.xinchen.ssm.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**   
* @Description: 
* @author xinchen 2016年8月16日 下午9:15:17   
*/
@Controller
public class AdminController {
	@RequestMapping("/adminlogin")
	public String adminlogin(){
		return "adminlogin";	
	}
}
