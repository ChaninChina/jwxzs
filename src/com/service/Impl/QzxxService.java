package com.service.Impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections4.CollectionUtils;

import com.mapper.QzxxMapper;
import com.model.Qzxx;
import com.model.Yhxx;
import com.service.IQzxxService;
import com.service.IYhxxService;
import com.util.dict.DictEnumUtil;


public class QzxxService implements IQzxxService{
	
	@Resource
	QzxxMapper qzxxMapper;
	@Resource
	IYhxxService yhxxService;

	/**
	 * 通过群组ID获取群组信息
	 */
	@Override
	public Qzxx selectQzxxByQzid(HashMap<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		List<Qzxx> qzxxs = qzxxMapper.selectQzxx(paramMap);
		
		if(CollectionUtils.isNotEmpty(qzxxs)) {
			Qzxx qzxx = fullQzxx(paramMap, qzxxs);
			return qzxx;
		}else {
			throw new Exception("未找到相关记录");
		}
		
	
	}

	/**
	 * 填充群组信息
	 * @param paramMap
	 * @param qzxxs
	 * @return
	 * @throws Exception
	 */
	private Qzxx fullQzxx(HashMap<String, Object> paramMap, List<Qzxx> qzxxs) throws Exception {
		Qzxx qzxx = qzxxs.get(0);
		paramMap.put("yhid", qzxx.getYhid());
		List<Yhxx> yhxxs = yhxxService.selectYhXx(paramMap);
		if(CollectionUtils.isNotEmpty(yhxxs)) {
			Yhxx yhxx = yhxxs.get(0);
			Yhxx y = new Yhxx.Builder()
					.yhxm(yhxx.getYhxm())
					.lxdh(yhxx.getLxdh())
					.yhzw(yhxx.getYhzw())
					.build();
			qzxx.setYhxx(y);
		}
		return qzxx;
	}

	/**
	 * 通过群组标识码获取群组信息
	 */
	@Override
	public Qzxx selectQzxxByQzBzm(HashMap<String, Object> paramMap) throws Exception {
		List<Qzxx> qzxxs = qzxxMapper.selectQzxxByQzBzm(paramMap);
		
		if(CollectionUtils.isNotEmpty(qzxxs)) {
			Qzxx qzxx = fullQzxx(paramMap, qzxxs);
			return qzxx;
		}else {
			throw new Exception("未找到相关记录");
		}
	}

}
