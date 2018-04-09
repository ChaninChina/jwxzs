package com.service;

import java.util.List;

import com.model.DictType;

/**
 * 字典类型信息Service
 * @author QingLong
 */
public interface IDictTypeService {
	
	/**
	 * 查询字典类型信息
	 * @param dictType 字典类型
	 * @return List<DictType> 字典类型对象集合
	 * @throws Exception 异常
	 */
	public List<DictType> select(DictType dictType) throws Exception;
	
	/**
	 * 查询字典类型信息(通过类型主键)
	 * @param typeId 类型主键
	 * @return DictType 字典类型对象
	 * @throws Exception 异常
	 */
	public DictType selectByTypeId(String typeId) throws Exception;
	
	/**
	 * 查询字典类型信息(通过字典主键)
	 * @param dictId 字典主键
	 * @return DictType 字典类型对象
	 * @throws Exception 异常
	 */
	public DictType selectByDictId(String dictId) throws Exception;
	
	/**
	 * 查询字典类型信息(通过类型编号)
	 * @param typeCode 类型编号
	 * @return DictType 字典类型对象
	 * @throws Exception 异常
	 */
	public DictType selectByTypeCode(String typeCode) throws Exception;
	
	/**
	 * 查询字典类型信息(通过字典编号)
	 * @param dictCode 字典编号
	 * @return DictType 字典类型对象
	 * @throws Exception 异常
	 */
	public DictType selectByDictCode(String dictCode) throws Exception;
}