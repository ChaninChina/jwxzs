package com.service;

import java.util.HashMap;

import com.model.Qzxx;

public interface IQzxxService {

	Qzxx selectQzxxByQzid(HashMap<String, Object> paramMap) throws Exception;

	Qzxx selectQzxxByQzBzm(HashMap<String, Object> paramMap) throws Exception;
	
	

}
