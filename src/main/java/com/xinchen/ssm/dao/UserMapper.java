package com.xinchen.ssm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xinchen.ssm.entity.User;

/**   
* @Description: 
* @author xinchen  
* @date 2016年8月14日 下午7:04:16   
*/
@Repository(value="userMapper")
public interface UserMapper {
	
	/** 
	* @Title: queryAll 
	* @Description: TODO 查询所有    
	* @return List<User>     
	*/
	List<User> queryAll();
}
