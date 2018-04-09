package com.util.dict;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.annotation.Resource;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.model.DictInfo;
import com.service.IDictInfoService;

/**
 * 字典缓存工具
 * @author QingLong
 */
@Component
public class DictListUtil {
	
	Logger logger = Logger.getLogger(DictListUtil.class);
	
	@Resource
	private Cache dictInfoCache;
	@Resource
	private IDictInfoService dictInfoService;
	
	/**
	 * 缓存字典集合
	 * @throws Exception
	 */
	public void putList() throws Exception{
		//从数据库读取字典
		List<DictInfo> dictInfoList = getData();
		//整理字典信息类型
		List<String> dictTypeList = new ArrayList<String>();
		if (CollectionUtils.isNotEmpty(dictInfoList)) {
			for (DictInfo dictInfo : dictInfoList) {
				if (null != dictInfo.getDictType() && StringUtils.isNotBlank(dictInfo.getDictType().getTypeCode())) {
					String typeCode = dictInfo.getDictType().getTypeCode();
					if (!dictTypeList.contains(typeCode)) {
						dictTypeList.add(typeCode);
					}
				}
			}
		}
		if (CollectionUtils.isNotEmpty(dictTypeList)) {
			for (String typeCode : dictTypeList) {
				//删除缓存
				Element element = dictInfoCache.get(DictEnumUtil.CACHE_DICT_INFO + "_" + typeCode);
				if (null != element) {
					dictInfoCache.remove(DictEnumUtil.CACHE_DICT_INFO + "_" + typeCode);
				}
				putList(typeCode, filterDictInfoByTypeCode(dictInfoList, typeCode)); //缓存字典
			}
		}
	}
	
	/**
	 * 缓存字典集合
	 * @param typeCode
	 * @throws Exception 
	 */
	public void putList(String typeCode) throws Exception{
		if (StringUtils.isBlank(typeCode)) {
			return;
		}
		//从数据库读取
		List<DictInfo> dictInfoList = getData(typeCode);
		if (CollectionUtils.isEmpty(dictInfoList)) {
			throw new Exception("返回字典集合为空");
		}
		putList(typeCode, dictInfoList); //存入缓存
	}
	
	/**
	 * 缓存字典集合
	 * @param typeCode
	 * @param dictInfoList
	 * @throws Exception
	 */
	public void putList(String typeCode, List<DictInfo> dictInfoList) throws Exception{
		if (StringUtils.isBlank(typeCode)) {
			if (CollectionUtils.isNotEmpty(dictInfoList)) {
				DictInfo dictInfo = dictInfoList.get(0);
				if (null != dictInfo.getDictType()) {
					typeCode = dictInfo.getDictType().getTypeCode();
				}
			}
			if (StringUtils.isBlank(typeCode)) {
				throw new Exception("提取类型编号为空");
			}
		}
		Element element = new Element(DictEnumUtil.CACHE_DICT_INFO + "_" + typeCode, dictInfoList);
		dictInfoCache.put(element);
	}
	
	/**
	 * 返回字典集合
	 * @param typeCode
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public List<DictInfo> getList(String typeCode) throws Exception{
		if (StringUtils.isBlank(typeCode)) {
			throw new Exception("返回类型编号为空");
		}
		//从缓存中读取
		Element element = dictInfoCache.get(DictEnumUtil.CACHE_DICT_INFO + "_" + typeCode);
		List<DictInfo> dictInfoList = null;
		if (null != element) {
			dictInfoList = (List<DictInfo>) element.getObjectValue();
			if (CollectionUtils.isEmpty(dictInfoList)) {
				//从数据库读取
				dictInfoList = getData(typeCode);
			}
		} else {
			//从数据库读取
			dictInfoList = getData(typeCode);
		}
 		putList(typeCode, dictInfoList); //缓存字典集合
		return dictInfoList;
	}
	
	/**
	 * 返回数据库字典集合
	 * @throws Exception 
	 */
	private List<DictInfo> getData() throws Exception {
		return getData(null);
	}
	
	/**
	 * 返回数据库字典集合
	 * @param typeCode
	 * @throws Exception 
	 */
	private List<DictInfo> getData(String typeCode) throws Exception {
		//从数据库读取
		logger.info("------------------开始从数据库读取字典信息("+typeCode+")----------------------");
		//注意此处只加载启动标志表示已经启动了的字典
		List<DictInfo> dictInfoList = dictInfoService.selectByTypeCode(typeCode);
		logger.info("------------------结束从数据库读取字典信息----------------------");
		return dictInfoList;
	}
	
	/**
	 * 过滤字典集合
	 * @param dictInfoList 字典集合
	 * @param typeCaty 类型类别
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unused")
	private List<DictInfo> filterDictInfoByTypeSpot(List<DictInfo> dictInfoList, String typeCaty) throws Exception {
		if (CollectionUtils.isEmpty(dictInfoList)) {
			return null;
		}
		if (StringUtils.isBlank(typeCaty)) {
			return null;
		}
		List<DictInfo> resultList = new ArrayList<DictInfo>();
		for (DictInfo dictInfo : dictInfoList) {
			if (null != dictInfo.getDictType() && StringUtils.isNotBlank(dictInfo.getDictType().getTypeSpot())) {
				if (typeCaty.equals(dictInfo.getDictType().getTypeSpot())) {
					resultList.add(dictInfo);
				}
			}
		}
		return resultList;
	}
	
	/**
	 * 过滤字典集合
	 * @param dictInfoList 字典集合
	 * @param typeCode 类型编号
	 * @return
	 * @throws Exception 
	 */
	private List<DictInfo> filterDictInfoByTypeCode(List<DictInfo> dictInfoList, String typeCode) throws Exception {
		if (CollectionUtils.isEmpty(dictInfoList)) {
			return null;
		}
		if (StringUtils.isBlank(typeCode)) {
			return null;
		}
		List<DictInfo> resultList = new ArrayList<DictInfo>();
		for (DictInfo dictInfo : dictInfoList) {
			if (null != dictInfo.getDictType() && typeCode.equals(dictInfo.getDictType().getTypeCode())) {
				resultList.add(dictInfo);
			}
		}
		return resultList;
	}
	
	/**
	 * 填充字典内容
	 * @param typeCode
	 * @param dictInfo
	 * @throws Exception 
	 */
	public void setDictInfo(String typeCode, DictInfo dictInfo) throws Exception {
		if (StringUtils.isBlank(typeCode) || dictInfo == null) {
			return;
		}
		DictInfo temp = getDictInfo(typeCode, dictInfo.getDictCode());
		if (null != temp) {
			dictInfo.setDictId(temp.getDictId()); //字典主键
			dictInfo.setDictType(temp.getDictType()); //字典类型
			dictInfo.setDictName(temp.getDictName()); //字典名称
			dictInfo.setDictPiny(temp.getDictPiny()); //字典拼音
			dictInfo.setDictSort(temp.getDictSort()); //字典排序
			dictInfo.setDictDesc(temp.getDictDesc()); //字典描述
			dictInfo.setRedactSymbol(temp.getRedactSymbol()); //编辑标志
			dictInfo.setEnableStatus(temp.getEnableStatus()); //启用标志
			dictInfo.setDeleteStatus(temp.getDeleteStatus()); //删除标志
			dictInfo.setCreateTime(temp.getCreateTime()); //创建时间
			dictInfo.setCreateId(temp.getCreateId()); //创建人员
			dictInfo.setUpdateTime(temp.getUpdateTime()); //更新时间
			dictInfo.setUpdateId(temp.getUpdateId()); //更新人员
			dictInfo.setDictType(temp.getDictType()); //字典类型
		}
	}
	
	/**
	 * 填充字典信息
	 * @param dictInfo
	 * @throws Exception 
	 */
	public void setDictInfo(DictInfo dictInfo) throws Exception {
		if (null == dictInfo || StringUtils.isBlank(dictInfo.getDictCode())) {
			return;
		}
		String dictCode = dictInfo.getDictCode();
		if (dictCode.indexOf("-") < 0) {
			return;
		}
		String typeCode = dictCode.substring(0,dictCode.indexOf("-"));
		this.setDictInfo(typeCode, dictInfo);
	}
	
	/**
	 * 返回字典信息
	 * @param typeCode
	 * @param dictCode
	 * @return
	 * @throws Exception 
	 */
	public DictInfo getDictInfo(String typeCode, String dictCode) throws Exception {
		if (StringUtils.isBlank(dictCode)) {
			return null;
		}
		List<DictInfo> dictInfoList = getList(typeCode); //返回缓存中字典集合
		if (CollectionUtils.isNotEmpty(dictInfoList)) {
			for (DictInfo dictInfo : dictInfoList) {
				if (dictCode.equals(dictInfo.getDictCode())) {
					return dictInfo;
				}
			}
		}
		return null;
	}
	
	/**
	 * 返回字典信息
	 * @param typeCode
	 * @param dictCode
	 * @return
	 * @throws Exception 
	 */
	public DictInfo getDictInfo(String dictCode) throws Exception {
		if (StringUtils.isBlank(dictCode) || dictCode.indexOf("-") < 0) {
			return null;
		}
		List<DictInfo> dictInfoList = getList(dictCode.substring(0,dictCode.indexOf("-"))); //返回缓存中字典集合
		if (CollectionUtils.isNotEmpty(dictInfoList)) {
			for (DictInfo dictInfo : dictInfoList) {
				if (dictCode.equals(dictInfo.getDictCode())) {
					return dictInfo;
				}
			}
		}
		return null;
	}
	
	/**
	 * 返回字典文本
	 * @param codeList
	 * @return
	 * @throws Exception 
	 */
	public String getDictText(String codeList) throws Exception {
		if (StringUtils.isBlank(codeList)) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(codeList, ",");
		while (st.hasMoreTokens()) {
			DictInfo dictInfo = getDictInfo(st.nextToken());
			if (null != dictInfo) {
				sb.append("、");
				sb.append(dictInfo.getDictName());
			}
		}
		return sb.toString().substring(1);
	}
}