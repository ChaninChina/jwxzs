/**
 * 
 */
package com.service.Impl;


import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import com.mapper.SplcMapper;
import com.model.Splc;
import com.service.ISplcService;

/**
 * @author Chanin
 *
 */
public class SplcService implements ISplcService{
	
	@Resource
	SplcMapper splcMapper;

	/**
	 * 查询审批流程
	 */
	@Override
	public List<Splc> selectSplc(HashMap<String, Object> spclMap) throws Exception {
		// TODO Auto-generated method stub
		return splcMapper.selectSplc(spclMap);
	}


	


}
