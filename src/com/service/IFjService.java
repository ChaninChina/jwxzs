/**
 * 
 */
package com.service;

import java.util.HashMap;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Chanin
 *
 */
public interface IFjService {

	/**
	 * @param multipartFile
	 * @return
	 */
	String saveFj(MultipartFile multipartFile) throws Exception;

	/**
	 * @param multipartFile
	 * @return
	 */
	String saveTpFj(String yhId, MultipartFile multipartFile) throws Exception;

	/**
	 * @param multipartFile
	 * @return
	 */
	String saveLyFj(String yhId, MultipartFile multipartFile) throws Exception;

	/**
	 * @param yhId
	 * @param multipartFile
	 * @return
	 */
	String saveSpFj(String yhId, MultipartFile multipartFile) throws Exception;

	String saveWjFj(String yhid, MultipartFile multipartFile) throws Exception;

	String selectRwfj(HashMap<String, Object> hashMap) throws Exception;

}
