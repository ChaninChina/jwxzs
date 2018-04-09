package com.mapper;

import java.util.List;
import java.util.Map;

import com.model.AreaInfo;

/**
 * 区域基本信息Mapper
 * @author QingLong
 */
public interface AreaInfoMapper {
	
	/**
	 * 保存区域基本信息
	 * @param areaInfo
	 */
	public void insert(AreaInfo areaInfo);
	
	/**
	 * 删除区域基本信息(通过区域主键)
	 * @param areaId
	 */
	public void deleteByAreaId(String areaId);
	
	/**
	 * 更新区域基本信息(通过区域主键)
	 * @param areaInfo
	 */
	public void updateByAreaIdSelective(AreaInfo areaInfo);
	
	/**
	 * 查询区域基本信息
	 * @param areaInfo
	 * @return
	 */
	public List<AreaInfo> select(AreaInfo areaInfo);
	
	/**
	 * 查询区域基本信息(通过区域主键)
	 * @param areaId
	 * @return
	 */
	public AreaInfo selectByAreaId(String areaId);
	
	/**
	 * 查询区域基本信息(通过父级主键)
	 * @param prevId
	 * @return
	 */
	public List<AreaInfo> selectByPrevId(String prevId);
	
	/**
	 * 搜索区域信息数量
	 * @param map
	 * @return
	 */
	public Integer searchSize(Map<String, Object> map);
	
	/**
	 * 搜索区域信息列表
	 * @param map
	 * @return
	 */
	public List<AreaInfo> searchList(Map<String, Object> map);
}