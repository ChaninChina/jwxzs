package com.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.mapper.DictTypeMapper;
import com.model.DictType;
import com.service.IDictTypeService;

/**
 * 字典类型信息Service
 * @author QingLong
 */
@Service("dictTypeService")
public class DictTypeServiceImpl implements IDictTypeService{
	
	Logger logger = Logger.getLogger(DictTypeServiceImpl.class);
	
	@Resource
	private DictTypeMapper dictTypeMapper;
	
	/**
	 * 查询字典类型信息
	 * @param dictType
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<DictType> select(DictType dictType) throws Exception{
		List<DictType> dictTypeList = dictTypeMapper.select(dictType);
		return dictTypeList;
	}
	
	/**
	 * 查询字典类型信息(通过类型主键)
	 * @param typeId
	 * @return
	 * @throws Exception
	 */
	@Override
	public DictType selectByTypeId(String typeId) throws Exception{
		if (StringUtils.isBlank(typeId)) {
			return null;
		}
		return dictTypeMapper.selectByTypeId(typeId);
	}
	
	/**
	 * 查询字典类型信息(通过字典主键)
	 * @param dictId
	 * @return
	 * @throws Exception
	 */
	@Override
	public DictType selectByDictId(String dictId) throws Exception{
		if (StringUtils.isBlank(dictId)) {
			return null;
		}
		return dictTypeMapper.selectByDictId(dictId);
	}
	
	/**
	 * 查询字典类型信息(通过类型编号)
	 * @param typeCode 类型编号
	 * @return DictType 字典类型对象
	 * @throws Exception 异常
	 */
	public DictType selectByTypeCode(String typeCode) throws Exception {
		if (StringUtils.isBlank(typeCode)) {
			return null;
		}
		return dictTypeMapper.selectByTypeCode(typeCode);
	}
	
	/**
	 * 查询字典类型信息(通过字典编号)
	 * @param dictCode 字典编号
	 * @return DictType 字典类型对象
	 * @throws Exception 异常
	 */
	public DictType selectByDictCode(String dictCode) throws Exception {
		if (StringUtils.isBlank(dictCode)) {
			return null;
		}
		return dictTypeMapper.selectByDictCode(dictCode);
	}
}