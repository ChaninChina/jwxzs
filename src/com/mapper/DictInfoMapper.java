package com.mapper;

import java.util.List;
import java.util.Map;

import com.model.DictInfo;

/**
 * 字典基本信息Mapper
 * @author QingLong
 */
public interface DictInfoMapper {
	
	/**
	 * 新增字典基本信息
	 * @param dictInfo 字典对象 
	 */
	public void insert(DictInfo dictInfo);
	
	/**
	 * 删除字典基本信息(通过字典主键)
	 * @param dictId 字典主键
	 */
	public void deleteByDictId(String dictId);
	
	/**
	 * 删除字典基本信息(通过类型主键)
	 * @param typeId 类型主键
	 */
	public void deleteByTypeId(String typeId);
	
	/**
	 * 删除字典基本信息(通过字典编号)
	 * @param dictCode 字典编号
	 */
	public void deleteByDictCode(String dictCode);
	
	/**
	 * 删除字典基本信息(通过类型编号)
	 * @param typeCode 类型编号
	 */
	public void deleteByTypeCode(String typeCode);
	
	/**
	 * 更新字典基本信息(通过字典主键)
	 * @param dictInfo 字典对象 
	 */
	public void updateByDictIdSelective(DictInfo dictInfo);
	
	/**
	 * 查询字典基本信息
	 * @param dictInfo 字典对象 
	 * @return List<DictInfo> 字典对象集合
	 */
	public List<DictInfo> select(DictInfo dictInfo);
	
	/**
	 * 查询字典基本信息(通过类型主键)
	 * @param map 搜索条件
	 * @return List<DictInfo> 字典对象集合
	 */
	public List<DictInfo> selectByTypeId(Map<String, String> map);
	
	/**
	 * 查询字典基本信息(通过类型主键)
	 * @param map 搜索条件
	 * @return dictInfo 字典对象
	 */
	public DictInfo selectByDictId(Map<String, String> map);
	
	/**
	 * 查询字典基本信息(通过类型编号)
	 * @param map 搜索条件
	 * @return List<DictInfo> 字典对象集合
	 */
	public List<DictInfo> selectByTypeCode(Map<String, String> map);
	
	/**
	 * 查询字典基本信息(通过字典编号)
	 * @param map 搜索条件
	 * @return dictInfo 字典对象
	 */
	public DictInfo selectByDictCode(Map<String, String> map);
	
	/**
	 * 搜索字典信息数量
	 * @param map 搜索条件 
	 * @return Integer 字典信息数量
	 */
	public Integer searchSize(Map<String, Object> map);
	
	/**
	 * 搜索字典信息列表
	 * @param map 搜索条件  
	 * @return List<DictInfo> 字典对象集合
	 */
	public List<DictInfo> searchList(Map<String, Object> map);
}