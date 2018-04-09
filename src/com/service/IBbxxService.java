/**
 * 
 */
package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.model.Bbxx;



/**
 * @author Chanin
 *
 */
public interface IBbxxService {
	
	
	List<Bbxx> selectBbXx(Map<String, Object> map) throws Exception;

}
