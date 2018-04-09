package com.util.qy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.model.AreaInfo;
import com.service.IAreaInfoService;
import com.util.dict.DictEnumUtil;
import com.util.dict.DictFillUtil;
import com.util.page.PageInfo;
import com.util.page.PageUtil;

/**
 * 区域缓存工具
 * @author QingLong
 */
@Component
public class AreaListUtil {
	
	Logger logger = Logger.getLogger(AreaListUtil.class);
	
	@Resource
	private Cache areaInfoCache;
	@Resource
	private IAreaInfoService areaInfoService;
	@Resource
	private DictFillUtil dictFillUtil;
	
	/**
	 * 缓存区域集合
	 * @throws Exception
	 */
	public void putList() throws Exception{
		//读取区域
		List<AreaInfo> areaInfoList = getData();
		//缓存区域
		putList(areaInfoList);
	}
	
	/**
	 * 缓存区域集合
	 * @param areaInfoList
	 * @throws Exception
	 */
	public void putList(List<AreaInfo> areaInfoList) throws Exception{
		if (CollectionUtils.isNotEmpty(areaInfoList)) {
			//重置缓存
			areaInfoCache.remove(DictEnumUtil.CACHE_AREA_INFO);
			//缓存集合
			Element areaInfoElement = new Element(DictEnumUtil.CACHE_AREA_INFO, areaInfoList);
			areaInfoCache.put(areaInfoElement);
		}
	}
	
	/**
	 * 返回区域集合
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public List<AreaInfo> getList() throws Exception{
		//从缓存中读取
		Element areaInfoElement = areaInfoCache.get(DictEnumUtil.CACHE_AREA_INFO);
		List<AreaInfo> areaInfoList = null;
		if (null != areaInfoElement) {
			areaInfoList = (List<AreaInfo>) areaInfoElement.getObjectValue();
			if (CollectionUtils.isEmpty(areaInfoList)) {
				//从数据库读取
				areaInfoList = getData();
				putList(areaInfoList); //缓存字典集合
			}
		} else {
			//从数据库读取
			areaInfoList = getData();
			putList(areaInfoList); //缓存字典集合
		}
		return areaInfoList;
	}
	
	/**
	 * 返回数据库区域集合
	 * @throws Exception
	 */
	private List<AreaInfo> getData() throws Exception {
		//从数据库读取
		logger.info("------------------开始从数据库读取区域信息----------------------");
		List<AreaInfo> areaInfoList = new ArrayList<AreaInfo>(); //返回集合
		Integer size = areaInfoService.searchSize(null); //总记录数
		if (size > 0) {
			int everyPage = 2000;
			PageInfo pageInfo = PageUtil.createPage(everyPage, 0, size); //分页实体
			for (int i=0;i<pageInfo.getTotalPage();i++) {
				Map<String,Object> map = new HashMap<String,Object>();
				pageInfo = PageUtil.createPage(everyPage, i + 1, size); //分页实体
				map.put("page", pageInfo);
				List<AreaInfo> tempInfoList = areaInfoService.searchList(map);
				if (CollectionUtils.isNotEmpty(tempInfoList)) { //填充字典
					for (AreaInfo tempInfo : tempInfoList) {
						dictFillUtil.fillDictInfoOfModel(tempInfo);
					}
				}
				areaInfoList.addAll(tempInfoList); //追加集合
			}
		}
		logger.info("------------------结束从数据库读取区域信息----------------------");
		return areaInfoList;
	}
	
	/**
	 * 填充区域信息
	 * @param areaInfo
	 * @throws Exception
	 */
	public void setAreaInfo(AreaInfo areaInfo) throws Exception {
		if (null == areaInfo || StringUtils.isBlank(areaInfo.getAreaId())) {
			return;
		}
		AreaInfo temp = getAreaInfo(areaInfo.getAreaId());
		if (null != temp) {
			//标准属性
			areaInfo.setAreaId(temp.getAreaId());
			areaInfo.setPrevId(temp.getPrevId());
			areaInfo.setAreaCode(temp.getAreaCode());
			areaInfo.setAreaType(temp.getAreaType());
			areaInfo.setAreaName(temp.getAreaName());
			areaInfo.setAreaPiny(temp.getAreaPiny());
			areaInfo.setAreaRank(temp.getAreaRank());
			areaInfo.setAreaSort(temp.getAreaSort());
			areaInfo.setSubsetSymbol(temp.getSubsetSymbol());
			areaInfo.setEnableStatus(temp.getEnableStatus());
			areaInfo.setDeleteStatus(temp.getDeleteStatus());
			areaInfo.setCreateTime(temp.getCreateTime());
			areaInfo.setCreateId(temp.getCreateId());
			areaInfo.setUpdateTime(temp.getUpdateTime());
			areaInfo.setUpdateId(temp.getUpdateId());
			//逻辑属性
			areaInfo.setFullName(getFullName(temp.getAreaId()));
		}
	}
	
	/**
	 * 返回区域信息
	 * @param areaId
	 * @return
	 * @throws Exception
	 */
	public AreaInfo getAreaInfo(String areaId) throws Exception {
		if (StringUtils.isBlank(areaId)) {
			return null;
		}
		List<AreaInfo> areaInfoList = getList(); //返回缓存中区域集合
		if (CollectionUtils.isNotEmpty(areaInfoList)) {
			for (AreaInfo areaInfo : areaInfoList) {
				if (areaId.equals(areaInfo.getAreaId())) {
					return areaInfo;
				}
			}
		}
		return null;
	}
	
	/**
	 * 返回父级子级
	 * @param areaId
	 * @return
	 * @throws Exception
	 */
	public List<AreaInfo> getPrevRank(String areaId) throws Exception {
		if (StringUtils.isBlank(areaId)) {
			return null;
		}
		AreaInfo prevArea = this.getPrevArea(areaId);
		if (null != prevArea) {
			return this.getRankArea(prevArea.getAreaId());
		} else {
			AreaInfo areaInfo = this.getAreaInfo(areaId);
			List<AreaInfo> areaInfoList = new ArrayList<AreaInfo>();
			areaInfoList.add(areaInfo);
			return areaInfoList;
		}
	}
	
	/**
	 * 返回父级区域
	 * @param areaId
	 * @return
	 * @throws Exception
	 */
	public AreaInfo getPrevArea(String areaId) throws Exception {
		if (StringUtils.isBlank(areaId)) {
			return null;
		}
		List<AreaInfo> areaInfoList = getList(); //返回缓存中区域集合
		if (CollectionUtils.isEmpty(areaInfoList)) {
			return null;
		}
		AreaInfo areaInfo = getAreaInfo(areaId); //当前区域
		if (null != areaInfo && StringUtils.isNotBlank(areaInfo.getAreaId())) {
			for (AreaInfo prevArea : areaInfoList) {
				if (null != prevArea
						&& StringUtils.isNotBlank(prevArea.getAreaId())
						&& prevArea.getAreaId().equals(areaInfo.getPrevId())) {
					return prevArea;
				}
			}
		}
		return null;
	}
	
	/**
	 * 返回父级区域
	 * @param areaId
	 * @throws Exception
	 */
	public List<AreaInfo> getPrevList(String areaId) throws Exception {
		List<AreaInfo> areaListList = new ArrayList<AreaInfo>();
		getPrevList(areaId, areaListList);
		Collections.sort(areaListList, new Comparator<AreaInfo>() { //重新排序
			@Override
			public int compare(AreaInfo a1, AreaInfo a2) {
				return a1.getAreaRank() - a2.getAreaRank();
			}
		});
		return areaListList;
	}
	
	/**
	 * 返回父级区域
	 * @param areaId
	 * @param shutId
	 * @throws Exception
	 */
	public List<AreaInfo> getPrevList(String areaId, String shutId) throws Exception {
		List<AreaInfo> areaListList = new ArrayList<AreaInfo>();
		getPrevList(areaId, shutId, areaListList);
		Collections.sort(areaListList, new Comparator<AreaInfo>() { //重新排序
			@Override
			public int compare(AreaInfo a1, AreaInfo a2) {
				return a1.getAreaRank() - a2.getAreaRank();
			}
		});
		return areaListList;
	}
	
	/**
	 * 返回父级区域
	 * @param areaId
	 * @param areaListList
	 * @throws Exception
	 */
	private void getPrevList(String areaId, List<AreaInfo> areaListList) throws Exception {
		AreaInfo prevArea = this.getPrevArea(areaId); //父级区域
		if (null != prevArea) {
			areaListList.add(prevArea);
			if (StringUtils.isNotBlank(prevArea.getPrevId())) {
				this.getPrevList(prevArea.getAreaId(), areaListList);
			}
		}
	}
	
	/**
	 * 返回父级区域
	 * @param areaId
	 * @param shutId
	 * @param areaListList
	 * @throws Exception
	 */
	private void getPrevList(String areaId, String shutId, List<AreaInfo> areaListList) throws Exception {
		if (StringUtils.isNotBlank(shutId)
				&& areaId.equals(shutId)) { //截止区域
			return;
		}
		AreaInfo prevArea = this.getPrevArea(areaId); //父级区域
		if (null != prevArea) {
			areaListList.add(prevArea);
			if (StringUtils.isNotBlank(prevArea.getPrevId())) {
				this.getPrevList(prevArea.getAreaId(), shutId, areaListList);
			}
		}
	}
	
	/**
	 * 返回父级树状
	 * @param areaId
	 * @param shutId
	 * @return
	 * @throws Exception
	 */
	public List<List<AreaInfo>> getPrevTree(String areaId, String shutId) throws Exception {
		if (StringUtils.isBlank(areaId)
				|| !areaId.startsWith(shutId)) {
			return null;
		}
		List<List<AreaInfo>> areaListList = new ArrayList<List<AreaInfo>>();
		List<AreaInfo> areaInfoList = new ArrayList<AreaInfo>();
		areaInfoList.add(getAreaInfo(shutId));
		areaListList.add(areaInfoList);
		List<AreaInfo> prevAreaList = new ArrayList<AreaInfo>();
		this.getPrevList(areaId, shutId, prevAreaList); //返回父级区域
		if (CollectionUtils.isNotEmpty(prevAreaList)) {
			Collections.sort(prevAreaList, new Comparator<AreaInfo>() { //重新排序
				@Override
				public int compare(AreaInfo a1, AreaInfo a2) {
					return a1.getAreaRank() - a2.getAreaRank();
				}
			});
			for (AreaInfo areaInfo : prevAreaList) {
				List<AreaInfo> rankAreaList = getRankArea(areaInfo.getAreaId());
				if (CollectionUtils.isNotEmpty(rankAreaList)) {
					areaListList.add(rankAreaList);
				}
			}
		} else {
			areaInfoList = new ArrayList<AreaInfo>();
			areaInfoList.add(getAreaInfo(areaId));
			areaListList.add(areaInfoList);
		}
		List<AreaInfo> rankAreaList = getRankArea(areaId);
		if (CollectionUtils.isNotEmpty(rankAreaList)) {
			areaListList.add(rankAreaList);
		}
		return areaListList;
	}
	
	/**
	 * 返回下级区域
	 * @param areaId
	 * @return
	 * @throws Exception
	 */
	public List<AreaInfo> getRankArea(String areaId) throws Exception {
		if (StringUtils.isBlank(areaId)) {
			return null;
		}
		List<AreaInfo> areaInfoList = getList(); //返回缓存中区域集合
		if (CollectionUtils.isEmpty(areaInfoList)) {
			return null;
		}
		AreaInfo prevArea = getAreaInfo(areaId); //当前区域
		if (null != prevArea) {
			List<AreaInfo> needAreaList = new ArrayList<AreaInfo>();
			for (AreaInfo areaInfo : areaInfoList) {
				if (null != areaInfo
						&& StringUtils.isNotBlank(areaInfo.getPrevId())
						&& areaInfo.getPrevId().equals(prevArea.getAreaId())) {
					needAreaList.add(areaInfo);
				}
			}
			return needAreaList;
		}
		return null;
	}
	
	/**
	 * 返回下级区域
	 * @param areaId
	 * @throws Exception
	 */
	public List<AreaInfo> getRankList(String areaId) throws Exception {
		List<AreaInfo> areaListList = new ArrayList<AreaInfo>();
		getRankList(areaId, areaListList);
		return areaListList;
	}
	
	/**
	 * 迭代下级区域
	 * @param areaId
	 * @param areaListList
	 * @throws Exception
	 */
	private void getRankList(String areaId, List<AreaInfo> areaListList) throws Exception {
		List<AreaInfo> rankAreaList = this.getRankArea(areaId);
		if (CollectionUtils.isNotEmpty(rankAreaList)) {
			for (AreaInfo areaInfo : rankAreaList) {
				areaListList.add(areaInfo);
				List<AreaInfo> nextAreaList = this.getRankArea(areaInfo.getAreaId());
				if (CollectionUtils.isNotEmpty(nextAreaList)) {
					this.getRankList(areaInfo.getAreaId(), areaListList);
				}
			}
		}
	}
	
	/**
	 * 返回区域全名
	 * @param areaId
	 * @return
	 * @throws Exception
	 */
	public String getFullName(String areaId) throws Exception {
		if (StringUtils.isBlank(areaId)) {
			throw new Exception("区域主键为空");
		}
		List<AreaInfo> areaInfoList = getPrevList(areaId);
		if (CollectionUtils.isNotEmpty(areaInfoList)) {
			StringBuilder sb = new StringBuilder();
			for (AreaInfo areaInfo : areaInfoList) {
				sb.append(areaInfo.getAreaName());
				sb.append("  ");
			}
			if (null != sb) {
				sb.append(getAreaInfo(areaId).getAreaName());
				return sb.toString();
			}
		}
		return getAreaInfo(areaId).getAreaName();
	}
	
	/**
	 * 是否父级区域
	 * @param prevId 父级主键
	 * @param areaId 下级主键
	 * @return
	 * @throws Exception
	 */
	public Boolean isPrev(String prevId, String areaId) throws Exception {
		if (StringUtils.isBlank(prevId)
				|| StringUtils.isBlank(areaId)) {
			return false;
		}
		List<AreaInfo> prevAreaList = getPrevList(areaId);
		if (CollectionUtils.isNotEmpty(prevAreaList)) {
			for (AreaInfo prevArea : prevAreaList) {
				if (prevId.equals(prevArea.getAreaId())) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 是否下级区域
	 * @param areaId 父级主键
	 * @param rankId 下级主键
	 * @return
	 * @throws Exception
	 */
	public Boolean isRank(String areaId, String rankId) throws Exception {
		if (StringUtils.isBlank(areaId)
				|| StringUtils.isBlank(rankId)) {
			return false;
		}
		List<AreaInfo> prevAreaList = getPrevList(rankId);
		if (CollectionUtils.isNotEmpty(prevAreaList)) {
			for (AreaInfo prevArea : prevAreaList) {
				if (areaId.equals(prevArea.getAreaId())) {
					return true;
				}
			}
		}
		return false;
	}
}