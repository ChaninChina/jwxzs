/**
 * 
 */
package com.service;

import java.util.HashMap;
import java.util.List;

import com.model.Strw;
import com.model.Stxx;
import com.model.Yhxx;
import com.util.page.PageResult;

/**
 * @author Chanin
 *
 */
public interface IStrwService {



	public boolean hasPermission(String rwid, String yhid) throws Exception;

	public List<Strw> selectStrwByStId(String stid, String yhid) throws Exception;

	public Strw selectStrwByRwId(String rwid, String yhid) throws Exception;

	//public PageResult<Strw> selectStrwPage(HashMap<String, Object> stTmParamMap) throws Exception;

	public List<Strw> selectStrw(HashMap<String, Object> paramMap) throws Exception;

	public PageResult<Strw> selectStrwPageZT(HashMap<String, Object> strwParamMap) throws Exception;

	public int selectCount(HashMap<String, Object> paramMap) throws Exception;

	public List<Strw> selectStrwWWC(HashMap<String, Object> paramMap) throws Exception;

	public PageResult<Strw> searchStrw(HashMap<String, Object> paramMap) throws Exception;

	public List<Strw> selectYhStrw(HashMap<String, Object> paramMap)throws Exception;

	// public PageResult<Strw> selectStrwPageWWC(HashMap<String, Object>
	// strwParamMap) throws Exception;
}
