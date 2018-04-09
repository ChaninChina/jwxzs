package com.service.Impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import com.mapper.RwjlXxTjmxMapper;
import com.model.RwjlXxTjmx;
import com.service.IRwjlXxTjmxService;

public class RwjlXxTjmxService implements IRwjlXxTjmxService{

	@Resource
	RwjlXxTjmxMapper rwjlXxTjmxMapper;
	
	/**
	 * 查询任务记录条目选项统计明细
	 */
	@Override
	public List<RwjlXxTjmx> selectRwjlXxTjmx(HashMap<String, Object> hashMap) throws Exception {
		// TODO Auto-generated method stub
		return rwjlXxTjmxMapper.selectRwjlXxTjmx(hashMap);
	}

	/**
	 * 修改任务记录条目选项统计明细
	 */
	@Override
	public void updateRwjlXxTjmx(RwjlXxTjmx rwjlXxTjmx) throws Exception {
		// TODO Auto-generated method stub
		rwjlXxTjmxMapper.updateByPrimaryKeySelective(rwjlXxTjmx);
	}
	
	

	/**
	 * 新增一条任务记录条目选项统计明细
	 */
	@Override
	public void insertRwjlXxTjmx(RwjlXxTjmx rwjlXxTjmx) throws Exception {
		// TODO Auto-generated method stub
		rwjlXxTjmxMapper.insertSelective(rwjlXxTjmx);
	}

}
