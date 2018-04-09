/**
 * 
 */
package com.service.Impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;


import com.mapper.FjxxMapper;
import com.mapper.StFjMapper;
import com.mapper.StxxMapper;
import com.model.Fjxx;
import com.model.Stxx;
import com.model.Yhxx;
import com.service.IStrwService;
import com.service.IStxxService;
import com.util.dict.DictEnumUtil;
import com.util.jg.OrgnListUtil;

/**
 * @author Chanin
 *
 */
public class StxxService implements IStxxService{
	
	
	@Resource
	private StxxMapper stXxMapper;

	@Resource
	private OrgnListUtil orgnListUtil;
	
	@Resource
	private FjxxMapper fjXxMapper;
	
	@Resource
	private StFjMapper stFjMapper;


	/* (non-Javadoc)
	 * 查询实体信息以及实体相关的附件信息
	 */
	@Override
	public List<Stxx> selectStxx(HashMap<String, Object> paramMap) {
		List<Stxx> stXxs = stXxMapper.selectStxx(paramMap);
		if(CollectionUtils.isNotEmpty(stXxs)){
			for(Stxx stXx:stXxs){
				HashMap<String, String> stFjMap = new HashMap<>();
				stFjMap.put("stid", stXx.getStid());
				stFjMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
				List<Fjxx> fjXxs = fjXxMapper.selectStFjxx(stFjMap);
				stXx.setFjxxs(fjXxs);
			}
		}
		
		return stXxs;
	}

	
}
