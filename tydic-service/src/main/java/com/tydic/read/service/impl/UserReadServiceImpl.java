package com.tydic.read.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tydic.common.Response;
import com.tydic.model.User;
import com.tydic.persist.UserMapper;
import com.tydic.read.service.UserReadService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserReadServiceImpl implements UserReadService {
	@Resource
	private UserMapper mapper;

	@Override
	public Response<List<User>> select() {
		try {
			return Response.ok(mapper.selectAll());
		} catch (Exception e) {
			log.error("database error: " + e.getMessage());
			e.printStackTrace();
			return Response
					.fail("Response<List<User>> com.tydic.read.service.impl.UserReadServiceImpl.select() select fail");
		}
	}

	@Override
	public Response<User> find(String uid) {
		try {
			return Response.ok(mapper.selectByPrimaryKey(uid));
		} catch (Exception e) {
			log.error("database error: " + e.getMessage());
			e.printStackTrace();
			return Response
					.fail("Response<User> com.tydic.read.service.impl.UserReadServiceImpl.find(String uid) find fail");
		}
	}

	@Override
	public Response<List<User>> getAll2() {
		return null;
	}

	@Override
	public Response<List<User>> getAll3() {
		return null;
	}

}
