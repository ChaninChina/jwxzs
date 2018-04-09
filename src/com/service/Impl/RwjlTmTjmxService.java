package com.service.Impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import com.mapper.RwjlTmTjmxMapper;
import com.model.RwjlTmTjmx;
import com.service.IRwjlTmTjmxService;

public class RwjlTmTjmxService implements IRwjlTmTjmxService{
	
	@Resource
	RwjlTmTjmxMapper rwjlTmTjmxMapper;

	/**
	 * 查询任务记录条目统计明细
	 */
	@Override
	public List<RwjlTmTjmx> selectRwjlTmTjmx(HashMap<String, Object> hashMap) throws Exception {
		// TODO Auto-generated method stub
		return rwjlTmTjmxMapper.selectRwjlTmTjmx(hashMap);
	}

	/**
	 * 更新任务记录条目统计明细
	 */
	@Override
	public void updateRwjlTmTjmx(RwjlTmTjmx rwjlTmTjmx) throws Exception {
		// TODO Auto-generated method stub
		rwjlTmTjmxMapper.updateByPrimaryKeySelective(rwjlTmTjmx);
		
	}

	/**
	 * 新增一条任务记录条目统计明细
	 */
	@Override
	public void insertRwjlTmTjmx(RwjlTmTjmx rwjlTmTjmx) throws Exception {
		// TODO Auto-generated method stub
		rwjlTmTjmxMapper.insertSelective(rwjlTmTjmx);
	}

}
