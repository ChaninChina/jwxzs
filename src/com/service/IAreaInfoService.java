package com.service;

import java.util.List;
import java.util.Map;

import com.model.AreaInfo;
import com.util.page.PageResult;

/**
 * 区域基本信息IService
 * @author QingLong
 */
public interface IAreaInfoService {
	
	/**
	 * 保存区域基本信息
	 * @param areaInfo 区域对象
	 * @throws Exception 异常
	 */
	public void insert(AreaInfo areaInfo) throws Exception;
	
	/**
	 * 删除区域基本信息(通过区域主键)
	 * @param areaId 区域主键
	 * @throws Exception 异常
	 */
	public void deleteByAreaId(String areaId) throws Exception;
	
	/**
	 * 更新区域基本信息(通过区域主键)
	 * @param areaInfo 区域对象
	 * @throws Exception 异常
	 */
	public void updateByAreaIdSelective(AreaInfo areaInfo) throws Exception;
	
	/**
	 * 查询区域基本信息
	 * @param areaInfo 区域对象
	 * @return List<AreaInfo> 区域对象集合
	 * @throws Exception 异常
	 */
	public List<AreaInfo> select(AreaInfo areaInfo) throws Exception;
	
	/**
	 * 查询区域基本信息(通过区域主键)
	 * @param areaId 区域主键
	 * @return AreaInfo 区域对象
	 * @throws Exception 异常
	 */
	public AreaInfo selectByAreaId(String areaId) throws Exception;
	
	/**
	 * 查询区域基本信息(通过父级主键)
	 * @param prevId 父级主键
	 * @return List<AreaInfo> 区域对象集合
	 * @throws Exception 异常
	 */
	public List<AreaInfo> selectByPrevId(String prevId) throws Exception;
	
	/**
	 * 搜索区域信息数量
	 * @param map 搜索条件
	 * @return Integer 区域信息数量
	 * @throws Exception 异常
	 */
	public Integer searchSize(Map<String, Object> map) throws Exception;
	
	/**
	 * 搜索区域信息列表
	 * @param map 搜索条件
	 * @return List<AreaInfo> 区域对象集合
	 * @throws Exception 异常
	 */
	public List<AreaInfo> searchList(Map<String, Object> map) throws Exception;
	
	/**
	 * 搜索区域信息分页
	 * @param map 搜索条件
	 * @return PageResult 分页结果
	 * @throws Exception 异常
	 */
	public PageResult searchPage(Map<String, Object> map) throws Exception;
}