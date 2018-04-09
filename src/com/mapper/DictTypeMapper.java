package com.mapper;

import java.util.List;

import com.model.DictType;

/**
 * 字典类型信息Mapper
 * @author QingLong
 */
public interface DictTypeMapper {
	
	/**
	 * 查询字典类型信息
	 * @param dictType 字典类型
	 * @return List<DictType> 字典类型对象集合
	 */
	public List<DictType> select(DictType dictType);
	
	/**
	 * 查询字典类型信息(通过类型主键)
	 * @param typeId 类型主键
	 * @return DictType 字典类型对象
	 */
	public DictType selectByTypeId(String typeId);
	
	/**
	 * 查询字典类型信息(通过字典主键)
	 * @param dictId 字典主键
	 * @return DictType 字典类型对象
	 */
	public DictType selectByDictId(String dictId);
	
	/**
	 * 查询字典类型信息(通过类型编号)
	 * @param typeCode 类型编号
	 * @return DictType 字典类型对象
	 */
	public DictType selectByTypeCode(String typeCode);
	
	/**
	 * 查询字典类型信息(通过字典编号)
	 * @param dictCode 字典编号
	 * @return DictType 字典类型对象
	 */
	public DictType selectByDictCode(String dictCode);
}