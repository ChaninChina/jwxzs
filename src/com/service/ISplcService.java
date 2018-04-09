/**
 * 
 */
package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.model.Splc;

/**
 * @author Chanin
 *
 */
public interface ISplcService {

	public List<Splc> selectSplc(HashMap<String, Object> spclMap) throws Exception;

}
