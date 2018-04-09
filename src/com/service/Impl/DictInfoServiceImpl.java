package com.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.mapper.DictInfoMapper;
import com.mapper.DictTypeMapper;
import com.model.DictInfo;
import com.model.DictType;
import com.service.IDictInfoService;
import com.util.DateUtil;
import com.util.PinyUtil;
import com.util.UUIDUtil;
import com.util.dict.DictEnumUtil;
import com.util.dict.DictFillUtil;
import com.util.dict.DictListUtil;
import com.util.page.PageInfo;
import com.util.page.PageResult;
import com.util.page.PageUtil;

/**
 * 字典基本信息Service
 * @author QingLong
 */
@Service("dictInfoService")
public class DictInfoServiceImpl implements IDictInfoService{
	
	Logger logger = Logger.getLogger(DictInfoServiceImpl.class);
	
	@Resource
	private DictTypeMapper dictTypeMapper;
	@Resource
	private DictInfoMapper dictInfoMapper;
	@Resource
	private DictListUtil dictListUtil;
	@Resource
	private DictFillUtil dictFillUtil;
	
	/**
	 * 保存字典基本信息
	 * @param dictInfo
	 * @throws Exception
	 */
	@Override
	public void insert(DictInfo dictInfo) throws Exception {
		if (null != dictInfo) {
			//生成主键
			if (StringUtils.isBlank(dictInfo.getDictId())) {
				dictInfo.setDictId(UUIDUtil.getUUID());
			}
			//字典首拼
			if (StringUtils.isBlank(dictInfo.getDictPiny())) {
				dictInfo.setDictPiny(PinyUtil.getTersePinyin(dictInfo.getDictName(), false));
			}
			//启停标志
			if (StringUtils.isBlank(dictInfo.getEnableStatus())) {
				dictInfo.setEnableStatus(DictEnumUtil.ENABLE_STATUS_YQY); //已启用
			}
			//创建时间
			if (StringUtils.isBlank(dictInfo.getCreateTime())) {
				dictInfo.setCreateTime(DateUtil.getDate(DateUtil.yyyy_MM_dd_HH_mm_ss));
			}
			//保存字典
			dictInfoMapper.insert(dictInfo);
			//重置缓存
			String dictCode = dictInfo.getDictCode();
			if (StringUtils.isNotBlank(dictCode)) {
				String typeCode = dictCode.substring(0,dictCode.indexOf("-"));
				dictListUtil.putList(typeCode);
			}
		}
	}
	
	/**
	 * 删除字典基本信息(通过字典主键)
	 * @param dictId
	 * @throws Exception
	 */
	@Override
	public void deleteByDictId(String dictId) throws Exception {
		if (StringUtils.isBlank(dictId)) {
			return;
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("dictId", dictId);
		map.put("redactSymbol", DictEnumUtil.REDACT_SYMBOL_YX);
		DictInfo dictInfo = dictInfoMapper.selectByDictId(map);
		if (null != dictInfo) {
			//删除字典
			dictInfoMapper.deleteByDictId(dictId);
			//重置缓存
			String dictCode = dictInfo.getDictCode();
			if (StringUtils.isNotBlank(dictCode)) {
				String typeCode = dictCode.substring(0,dictCode.indexOf("-"));
				dictListUtil.putList(typeCode);
			}
		}
	}
	
	/**
	 * 删除字典基本信息(通过类型编号)
	 * @param typeId 类型编号
	 * @throws Exception
	 */
	@Override
	public void deleteByTypeId(String typeId) throws Exception {
		if (StringUtils.isBlank(typeId)) {
			return;
		}
		DictType dictType = dictTypeMapper.selectByTypeId(typeId);
		if (null != dictType) {
			//删除字典
			dictInfoMapper.deleteByTypeId(typeId);
			//重置缓存
			String typeCode = dictType.getTypeCode();
			if (StringUtils.isNotBlank(typeCode)) {
				dictListUtil.putList(typeCode);
			}
		}
	}
	
	/**
	 * 删除字典基本信息(通过字典编号)
	 * @param dictCode 字典编号
	 * @throws Exception
	 */
	@Override
	public void deleteByDictCode(String dictCode) throws Exception {
		if (StringUtils.isBlank(dictCode)) {
			return;
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("dictCode", dictCode);
		map.put("redactSymbol", DictEnumUtil.REDACT_SYMBOL_YX);
		DictInfo dictInfo = dictInfoMapper.selectByDictCode(map);
		if (null != dictInfo) {
			//删除字典
			dictInfoMapper.deleteByDictCode(dictCode);
			//重置缓存
			String typeCode = dictCode.substring(0, dictCode.indexOf("-"));
			dictListUtil.putList(typeCode);
		}
	}
	
	/**
	 * 删除字典基本信息(通过类型编号)
	 * @param typeCode 类型编号
	 * @throws Exception
	 */
	@Override
	public void deleteByTypeCode(String typeCode) throws Exception {
		if (StringUtils.isBlank(typeCode)) {
			return;
		}
		DictType dictType = dictTypeMapper.selectByTypeCode(typeCode);
		if (null != dictType) {
			//删除字典
			dictInfoMapper.deleteByTypeCode(typeCode);
			//重置缓存
			dictListUtil.putList(typeCode);
		}
	}
	
	/**
	 * 更新字典基本信息
	 * @param dictInfo
	 * @throws Exception
	 */
	@Override
	public void updateByDictIdSelective(DictInfo dictInfo) throws Exception {
		if (null != dictInfo
				&& StringUtils.isNotBlank(dictInfo.getDictId())
				&& StringUtils.isNotBlank(dictInfo.getDictCode())) {
			//转换拼音
			if (StringUtils.isBlank(dictInfo.getDictPiny())) {
				dictInfo.setDictPiny(PinyUtil.getTersePinyin(dictInfo.getDictName(), false));
			}
			//启停标志
			if (StringUtils.isBlank(dictInfo.getEnableStatus())) {
				dictInfo.setEnableStatus(DictEnumUtil.ENABLE_STATUS_YQY); //已启用
			}
			//更新时间
			if (StringUtils.isBlank(dictInfo.getUpdateTime())) {
				dictInfo.setUpdateTime(DateUtil.getDate(DateUtil.yyyy_MM_dd_HH_mm_ss));
			}
			dictInfoMapper.updateByDictIdSelective(dictInfo);
			//重置缓存
			String dictCode = dictInfo.getDictCode();
			if (StringUtils.isNotBlank(dictCode)) {
				String typeCode = dictCode.substring(0,dictCode.indexOf("-"));
				dictListUtil.putList(typeCode);
			}
		}
	}
	
	/**
	 * 查询字典基本信息
	 * @param dictInfo
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<DictInfo> select(DictInfo dictInfo) throws Exception {
		List<DictInfo> dictInfoList = dictInfoMapper.select(dictInfo);
		return dictInfoList;
	}
	
	/**
	 * 查询字典基本信息(通过类型主键)
	 * @param typeId
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<DictInfo> selectByTypeId(String typeId) throws Exception {
		if (StringUtils.isBlank(typeId)) {
			return null;
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("typeId", typeId);
		map.put("enableStatus", DictEnumUtil.ENABLE_STATUS_YQY);
		List<DictInfo> dictInfoList = dictInfoMapper.selectByTypeId(map);
		return dictInfoList;
	}
	
	/**
	 * 查询字典基本信息(通过字典主键)
	 * @param dictId
	 * @return
	 * @throws Exception
	 */
	@Override
	public DictInfo selectByDictId(String dictId) throws Exception {
		if (StringUtils.isBlank(dictId)) {
			return null;
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("dictId", dictId);
		map.put("enableStatus", DictEnumUtil.ENABLE_STATUS_YQY);
		DictInfo dictInfo = dictInfoMapper.selectByDictId(map);
		return dictInfo;
	}
	
	/**
	 * 查询字典基本信息(通过类型编号)
	 * @param typeCode
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<DictInfo> selectByTypeCode(String typeCode) throws Exception {
		if (StringUtils.isBlank(typeCode)) {
			return null;
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("typeCode", typeCode);
		map.put("enableStatus", DictEnumUtil.ENABLE_STATUS_YQY);
		List<DictInfo> dictInfoList = dictInfoMapper.selectByTypeCode(map);
		return dictInfoList;
	}
	
	/**
	 * 查询字典基本信息(通过字典编号)
	 * @param dictCode
	 * @return
	 * @throws Exception
	 */
	@Override
	public DictInfo selectByDictCode(String dictCode) throws Exception {
		if (StringUtils.isBlank(dictCode)) {
			return null;
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("dictCode", dictCode);
		map.put("enableStatus", DictEnumUtil.ENABLE_STATUS_YQY);
		DictInfo dictInfo = dictInfoMapper.selectByDictCode(map);
		return dictInfo;
	}
	
	/**
	 * 查询字典信息数量
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public Integer searchSize(Map<String, Object> map) throws Exception {
		return dictInfoMapper.searchSize(map);
	}
	
	/**
	 * 查询字典信息列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<DictInfo> searchList(Map<String, Object> map) throws Exception {
		return dictInfoMapper.searchList(map);
	}
	
	/**
	 * 查询字典信息分页
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageResult searchPage(Map<String,Object> map) throws Exception {
		Object ep = map.get("ep"); //每页数量
		Integer everyPage = ((ep == null || ep == "") ? Integer.valueOf(DictEnumUtil.DEFAULT_EVERYPAGE) : Integer.valueOf(String.valueOf(ep)));
		Object cn = map.get("cn"); //当前页码
		Integer currentNo = ((cn == null || cn == "") ? 1 : Integer.valueOf(String.valueOf(cn)));
		//总记录数
		Integer size = dictInfoMapper.searchSize(map);
		PageInfo pageInfo = PageUtil.createPage(everyPage, currentNo, size); //分页实体
		map.put("page", pageInfo);
		List<DictInfo> dictInfoList = null;//返回集合
		if (size != null && size > 0) {
			dictInfoList = dictInfoMapper.searchList(map);
		}
		return new PageResult (pageInfo, dictInfoList);
	}
}