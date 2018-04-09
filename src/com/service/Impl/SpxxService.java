/**
 * 
 */
package com.service.Impl;


import javax.annotation.Resource;

import com.mapper.SpxxMapper;
import com.model.Spxx;
import com.service.ISpxxService;

/**
 * @author Chanin
 *
 */
public class SpxxService implements ISpxxService{
	
	@Resource
	SpxxMapper spxxMapper;

	/**
	 * 插入审批信息
	 */
	@Override
	public void insert(Spxx spxx) throws Exception {
		spxxMapper.insertSelective(spxx);
	}


	


}
