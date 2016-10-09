package com.tydic.write.service;

import com.tydic.common.Response;
import com.tydic.model.User;

public interface UserWriteService {
	Response<Integer> save(User info);
}
