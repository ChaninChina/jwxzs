package com.service;

import java.util.HashMap;
import java.util.List;

import com.model.RwjlXxTjmx;

public interface IRwjlXxTjmxService {

	List<RwjlXxTjmx> selectRwjlXxTjmx(HashMap<String, Object> hashMap) throws Exception;

	void updateRwjlXxTjmx(RwjlXxTjmx rwjlXxTjmx) throws Exception;

	void insertRwjlXxTjmx(RwjlXxTjmx rwjlXxTjmx) throws Exception;

}
