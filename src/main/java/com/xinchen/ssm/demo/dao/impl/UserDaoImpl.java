package com.xinchen.ssm.demo.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.xinchen.ssm.demo.dao.UserDao;
import com.xinchen.ssm.demo.entity.User;
import com.xinchen.ssm.demo.utils.PageUtil;

/**   
* @Description: 
* @author xinchen  
* @date 2016年8月14日 下午9:07:49   
*/
@Repository
public class UserDaoImpl implements UserDao {
	@Resource
	public SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<User> queryAll() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("UserMapper.queryAll");
	}

	@Override
	public int save(User user) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert("UserMapper.save",user);
	}

	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("UserMapper.update",user);
	}

	@Override
	public int delete(String userName) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.delete(userName);
	}

	@Override
	public User findOne(String userName) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("UserMapper.findOne",userName);
	}

	@Override
	public List<User> page(PageUtil pageUtil) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("UserMapper.page",pageUtil);
	}

	@Override
	public int pageCount(PageUtil pageUtil) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("UserMapper.pageCount",pageUtil);
	}
	
}
