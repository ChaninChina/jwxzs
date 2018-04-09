/**
 * 
 */
package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.model.Xtpz;


/**
 * @author Chanin
 *
 */
public interface IXtpzService {
	
	
	List<Xtpz> selectXtPz(Map<String, String> paramMap) throws Exception;

	int countByKey(HashMap<String, Object> paramMap)throws Exception;

}
