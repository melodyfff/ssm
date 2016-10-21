package com.xinchen.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xinchen.ssm.dao.UserDao;
import com.xinchen.ssm.dao.UserMapper;
import com.xinchen.ssm.entity.User;
import com.xinchen.ssm.service.UserService;
import com.xinchen.ssm.utils.PageUtil;

/**   
* @Description: 
* @author xinchen  
* @date 2016年8月14日 下午7:09:17   
*/
@Service("userService")
public class UserServiceImpl implements UserService {
	 @Autowired
	 private UserMapper userMapper;
	
	 @Autowired
	 private UserDao userDao;
	 
	//此为只实现Dao接口，不需要impl实现类的写法
	@Override
	public List<User> loadUsers() {
		// TODO Auto-generated method stub
		return userMapper.queryAll();
	}
 
	@Override
	public List<User> loadUsers2() {
		// TODO Auto-generated method stub
		return userDao.queryAll();
	}

	@Override
	public int save(User user) {
		// TODO Auto-generated method stub
		return userDao.save(user);
	}

	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
		return userDao.update(user);
	}

	@Override
	public int delete(String userName) {
		// TODO Auto-generated method stub
		return userDao.delete(userName);
	}

	@Override
	public User findOne(String userName) {
		// TODO Auto-generated method stub
		return userDao.findOne(userName);
	}

	@Override
	public List<User> page(PageUtil pageUtil) {
		// TODO Auto-generated method stub
		return userDao.page(pageUtil);
	}

	@Override
	public int pageCount(PageUtil pageUtil) {
		// TODO Auto-generated method stub
		return userDao.pageCount(pageUtil);
	}

	
	

}
