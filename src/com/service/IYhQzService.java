package com.service;

import java.util.HashMap;
import java.util.List;

import com.model.YhQz;

public interface IYhQzService {

	List<YhQz> selectYhQz(HashMap<String, Object> yhqzParamMap) throws Exception;

	void save(String qzid, String yhid)throws Exception;

	void update(YhQz qz)throws Exception;

}
