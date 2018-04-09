package com.service;

import java.util.List;
import java.util.Map;

import com.model.DictInfo;
import com.util.page.PageResult;

/**
 * 字典基本信息Service
 * @author QingLong
 */
public interface IDictInfoService {
	
	/**
	 * 新增字典基本信息
	 * @param dictInfo 字典对象 
	 * @throws Exception 异常
	 */
	public void insert(DictInfo dictInfo) throws Exception;
	
	/**
	 * 删除字典基本信息(通过字典主键)
	 * @param dictId 字典主键
	 * @throws Exception 异常
	 */
	public void deleteByDictId(String dictId) throws Exception;
	
	/**
	 * 删除字典基本信息(通过类型主键)
	 * @param typeId 类型主键
	 * @throws Exception 异常
	 */
	public void deleteByTypeId(String typeId) throws Exception;
	
	/**
	 * 删除字典基本信息(通过字典编号)
	 * @param dictCode 字典编号
	 * @throws Exception 异常
	 */
	public void deleteByDictCode(String dictCode) throws Exception;
	
	/**
	 * 删除字典基本信息(通过类型编号)
	 * @param typeCode 类型编号
	 * @throws Exception 异常
	 */
	public void deleteByTypeCode(String typeCode) throws Exception;
	
	/**
	 * 更新字典基本信息(通过字典主键)
	 * @param dictInfo 字典对象 
	 * @throws Exception 异常
	 */
	public void updateByDictIdSelective(DictInfo dictInfo) throws Exception;
	
	/**
	 * 查询字典基本信息
	 * @param dictInfo 字典对象 
	 * @return List<DictInfo> 字典对象集合
	 * @throws Exception 异常
	 */
	public List<DictInfo> select(DictInfo dictInfo) throws Exception;
	
	/**
	 * 查询字典基本信息(通过类型主键)
	 * @param typeId 类型主键
	 * @return List<DictInfo> 字典对象集合
	 * @throws Exception 异常
	 */
	public List<DictInfo> selectByTypeId(String typeId) throws Exception;
	
	/**
	 * 查询字典基本信息(通过字典主键)
	 * @param dictId 字典主键
	 * @return dictInfo 字典对象
	 * @throws Exception 异常
	 */
	public DictInfo selectByDictId(String dictId) throws Exception;
	
	/**
	 * 查询字典基本信息(通过类型编号)
	 * @param typeCode 类型编号
	 * @return List<DictInfo> 字典对象集合
	 * @throws Exception 异常 
	 */
	public List<DictInfo> selectByTypeCode(String typeCode) throws Exception;
	
	/**
	 * 查询字典基本信息(通过字典编号)
	 * @param dictCode
	 * @return dictInfo 字典对象
	 * @throws Exception 异常
	 */
	public DictInfo selectByDictCode(String dictCode) throws Exception;
	
	/**
	 * 搜索字典信息数量
	 * @param map 搜索条件 
	 * @return Integer 字典信息数量
	 * @throws Exception 异常
	 */
	public Integer searchSize(Map<String, Object> map) throws Exception;
	
	/**
	 * 搜索字典信息列表
	 * @param map 搜索条件  
	 * @return List<DictInfo> 字典对象集合
	 * @throws Exception 异常
	 */
	public List<DictInfo> searchList(Map<String, Object> map) throws Exception;
	
	/**
	 * 搜索字典信息分页
	 * @param map 搜索条件 
	 * @return PageResult 分页结果
	 * @throws Exception 异常
	 */
	public PageResult searchPage(Map<String, Object> map) throws Exception;
}