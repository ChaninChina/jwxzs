package com.service.Impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import com.mapper.YhQzMapper;
import com.model.YhQz;
import com.service.IYhQzService;
import com.util.DateUtil;
import com.util.UUIDUtil;
import com.util.dict.DictEnumUtil;

public class YhQzService implements IYhQzService{
	
	@Resource
	private YhQzMapper yhQzMapper;

	/**
	 * 查询用户群组信息
	 */
	@Override
	public List<YhQz> selectYhQz(HashMap<String, Object> yhqzParamMap) {
		// TODO Auto-generated method stub
		return yhQzMapper.selectYhQz(yhqzParamMap);
	}

	/**
	 * 申请加入群组 插入一条申请信息
	 */
	@Override
	public void save(String qzid, String yhid) throws Exception {
		// TODO Auto-generated method stub
		String nowDate = DateUtil.getDate(DateUtil.yyyy_MM_dd_HH_mm_ss);
		YhQz yhQz = new YhQz.Builder()
				.yhid(yhid)
				.qzid(qzid)
				.createId(yhid)
				.createTime(nowDate)
				.updateId(yhid)
				.updateTime(nowDate)
				.deleteStatus(DictEnumUtil.DELETE_STATUS_WSC)
				.enableStatus(DictEnumUtil.ENABLE_STATUS_YQY)
				.glybz(DictEnumUtil.GLYBZ_FALSE)
				.qzYhId(UUIDUtil.getUUID())
				.cyjs(DictEnumUtil.QCYJS_CY)
				.shzt(DictEnumUtil.REVIEW_STATUS_WSH)
				.build();
		yhQzMapper.insertSelective(yhQz);
		
	}

	/**
	 * 修改群组信息
	 */
	@Override
	public void update(YhQz qz) throws Exception {
		// TODO Auto-generated method stub
		yhQzMapper.updateByPrimaryKeySelective(qz);
	}

}
