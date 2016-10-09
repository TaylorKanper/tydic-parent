package com.tydic.read.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tydic.common.Response;
import com.tydic.model.Config;
import com.tydic.persist.ConfigMapper;
import com.tydic.read.service.ConfigReadService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ConfigReadServiceImpl implements ConfigReadService {
	@Resource
	private ConfigMapper mapper;

	@Override
	public Response<Config> find(String id) {
		try {
			return Response.ok(mapper.selectByPrimaryKey(id));
		} catch (Exception e) {
			log.error("database error: " + e.getMessage());
			e.printStackTrace();
			return Response.fail(
					"Response<Config> com.tydic.read.service.impl.ConfigReadServiceImpl.find(String id) find fail");
		}
	}

	@Override
	public Response<List<Config>> select() {
		try {
			return Response.ok(mapper.selectAll());
		} catch (Exception e) {
			log.error("database error: " + e.getMessage());
			e.printStackTrace();
			return Response.fail(
					"Response<List<Config>> com.tydic.read.service.impl.ConfigReadServiceImpl.select() select fail");
		}
	}

}
