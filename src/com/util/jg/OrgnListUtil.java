package com.util.jg;

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

import com.model.OrgnInfo;
import com.model.TreeInfo;
import com.service.IOrgnInfoService;
import com.util.dict.DictEnumUtil;
import com.util.dict.DictFillUtil;
import com.util.page.PageInfo;
import com.util.page.PageUtil;

/**
 * 机构缓存工具
 * @author QingLong
 */
@Component
public class OrgnListUtil {
	
	Logger logger = Logger.getLogger(OrgnListUtil.class);
	
	@Resource
	private Cache orgnInfoCache;
	@Resource
	private DictFillUtil dictFillUtil;
	@Resource
	private IOrgnInfoService orgnInfoService;
	
	/**
	 * 缓存组织机构
	 * @throws Exception
	 */
	public void putList() throws Exception {
		//删除缓存
		Element element = orgnInfoCache.get(DictEnumUtil.CACHE_ORGN_INFO);
		if (null != element) {
			orgnInfoCache.remove(DictEnumUtil.CACHE_ORGN_INFO);
		}
		//读取机构
		List<OrgnInfo> orgnInfoList = getData();
		//缓存机构
		putList(orgnInfoList);
	}
	
	/**
	 * 缓存组织机构
	 * @param orgnInfoList
	 * @throws Exception
	 */
	public void putList(List<OrgnInfo> orgnInfoList) throws Exception {
		if (CollectionUtils.isNotEmpty(orgnInfoList)) {
			Element element = new Element(DictEnumUtil.CACHE_ORGN_INFO, orgnInfoList);
			orgnInfoCache.put(element);
		}
	}
	
	/**
	 * 返回组织机构
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public List<OrgnInfo> getList() throws Exception {
		//从缓存中读取
		Element element = orgnInfoCache.get(DictEnumUtil.CACHE_ORGN_INFO);
		List<OrgnInfo> orgnInfoList = null;
		if (null != element) {
			orgnInfoList = (List<OrgnInfo>) element.getObjectValue();
			if (CollectionUtils.isEmpty(orgnInfoList)) {
				//从数据库读取
				orgnInfoList = getData();
				putList(orgnInfoList); //缓存组织机构
			}
		} else {
			//从数据库读取
			orgnInfoList = getData();
			putList(orgnInfoList); //缓存组织机构
		}
		return orgnInfoList;
	}
	
	/**
	 * 返回数据库组织机构
	 * @return
	 * @throws Exception
	 */
	private List<OrgnInfo> getData() throws Exception {
		//从数据库读取
		logger.info("------------------开始从数据库读取机构信息----------------------");
		List<OrgnInfo> orgnInfoList = new ArrayList<OrgnInfo>(); //返回集合
		Integer size = orgnInfoService.searchSize(null); //总记录数
		if (size > 0) {
			int everyPage = 2000;
			PageInfo pageInfo = PageUtil.createPage(everyPage, 0, size); //分页实体
			for (int i=0;i<pageInfo.getTotalPage();i++) {
				Map<String, Object> paramMap = new HashMap<String, Object>();
				pageInfo = PageUtil.createPage(everyPage, i + 1, size); //分页实体
				paramMap.put("page", pageInfo);
				paramMap.put("enableStatus", DictEnumUtil.ENABLE_STATUS_YQY); //启用状态(已启用)
				paramMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC); //删除状态(未删除)
				List<OrgnInfo> tempInfoList = orgnInfoService.searchList(paramMap);
				if (CollectionUtils.isNotEmpty(tempInfoList)) { //填充字典
					for (OrgnInfo tempInfo : tempInfoList) {
						dictFillUtil.fillDictInfoOfModel(tempInfo);
					}
				}
				orgnInfoList.addAll(tempInfoList); //追加集合
			}
		}
		logger.info("------------------结束从数据库读取机构信息----------------------");
		return orgnInfoList;
	}
	
	/**
	 * 填充机构信息
	 * @param orgnInfo
	 * @throws Exception
	 */
	public void setOrgnInfo(OrgnInfo orgnInfo) throws Exception {
		if (null == orgnInfo || StringUtils.isBlank(orgnInfo.getOrgnId())) {
			return;
		}
		OrgnInfo temp = getOrgnInfo(orgnInfo.getOrgnId());
		if (null != temp) {
			//标准属性
			orgnInfo.setOrgnId(temp.getOrgnId());
			orgnInfo.setPrevId(temp.getPrevId());
			orgnInfo.setAreaId(temp.getAreaId());
			orgnInfo.setOrgnCode(temp.getOrgnCode());
			orgnInfo.setOrgnType(temp.getOrgnType());
			orgnInfo.setOrgnName(temp.getOrgnName());
			orgnInfo.setOrgnPiny(temp.getOrgnPiny());
			orgnInfo.setOrgnRank(temp.getOrgnRank());
			orgnInfo.setOrgnSort(temp.getOrgnSort());
			orgnInfo.setOrgnNote(temp.getOrgnNote());
			orgnInfo.setSubsetSymbol(temp.getSubsetSymbol());
			orgnInfo.setRedactSymbol(temp.getRedactSymbol());
			orgnInfo.setEnableStatus(temp.getEnableStatus());
			orgnInfo.setDeleteStatus(temp.getDeleteStatus());
			orgnInfo.setCreateTime(temp.getCreateTime());
			orgnInfo.setCreateId(temp.getCreateId());
			orgnInfo.setUpdateTime(temp.getUpdateTime());
			orgnInfo.setUpdateId(temp.getUpdateId());
			//逻辑属性
			orgnInfo.setFullName(getFullName(temp.getOrgnId()));
		}
	}
	
	/**
	 * 返回机构信息
	 * @param orgnId
	 * @return
	 * @throws Exception
	 */
	public OrgnInfo getOrgnInfo(String orgnId) throws Exception {
		if (StringUtils.isBlank(orgnId)) {
			return null;
		}
		List<OrgnInfo> orgnInfoList = getList(); //返回缓存中组织机构
		if (CollectionUtils.isNotEmpty(orgnInfoList)) {
			for (OrgnInfo orgnInfo : orgnInfoList) {
				if (orgnId.equals(orgnInfo.getOrgnId())) {
					return orgnInfo;
				}
			}
		}
		return null;
	}
	
	/**
	 * 返回根级机构
	 * @return
	 * @throws Exception
	 */
	public List<OrgnInfo> getRootOrgn() throws Exception {
		List<OrgnInfo> rootOrgnList = new ArrayList<OrgnInfo>();
		List<OrgnInfo> orgnInfoList = getList(); //返回缓存中组织机构
		if (CollectionUtils.isEmpty(orgnInfoList)) {
			return null;
		}
		if (CollectionUtils.isNotEmpty(orgnInfoList)) {
			for (OrgnInfo orgnInfo : orgnInfoList) {
				if (StringUtils.isBlank(orgnInfo.getPrevId())) {
					rootOrgnList.add(orgnInfo);
				}
			}
		}
		return rootOrgnList;
	}
	
	/**
	 * 返回机构信息
	 * @param orgnInfo
	 * @return
	 * @throws Exception
	 */
	public TreeInfo getOrgnTree(OrgnInfo orgnInfo) throws Exception {
		TreeInfo orgnTree = new TreeInfo();
		orgnTree.setId(orgnInfo.getOrgnId());
		orgnTree.setpId(orgnInfo.getPrevId());
		orgnTree.setCode(orgnInfo.getOrgnCode());
		orgnTree.setName(orgnInfo.getOrgnName());
		orgnTree.setPiny(orgnInfo.getOrgnPiny());
		orgnTree.setSort(orgnInfo.getOrgnSort());
		orgnTree.setRank(orgnInfo.getOrgnRank());
		if (DictEnumUtil.SUBSET_SYMBOL_YYZJ.equals(orgnInfo.getSubsetSymbol())) { //拥有子级
			orgnTree.setIsParent(true); //父级
		} else {
			orgnTree.setIsParent(false); //子级
		}
		if (StringUtils.isBlank(orgnInfo.getPrevId())) { //根级机构
			orgnTree.setOpen(true);
		}
		return orgnTree;
	}
	
	/**
	 * 返回上级子级
	 * @param orgnId
	 * @return
	 * @throws Exception
	 */
	public List<OrgnInfo> getPrevRank(String orgnId) throws Exception {
		if (StringUtils.isBlank(orgnId)) {
			return null;
		}
		OrgnInfo prevOrgn = this.getPrevOrgn(orgnId);
		if (null != prevOrgn) {
			return this.getRankOrgn(prevOrgn.getOrgnId());
		} else {
			OrgnInfo orgnInfo = this.getOrgnInfo(orgnId);
			List<OrgnInfo> orgnInfoList = new ArrayList<OrgnInfo>();
			orgnInfoList.add(orgnInfo);
			return orgnInfoList;
		}
	}
	
	/**
	 * 返回上级机构
	 * @param orgnId
	 * @return
	 * @throws Exception
	 */
	public OrgnInfo getPrevOrgn(String orgnId) throws Exception {
		if (StringUtils.isBlank(orgnId)) {
			return null;
		}
		List<OrgnInfo> orgnInfoList = getList(); //返回缓存中组织机构
		if (CollectionUtils.isEmpty(orgnInfoList)) {
			return null;
		}
		OrgnInfo orgnInfo = getOrgnInfo(orgnId); //当前机构
		if (null != orgnInfo && StringUtils.isNotBlank(orgnInfo.getOrgnId())) {
			for (OrgnInfo prevOrgn : orgnInfoList) {
				if (null != prevOrgn
						&& StringUtils.isNotBlank(prevOrgn.getOrgnId())
						&& prevOrgn.getOrgnId().equals(orgnInfo.getPrevId())) {
					return prevOrgn;
				}
			}
		}
		return null;
	}
	
	/**
	 * 返回上级机构
	 * @param orgnId
	 * @throws Exception
	 */
	public List<OrgnInfo> getPrevList(String orgnId) throws Exception {
		List<OrgnInfo> orgnListList = new ArrayList<OrgnInfo>();
		getPrevList(orgnId, orgnListList);
		Collections.sort(orgnListList, new Comparator<OrgnInfo>() { //重新排序
			@Override
			public int compare(OrgnInfo a1, OrgnInfo a2) {
				return a1.getOrgnRank() - a2.getOrgnRank();
			}
		});
		return orgnListList;
	}
	
	/**
	 * 返回上级机构
	 * @param orgnId
	 * @param shutId
	 * @throws Exception
	 */
	public List<OrgnInfo> getPrevList(String orgnId, String shutId) throws Exception {
		List<OrgnInfo> orgnListList = new ArrayList<OrgnInfo>();
		getPrevList(orgnId, shutId, orgnListList);
		Collections.sort(orgnListList, new Comparator<OrgnInfo>() { //重新排序
			@Override
			public int compare(OrgnInfo a1, OrgnInfo a2) {
				return a1.getOrgnRank() - a2.getOrgnRank();
			}
		});
		return orgnListList;
	}
	
	/**
	 * 返回上级机构
	 * @param orgnId
	 * @param orgnListList
	 * @throws Exception
	 */
	private void getPrevList(String orgnId, List<OrgnInfo> orgnListList) throws Exception {
		OrgnInfo prevOrgn = this.getPrevOrgn(orgnId); //上级机构
		if (null != prevOrgn) {
			orgnListList.add(prevOrgn);
			if (StringUtils.isNotBlank(prevOrgn.getPrevId())) {
				this.getPrevList(prevOrgn.getOrgnId(), orgnListList);
			}
		}
	}
	
	/**
	 * 返回上级机构
	 * @param orgnId
	 * @param shutId
	 * @param orgnListList
	 * @throws Exception
	 */
	private void getPrevList(String orgnId, String shutId, List<OrgnInfo> orgnListList) throws Exception {
		if (StringUtils.isNotBlank(shutId)
				&& orgnId.equals(shutId)) { //截止机构
			return;
		}
		OrgnInfo prevOrgn = this.getPrevOrgn(orgnId); //上级机构
		if (null != prevOrgn) {
			orgnListList.add(prevOrgn);
			if (StringUtils.isNotBlank(prevOrgn.getPrevId())) {
				this.getPrevList(prevOrgn.getOrgnId(), shutId, orgnListList);
			}
		}
	}
	
	/**
	 * 返回上级树状
	 * @param orgnId
	 * @return
	 * @throws Exception
	 */
	public List<List<OrgnInfo>> getPrevTree(String orgnId) throws Exception {
		if (StringUtils.isBlank(orgnId)) {
			return null;
		}
		List<List<OrgnInfo>> orgnListList = new ArrayList<List<OrgnInfo>>();
		List<OrgnInfo> prevOrgnList = new ArrayList<OrgnInfo>();
		this.getPrevList(orgnId, prevOrgnList); //返回上级机构
		if (CollectionUtils.isNotEmpty(prevOrgnList)) {
			Collections.sort(prevOrgnList, new Comparator<OrgnInfo>() { //重新排序
				@Override
				public int compare(OrgnInfo a1, OrgnInfo a2) {
					return a1.getOrgnRank() - a2.getOrgnRank();
				}
			});
			for (OrgnInfo orgnInfo : prevOrgnList) {
				if (StringUtils.isBlank(orgnInfo.getPrevId())) {
					List<OrgnInfo> orgnInfoList = getRootOrgn();
					orgnListList.add(orgnInfoList);
				}
				List<OrgnInfo> rankOrgnList = getRankOrgn(orgnInfo.getOrgnId());
				if (CollectionUtils.isNotEmpty(rankOrgnList)) {
					orgnListList.add(rankOrgnList);
				}
			}
		} else {
			List<OrgnInfo> orgnInfoList = getRootOrgn();
			orgnListList.add(orgnInfoList);
		}
		List<OrgnInfo> rankOrgnList = getRankOrgn(orgnId);
		if (CollectionUtils.isNotEmpty(rankOrgnList)) {
			orgnListList.add(rankOrgnList);
		}
		return orgnListList;
	}
	
	/**
	 * 返回上级树状
	 * @param orgnId
	 * @param shutId
	 * @return
	 * @throws Exception
	 */
	public List<List<OrgnInfo>> getPrevTree(String orgnId, String shutId) throws Exception {
		if (StringUtils.isBlank(orgnId)) {
			return null;
		}
		List<List<OrgnInfo>> orgnListList = new ArrayList<List<OrgnInfo>>();
		if (!orgnId.equalsIgnoreCase(shutId)) {
			List<OrgnInfo> orgnInfoList = new ArrayList<OrgnInfo>();
			orgnInfoList.add(getOrgnInfo(shutId));
			orgnListList.add(orgnInfoList);
		}
		List<OrgnInfo> prevOrgnList = new ArrayList<OrgnInfo>();
		this.getPrevList(orgnId, shutId, prevOrgnList); //返回上级机构
		if (CollectionUtils.isNotEmpty(prevOrgnList)) {
			Collections.sort(prevOrgnList, new Comparator<OrgnInfo>() { //重新排序
				@Override
				public int compare(OrgnInfo a1, OrgnInfo a2) {
					return a1.getOrgnRank() - a2.getOrgnRank();
				}
			});
			for (OrgnInfo orgnInfo : prevOrgnList) {
				List<OrgnInfo> rankOrgnList = getRankOrgn(orgnInfo.getOrgnId());
				if (CollectionUtils.isNotEmpty(rankOrgnList)) {
					orgnListList.add(rankOrgnList);
				}
			}
		} else {
			List<OrgnInfo> orgnInfoList = new ArrayList<OrgnInfo>();
			orgnInfoList = new ArrayList<OrgnInfo>();
			orgnInfoList.add(getOrgnInfo(orgnId));
			orgnListList.add(orgnInfoList);
		}
		List<OrgnInfo> rankOrgnList = getRankOrgn(orgnId);
		if (CollectionUtils.isNotEmpty(rankOrgnList)) {
			orgnListList.add(rankOrgnList);
		}
		return orgnListList;
	}
	
	/**
	 * 返回下级机构
	 * @param orgnId
	 * @return
	 * @throws Exception
	 */
	public List<OrgnInfo> getRankOrgn(String orgnId) throws Exception {
		if (StringUtils.isBlank(orgnId)) {
			return null;
		}
		List<OrgnInfo> orgnInfoList = getList(); //返回缓存中组织机构
		if (CollectionUtils.isEmpty(orgnInfoList)) {
			return null;
		}
		OrgnInfo prevOrgn = getOrgnInfo(orgnId); //当前机构
		if (null != prevOrgn) {
			List<OrgnInfo> needOrgnList = new ArrayList<OrgnInfo>();
			for (OrgnInfo orgnInfo : orgnInfoList) {
				if (null != orgnInfo
						&& StringUtils.isNotBlank(orgnInfo.getPrevId())
						&& orgnInfo.getPrevId().equals(prevOrgn.getOrgnId())) {
					needOrgnList.add(orgnInfo);
				}
			}
			return needOrgnList;
		}
		return null;
	}
	
	/**
	 * 返回下级机构
	 * @param orgnId
	 * @throws Exception
	 */
	public List<OrgnInfo> getRankList(String orgnId) throws Exception {
		List<OrgnInfo> orgnListList = new ArrayList<OrgnInfo>();
		getRankList(orgnId, orgnListList);
		return orgnListList;
	}
	
	/**
	 * 迭代下级机构
	 * @param orgnId
	 * @param orgnListList
	 * @throws Exception
	 */
	private void getRankList(String orgnId, List<OrgnInfo> orgnListList) throws Exception {
		List<OrgnInfo> rankOrgnList = this.getRankOrgn(orgnId);
		if (CollectionUtils.isNotEmpty(rankOrgnList)) {
			for (OrgnInfo orgnInfo : rankOrgnList) {
				orgnListList.add(orgnInfo);
				List<OrgnInfo> nextOrgnList = this.getRankOrgn(orgnInfo.getOrgnId());
				if (CollectionUtils.isNotEmpty(nextOrgnList)) {
					this.getRankList(orgnInfo.getOrgnId(), orgnListList);
				}
			}
		}
	}
	
	/**
	 * 返回机构全称
	 * @param orgnId
	 * @return
	 * @throws Exception
	 */
	public String getFullName(String orgnId) throws Exception {
		if (StringUtils.isBlank(orgnId)) {
			throw new Exception("机构主键为空");
		}
		List<OrgnInfo> orgnInfoList = getPrevList(orgnId);
		if (CollectionUtils.isNotEmpty(orgnInfoList)) {
			StringBuilder sb = new StringBuilder();
			for (OrgnInfo orgnInfo : orgnInfoList) {
				sb.append(orgnInfo.getOrgnName());
				sb.append(" / ");
			}
			if (null != sb) {
				sb.append(getOrgnInfo(orgnId).getOrgnName());
				return sb.toString();
			}
		}
		OrgnInfo orgnInfo = getOrgnInfo(orgnId);
		if (null != orgnInfo) {
			return orgnInfo.getOrgnName();
		}
		return null;
	}
	
	/**
	 * 是否上级机构
	 * @param prevId 上级主键
	 * @param orgnId 下级主键
	 * @return
	 * @throws Exception
	 */
	public Boolean isPrev(String prevId, String orgnId) throws Exception {
		if (StringUtils.isBlank(prevId)
				|| StringUtils.isBlank(orgnId)) {
			return false;
		}
		if (prevId.equals(orgnId)) {
			return true;
		}
		List<OrgnInfo> prevOrgnList = getPrevList(orgnId);
		if (CollectionUtils.isNotEmpty(prevOrgnList)) {
			for (OrgnInfo prevOrgn : prevOrgnList) {
				if (prevId.equals(prevOrgn.getOrgnId())) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 是否下级机构
	 * @param orgnId 上级主键
	 * @param rankId 下级主键
	 * @return
	 * @throws Exception
	 */
	public Boolean isRank(String orgnId, String rankId) throws Exception {
		if (StringUtils.isBlank(orgnId)
				|| StringUtils.isBlank(rankId)) {
			return false;
		}
		if (orgnId.equals(rankId)) {
			return true;
		}
		List<OrgnInfo> prevOrgnList = getPrevList(rankId);
		if (CollectionUtils.isNotEmpty(prevOrgnList)) {
			for (OrgnInfo prevOrgn : prevOrgnList) {
				if (orgnId.equals(prevOrgn.getOrgnId())) {
					return true;
				}
			}
		}
		return false;
	}
}