package com.xinchen.ssm.controller;

import java.io.IOException;

import java.util.HashMap;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class IndexController {
	
	
	
	@RequestMapping(value ="/test",method = RequestMethod.POST)
	public String test(){
		return "test";	
	}
	
	@RequestMapping("/modal")
	public String modal(){
		return "modal";	
	}
	
	@RequestMapping("/jqueryajax")
	public String jqaj(){
		return "jqueryajax";	
	}
	@RequestMapping("/jtest")
	public String jtest(){
		return "jtest";	
	}
	
	@RequestMapping("/jquery-form")

	public Model jq_from(Model model,String name,String password,String param1){
		model.addAttribute("name",name);
		model.addAttribute("password",password);
		model.addAttribute("param1", param1);
		return model;	
	}
	
	/**
	 * ajax传值
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/jtest/ajax") 
	@ResponseBody
    public  Map<String,Object> login(HttpServletRequest request,HttpServletResponse response) throws IOException{
		System.out.println(request.getParameter("name1"));
		System.out.println(request.getParameter("pass"));
        Map<String,Object> map = new HashMap<String,Object>();  
          

        if(request.getParameter("name1").equals("123")){  
        System.out.println("成功");  
        map.put("msg", "成功");  
    }else{  
        System.out.println("失败");  
        map.put("msg", "失败");  
    }  
        return map;  
    }  
	
	/**
	 * ajax传值
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/jtest/a") 
	@ResponseBody
    public  Map<String,Object> a(HttpServletRequest request,HttpServletResponse response) throws IOException{ 
		
		System.out.println(request.getParameter("uName"));

        Map<String,Object> map = new HashMap<String,Object>();  
          
        if(request.getParameter("uName").equals("123")){  
            System.out.println("成功");  
            map.put("msg", "成功");  
        }else{  
            System.out.println("失败");  
            map.put("msg", "失败");  
        }  
        return map;  
    }  
	@RequestMapping("/jqueryajax/a") 
	@ResponseBody
    public  Map<String,Object> jqja(HttpServletRequest request,HttpServletResponse response) throws IOException{ 
		
		System.out.println(request.getParameter("myname"));

        Map<String,Object> map = new HashMap<String,Object>();  
          
        if(request.getParameter("myname").equals("123")){  
            System.out.println("成功");  
            map.put("msg", "成功");  
        }else{  
            System.out.println("失败");  
            map.put("msg", "失败");  
        }  
        return map;  
    }  
	
	
	/**
	 * input传值到后台得到结果返回前台
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/jtest/ajax1") 
	@ResponseBody
    public  Map<String,Object> testAjax(HttpServletRequest request,HttpServletResponse response) throws IOException{
		System.out.println(request.getParameter("name1"));
        Map<String,Object> map = new HashMap<String,Object>();  
          

        if(request.getParameter("name1").equals("123")){  
        System.out.println("成功");  
        map.put("msg", "成功");  
    }else{  
        System.out.println("失败");  
        map.put("msg", "失败");  
    }  
        return map;  
    } 
	
	/**
	 * 即时验证是否存在该值，返回结果
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/jtest/ajax2") 
	@ResponseBody
    public  Map<String,Object> testAjax2(HttpServletRequest request,HttpServletResponse response) throws IOException{
		System.out.println(request.getParameter("name1"));
        Map<String,Object> map = new HashMap<String,Object>();  
          

        if(request.getParameter("name1").equals("123")){  
        System.out.println("成功");  
        map.put("msg", "成功");  
    }else{  
        System.out.println("失败");  
        map.put("msg", "失败");  
    }  
        return map;  
    } 
	

	
}
