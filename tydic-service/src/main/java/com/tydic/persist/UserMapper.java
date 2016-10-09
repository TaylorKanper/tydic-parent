package com.tydic.persist;

import java.util.List;

import com.tydic.model.User;

public interface UserMapper {
	int deleteByPrimaryKey(Integer uid);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(String uid);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	List<User> selectAll();
}
