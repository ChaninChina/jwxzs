/**
 * 
 */
package com.service;

import java.util.HashMap;
import java.util.List;

import com.model.MbTmfz;
import com.model.Mbxx;

/**
 * @author Chanin
 *
 */
public interface IMbxxService {
	
	
	
	public List<MbTmfz> selectMbTmFz(HashMap<String, Object> paramMap) throws Exception;

	/**
	 * @param paramMap
	 * @return
	 */
	public List<Mbxx> selectMbXx(HashMap<String, String> paramMap) throws Exception;

	/**
	 * @param paramMap
	 * @return
	 */
	public Mbxx selectMbXxByStId(HashMap<String, String> paramMap) throws Exception;

	public Mbxx selectMbXxByRwid(String rwid) throws Exception;
	

}
