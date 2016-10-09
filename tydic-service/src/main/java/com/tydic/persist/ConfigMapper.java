package com.tydic.persist;

import java.util.List;

import com.tydic.model.Config;
public interface ConfigMapper {
	int deleteByPrimaryKey(String id);

	int insert(Config record);

	int insertSelective(Config record);

	Config selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(Config record);

	int updateByPrimaryKey(Config record);

	List<Config> selectAll();
}
