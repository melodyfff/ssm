package com.xinchen.ssm.controller;

import java.util.List;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xinchen.ssm.entity.User;
import com.xinchen.ssm.service.UserService;

/**   
* @Description: 
* @author xinchen  
* @date 2016年8月14日 下午7:13:20   
*/
@Controller
@RequestMapping("/user")
public class UserController {
	private Logger log = Logger.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	
	/**
	 * TODO 加载用户
	 * @param model
	 * @return
	 */
	@RequestMapping("/showUser")
	public String showUser(Model model){
		
		//这个方法直接调用接口，只需接口和mapper映射文件，不用完成impl类
	/*	List<User> users = userService.loadUsers();
		model.addAttribute("users",users);*/
		
		//加载用户
		List<User> users2 = userService.loadUsers2();
		model.addAttribute("users2",users2);
		return "showuser";
	}
	
	/**
	 * TODO 添加用户 
	 * @param model
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("add")
	public String addUser(Model model,String userName,String password){
		
		User user = new User();
		user.setUsername(userName);
		user.setPassword(password);
		
		if(user.getUsername() != "" && user.getPassword() != null){
			try{
				log.info("------------------------------新增用户------------------------"+user);
				int addUser = userService.save(user);
				log.info("------------------------------结果===='"+addUser+"'");
			}catch(Exception e){
				log.error(e);
			}
		} 
		
		//加载用户
		List<User> users2 = userService.loadUsers2();
		model.addAttribute("users2",users2);
		return "showuser";	
	}
	
	/**
	 * TODO 修改用户密码
	 * @param model
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("update")
	public String updateUser(Model model,String userName,String password){
		
		User user = new User();
		user.setUsername(userName);
		user.setPassword(password);
		
		if(user.getUsername() != "" && user.getPassword() != null){
			try{
				log.info("------------------------------修改用户------------------------"+user);
				int updateUser = userService.update(user);
				log.info("------------------------------结果===='"+updateUser+"'");
			}catch(Exception e ){
				log.error(e);
			}
		}
		//加载用户
		List<User> users2 = userService.loadUsers2();
		model.addAttribute("users2",users2);
		return "showuser";	
		
	}
	/**
	 * TODO 删除用户
	 * @param model
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("delete")
	public String deleteUser(Model model,String userName){
		if(userName != "" && userName != null){
			try{
				log.info("------------------------------删除用户------------------------"+userName);
				int deleteUser = userService.delete(userName);
				log.info("------------------------------结果===='"+deleteUser+"'");
			}catch(Exception e){
				log.error(e);
			}
		}
		
		//加载用户
				List<User> users2 = userService.loadUsers2();
				model.addAttribute("users2",users2);
				return "showuser";	
	}
	
	@RequestMapping("find")
	public String findUser(Model model,String userName){
		if(userName != "" && userName != null){
			try{
				log.info("------------------------------查找用户------------------------"+userName);
				User findUser = userService.findOne(userName);
				log.info("------------------------------结果===='"+findUser+"'");
				model.addAttribute("find_user",findUser);
			}catch(Exception e){
				log.error(e);
			}
		}
		
		return "showuser";
		
	}
	
}
