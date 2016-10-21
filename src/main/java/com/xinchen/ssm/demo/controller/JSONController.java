package com.xinchen.ssm.demo.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xinchen.ssm.demo.entity.User;

/** 
* @ClassName: JSONController 
* @Description: JOSN传值
* @author xinchen 2016年8月27日 下午6:19:58 
*  
*/
@Controller
public class JSONController {

	@RequestMapping("testjosn")
	public String main(){
		return "testjosn";
	}
	@RequestMapping(value="/testjosn/update",method=RequestMethod.POST)
	@ResponseBody   // 这个注解说明返回的是一个对象，不需要当做jsp 处理。   //@RequestBody注解请求参数在请求体里
	public Map <String,Object> update(@RequestBody User user,String username){
		Map<String,Object> map = new HashMap<String,Object>();
		System.out.println(user);
		System.out.println(username);
		map.put("status", 200);
		map.put("user", user);
		map.put("message", "success!");
		return map;
		
	}
}
