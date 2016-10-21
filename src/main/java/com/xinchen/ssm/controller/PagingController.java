package com.xinchen.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xinchen.ssm.entity.User;
import com.xinchen.ssm.service.UserService;
import com.xinchen.ssm.utils.PageUtil;

/**   
* @Description: 分页
* @author xinchen 2016年8月27日 下午6:16:08   
*/
@Controller
@RequestMapping("paging")
public class PagingController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("fenye")
	public String paging(){
		return "paging/fenye";
	}
	
	@RequestMapping("page")
	@ResponseBody   // 这个注解说明返回的是一个对象，不需要当做jsp 处理。   //@RequestBody注解请求参数在请求体里
	public  Map<String,Object> page(@RequestBody PageUtil pageUtil){
		//存储所有的信息,方面返回json串
        Map<String,Object> model = new HashMap<>();
        
        System.out.println("limit--->"+pageUtil.getLimit()+"offset--->"+pageUtil.getOffset()+
        					"order"+pageUtil.getOrder()+"ordername"+pageUtil.getOrdername()
        					+"search"+pageUtil.getSearch());
        List<User> list = userService.page(pageUtil);
        
        System.out.println(list.size());
        
        model.put("total",userService.pageCount(pageUtil));
        model.put("rows", list);
		return model;
		
	}
}
