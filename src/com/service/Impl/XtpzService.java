/**
 * 
 */
package com.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.mapper.XtpzMapper;
import com.model.Xtpz;
import com.service.IXtpzService;

/**
 * @author Chanin
 *
 */
public class XtpzService implements IXtpzService {

	@Resource
	private XtpzMapper xtPzMapper;

	/*
	 * (non-Javadoc) 获取系统配置信息
	 */
	@Override
	public List<Xtpz> selectXtPz(Map<String, String> paramMap) throws Exception {

		return xtPzMapper.selectXtpz(paramMap);
	}

	/**
	 * 查询关键字数量
	 */
	@Override
	public int countByKey(HashMap<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return xtPzMapper.selectCount(paramMap);
	}

}
