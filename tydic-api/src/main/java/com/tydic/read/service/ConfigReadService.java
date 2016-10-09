package com.tydic.read.service;

import java.util.List;

import com.tydic.common.Response;
import com.tydic.model.Config;

public interface ConfigReadService {
	Response<Config> find(String id);

	Response<List<Config>> select();
}
