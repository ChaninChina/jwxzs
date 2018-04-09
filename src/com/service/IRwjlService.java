/**
 * 
 */
package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.model.Rwjl;
import com.model.RwjlTm;
import com.util.page.PageResult;

/**
 * @author Chanin
 *
 */
public interface IRwjlService {

	





	/**
	 * @param yhid
	 * @param rwjl
	 * @param files
	 * @return
	 */
	boolean saveRwjl(String yhid, Rwjl rwjl, Map<String, List<MultipartFile>> files) throws Exception;

	/**
	 * @param paramMap
	 * @return
	 */
	List<Rwjl> selectRwjl(HashMap<String, Object> paramMap) throws Exception;

	List<Rwjl> selectRwjlInfo(HashMap<String, Object> paramMap) throws Exception;

	PageResult<Rwjl> selectRwjlPage(HashMap<String, Object> paramMap) throws Exception;

}
