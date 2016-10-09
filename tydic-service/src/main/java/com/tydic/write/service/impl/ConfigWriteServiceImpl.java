package com.tydic.write.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tydic.common.Response;
import com.tydic.model.Config;
import com.tydic.persist.ConfigMapper;
import com.tydic.write.service.ConfigWriteService;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class ConfigWriteServiceImpl implements ConfigWriteService {
	@Resource
	private ConfigMapper mapper;

	@Override
	public Response<Integer> add(Config record) {
		try {
			return Response.ok(mapper.insertSelective(record));
		} catch (Exception e) {
			log.error("database error: " + e.getMessage());
			e.printStackTrace();
			return Response.fail(
					"Response<Integer> com.tydic.write.service.impl.ConfigWriteServiceImpl.add(Config record) add fail");
		}
	}

	@Override
	public Response<Integer> delete(String id) {
		try {
			return Response.ok(mapper.deleteByPrimaryKey(id));
		} catch (Exception e) {
			log.error("database error: " + e.getMessage());
			e.printStackTrace();
			return Response.fail(
					"Response<Integer> com.tydic.write.service.impl.ConfigWriteServiceImpl.delete(String id) delete fail");
		}
	}

	@Override
	public Response<Integer> save(Config record) {
		try {
			return Response.ok(mapper.updateByPrimaryKey(record));
		} catch (Exception e) {
			log.error("database error: " + e.getMessage());
			e.printStackTrace();
			return Response.fail(
					"Response<Integer> com.tydic.write.service.impl.ConfigWriteServiceImpl.save(Config record) save fail");
		}
	}

}
