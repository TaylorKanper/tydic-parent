package com.tydic.write.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tydic.common.Response;
import com.tydic.model.User;
import com.tydic.persist.UserMapper;
import com.tydic.write.service.UserWriteService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserWriteServiceImpl implements UserWriteService {
	@Resource
	private UserMapper mapper;

	@Override
	public Response<Integer> save(User info) {
		try {
			info.setUtime(System.currentTimeMillis());
			return Response.ok(mapper.updateByPrimaryKeySelective(info));
		} catch (Exception e) {
			log.error("database error: " + e.getMessage());
			e.printStackTrace();
			return Response.fail(
					"Response<Integer> com.tydic.write.service.impl.UserWriteServiceImpl.save(User info) save fail");
		}
	}

}
