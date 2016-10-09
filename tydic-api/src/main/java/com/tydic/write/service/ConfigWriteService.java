package com.tydic.write.service;

import com.tydic.common.Response;
import com.tydic.model.Config;

public interface ConfigWriteService {
	Response<Integer> add(Config record);

	Response<Integer> delete(String id);

	Response<Integer> save(Config record);
}
