package com.service.Impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.mapper.AreaInfoMapper;
import com.model.AreaInfo;
import com.service.IAreaInfoService;
import com.util.DateUtil;
import com.util.PinyUtil;
import com.util.dict.DictEnumUtil;
import com.util.dict.DictFillUtil;
import com.util.page.PageInfo;
import com.util.page.PageResult;
import com.util.page.PageUtil;
import com.util.qy.AreaListUtil;

/**
 * 区域基本信息Service
 * @author QingLong
 */
@Service("areaInfoService")
public class AreaInfoServiceImpl implements IAreaInfoService {
	
	Logger logger = Logger.getLogger(AreaInfoServiceImpl.class);
	
	@Resource
	private AreaInfoMapper areaInfoMapper;
	@Resource
	private AreaListUtil areaListUtil;
	@Resource
	private DictFillUtil dictFillUtil;
	
	/**
	 * 保存区域基本信息
	 * @param areaInfo 区域对象
	 * @throws Exception 异常
	 */
	@Override
	public void insert(AreaInfo areaInfo) throws Exception {
		if (null != areaInfo) {
			//区域首拼
			if(StringUtils.isBlank(areaInfo.getAreaPiny())){
				areaInfo.setAreaPiny(PinyUtil.getTersePinyin(areaInfo.getAreaName(), false));
			}
			//启用标志
			if (StringUtils.isBlank(areaInfo.getEnableStatus())) {
				areaInfo.setEnableStatus(DictEnumUtil.ENABLE_STATUS_YQY); //已启用
			}
			//创建时间
			if (StringUtils.isBlank(areaInfo.getCreateTime())) {
				areaInfo.setCreateTime(DateUtil.getDate(DateUtil.yyyy_MM_dd_HH_mm_ss));
			}
			areaInfoMapper.insert(areaInfo);
		}
	}
	
	/**
	 * 删除区域基本信息(通过区域主键)
	 * @param areaId 区域主键
	 * @throws Exception 异常
	 */
	@Override
	public void deleteByAreaId(String areaId) throws Exception {
		if (StringUtils.isBlank(areaId)) {
			return;
		}
		areaInfoMapper.deleteByAreaId(areaId);
		areaListUtil.putList(); //重置缓存
	}
	
	/**
	 * 更新区域基本信息(通过区域主键)
	 * @param areaInfo 区域对象
	 * @throws Exception 异常
	 */
	@Override
	public void updateByAreaIdSelective(AreaInfo areaInfo) throws Exception {
		if (StringUtils.isBlank(areaInfo.getAreaId())) {
			return;
		}
		if (StringUtils.isBlank(areaInfo.getUpdateTime())) { //更新时间
			areaInfo.setUpdateTime(DateUtil.getDate(DateUtil.yyyy_MM_dd_HH_mm_ss));
		}
		areaInfoMapper.updateByAreaIdSelective(areaInfo);
		areaListUtil.putList(); //重置缓存
	}
	
	/**
	 * 查询区域基本信息
	 * @param areaInfo 区域对象
	 * @return List<AreaInfo> 区域对象集合
	 * @throws Exception 异常
	 */
	@Override
	public List<AreaInfo> select(AreaInfo areaInfo) throws Exception {
		List<AreaInfo> areaInfoList = areaInfoMapper.select(areaInfo);
		return areaInfoList;
	}
	
	/**
	 * 查询区域基本信息(通过区域主键)
	 * @param areaId 区域主键
	 * @return AreaInfo 区域对象
	 * @throws Exception 异常
	 */
	@Override
	public AreaInfo selectByAreaId(String areaId) throws Exception {
		if (StringUtils.isBlank(areaId)) {
			return null;
		}
		return areaInfoMapper.selectByAreaId(areaId);
	}
	
	/**
	 * 查询区域基本信息(通过父级主键)
	 * @param prevId 父级主键
	 * @return List<AreaInfo> 区域对象集合
	 * @throws Exception 异常
	 */
	@Override
	public List<AreaInfo> selectByPrevId(String prevId) throws Exception {
		return areaInfoMapper.selectByPrevId(prevId);
	}
	
	/**
	 * 搜索区域信息数量
	 * @param map 搜索条件
	 * @return Integer 区域信息数量
	 * @throws Exception 异常
	 */
	@Override
	public Integer searchSize(Map<String, Object> map) throws Exception {
		return areaInfoMapper.searchSize(map);
	}
	
	/**
	 * 搜索区域信息列表
	 * @param map 搜索条件
	 * @return List<AreaInfo> 区域对象集合
	 * @throws Exception 异常
	 */
	@Override
	public List<AreaInfo> searchList(Map<String, Object> map) throws Exception {
		return areaInfoMapper.searchList(map);
	}
	
	/**
	 * 搜索区域信息分页
	 * @param map 搜索条件
	 * @return PageResult 分页结果
	 * @throws Exception 异常
	 */
	@Override
	public PageResult searchPage(Map<String, Object> map) throws Exception {
		Object ep = map.get("ep"); //每页数量
		Integer everyPage = ((ep == null || ep == "") ? Integer.valueOf(DictEnumUtil.DEFAULT_EVERYPAGE) : Integer.valueOf(String.valueOf(ep)));
		Object cn = map.get("cn"); //当前页码
		Integer currentNo = ((cn == null || cn == "") ? 1 : Integer.valueOf(String.valueOf(cn)));
		//总记录数
		Integer size = areaInfoMapper.searchSize(map);
		PageInfo pageInfo = PageUtil.createPage(everyPage, currentNo, size); //分页实体
		map.put("page", pageInfo);
		List<AreaInfo> areaInfoList = null;//返回集合
		if(size != null && size > 0){
			areaInfoList = areaInfoMapper.searchList(map);
		}
		return new PageResult (pageInfo, areaInfoList);
	}
}