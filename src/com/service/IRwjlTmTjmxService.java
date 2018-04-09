package com.service;

import java.util.HashMap;
import java.util.List;

import com.model.RwjlTmTjmx;
import com.model.RwjlXxTjmx;

public interface IRwjlTmTjmxService {

	List<RwjlTmTjmx> selectRwjlTmTjmx(HashMap<String, Object> hashMap) throws Exception;

	void updateRwjlTmTjmx(RwjlTmTjmx rwjlTmTjmx) throws Exception;

	void insertRwjlTmTjmx(RwjlTmTjmx rwjlTmTjmx) throws Exception;

}
