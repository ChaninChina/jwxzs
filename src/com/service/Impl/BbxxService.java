/**
 * 
 */
package com.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.mapper.BbxxMapper;
import com.model.Bbxx;
import com.service.IBbxxService;

/**
 * @author Chanin
 *
 */
public class BbxxService implements IBbxxService{
	
	@Resource
	private BbxxMapper bbXxMapper;

	/* 
	 * 
	 */
	@Override
	public List<Bbxx> selectBbXx(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return bbXxMapper.selectBbxx(paramMap);
	}

}
