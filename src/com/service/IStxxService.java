/**
 * 
 */
package com.service;

import java.util.HashMap;
import java.util.List;

import com.model.Stxx;
import com.model.Yhxx;



/**
 * @author Chanin
 *
 */
public interface IStxxService {

	
	
	
	public List<Stxx> selectStxx(HashMap<String, Object> paramMap) throws Exception;

	
	
}
