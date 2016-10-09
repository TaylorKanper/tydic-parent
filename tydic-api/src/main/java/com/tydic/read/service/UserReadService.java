package com.tydic.read.service;

import java.util.List;

import com.tydic.common.Response;
import com.tydic.model.User;

public interface UserReadService {
	Response<List<User>> select();

	Response<User> find(String uid);

	Response<List<User>> getAll2();

	Response<List<User>> getAll3();
}
