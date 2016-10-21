package com.xinchen.ssm.demo.dao;

import java.util.List;

import com.xinchen.ssm.demo.entity.User;
import com.xinchen.ssm.demo.utils.PageUtil;

/**   
* @Description: 
* @author xinchen  
* @date 2016年8月14日 下午9:07:11   
*/
public interface UserDao {
	/** 
	* @Title: queryAll 
	* @Description: TODO 查询所有    
	* @return List<User>     
	*/
	public List<User> queryAll();
	
	/** 
	* @Title: save 
	* @Description: TODO 保存用户
	* @param  user  
	* @return int     
	*/
	public int save(User user);
	/** 
	* @Title: update
	* @Description: TODO 修改用户
	* @param  user  
	* @return int     
	*/
	public int update(User user);
	/** 
	* @Title: update
	* @Description: TODO 删除用户
	* @param  user  
	* @return Int     
	*/
	public int delete(String userName);
	/** 
	* @Title: findone
	* @Description: TODO 查询用户
	* @param  username  
	* @return User     
	*/
	public User findOne(String userName);
	
	/** 
	* @Title: page 
	* @Description: TODO 分页
	* @param @return     
	* @return List<User>     
	* @throws 
	*/
	public List<User> page(PageUtil pageUtil);
	/** 
	* @Title: pageCount 
	* @Description: TODO 页面总数
	* @param @return     
	* @return List<User>     
	* @throws 
	*/
	public int pageCount(PageUtil pageUtil);
}
