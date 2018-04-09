package com.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.mapper.OrgnInfoMapper;
import com.model.OrgnInfo;
import com.service.IOrgnInfoService;
import com.util.DateUtil;
import com.util.dict.DictEnumUtil;
import com.util.jg.OrgnFillUtil;
import com.util.jg.OrgnListUtil;
import com.util.page.PageInfo;
import com.util.page.PageResult;
import com.util.page.PageUtil;
import com.util.qy.AreaFillUtil;

/**
 * 机构基本信息Service
 * @author QingLong 
 */
@Service("orgnInfoService")
public class OrgnInfoServiceImpl implements IOrgnInfoService{
	
	Logger logger = Logger.getLogger(OrgnInfoServiceImpl.class);
	
	@Resource
	private AreaFillUtil areaFillUtil;
	@Resource
	private OrgnFillUtil orgnFillUtil;
	@Resource
	private OrgnListUtil orgnListUtil;
	@Resource
	private OrgnInfoMapper orgnInfoMapper;
	
	/**
	 * 保存机构基本信息
	 * @param orgnInfo
	 * @throws Exception
	 */
	@Override
	public void insert(OrgnInfo orgnInfo) throws Exception {
		if (null != orgnInfo) {
			//机构代码
			if (StringUtils.isBlank(orgnInfo.getOrgnCode())) {
				return;
			}
			//子级标志
			if (StringUtils.isBlank(orgnInfo.getSubsetSymbol())) {
				orgnInfo.setSubsetSymbol(DictEnumUtil.SUBSET_SYMBOL_MYZJ);
			}
			//启用状态
			if (StringUtils.isBlank(orgnInfo.getEnableStatus())) {
				orgnInfo.setEnableStatus(DictEnumUtil.ENABLE_STATUS_YQY);
			}
			//删除状态
			if (StringUtils.isBlank(orgnInfo.getDeleteStatus())) {
				orgnInfo.setDeleteStatus(DictEnumUtil.DELETE_STATUS_WSC);
			}
			//创建日期
			if (StringUtils.isBlank(orgnInfo.getCreateTime())) {
				orgnInfo.setCreateTime(DateUtil.getDate(DateUtil.yyyy_MM_dd_HH_mm_ss));
			}
			//保存机构
			orgnInfoMapper.insert(orgnInfo);
			//父级机构
			if (StringUtils.isNotBlank(orgnInfo.getPrevId())) {
				OrgnInfo prevOrgn = orgnInfoMapper.selectByOrgnId(orgnInfo.getPrevId());
				prevOrgn.setSubsetSymbol(DictEnumUtil.SUBSET_SYMBOL_YYZJ);
				orgnInfoMapper.updateByOrgnIdSelective(prevOrgn);
			}
			//重置缓存
			orgnListUtil.putList();
		}
	}
	
	/**
	 * 删除机构基本信息(通过机构主键)
	 * @param orgnId
	 * @throws Exception
	 */
	@Override
	public void deleteByOrgnId(String orgnId) throws Exception {
		if (StringUtils.isBlank(orgnId)) {
			return;
		}
		//删除机构
		orgnInfoMapper.deleteByOrgnId(orgnId);
		//父级机构
		OrgnInfo prevOrgn = orgnInfoMapper.selectPrevByOrgnId(orgnId);
		//平级机构
		if (null != prevOrgn) {
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("orgnId", prevOrgn.getOrgnId());
			Integer rankSize = orgnInfoMapper.selectRankSizeByOrgnId(paramMap);
			if (rankSize <= 0) {//拥有子级
				prevOrgn.setSubsetSymbol(DictEnumUtil.SUBSET_SYMBOL_MYZJ);
				orgnInfoMapper.updateByOrgnIdSelective(prevOrgn);
			}
		}
		//重置缓存
		orgnListUtil.putList();
	}
	
	/**
	 * 删除机构基本信息(通过机构主键)
	 * @param orgnInfo 机构对象
	 * @throws Exception 异常
	 */
	@Override
	public void deleteByOrgnIdLogically(OrgnInfo orgnInfo) throws Exception {
		if (StringUtils.isNotBlank(orgnInfo.getOrgnId())) {
			if (StringUtils.isBlank(orgnInfo.getUpdateTime())) { //更新时间
				orgnInfo.setUpdateTime(DateUtil.getDate(DateUtil.yyyy_MM_dd_HH_mm_ss));
			}
			orgnInfo.setDeleteStatus(DictEnumUtil.DELETE_STATUS_YSC); //删除状态(已删除)
			//更新机构
			orgnInfoMapper.updateByOrgnIdSelective(orgnInfo);
			//父级机构
			if (StringUtils.isNotBlank(orgnInfo.getPrevId())) {
				OrgnInfo prevOrgn = orgnInfoMapper.selectByOrgnId(orgnInfo.getPrevId());
				if (null != prevOrgn) {
					Map<String, String> paramMap = new HashMap<String, String>();
					paramMap.put("orgnId", prevOrgn.getOrgnId());
					paramMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
					Integer rankSize = orgnInfoMapper.selectRankSizeByOrgnId(paramMap);
					if (rankSize <= 0) {//拥有子级
						prevOrgn.setSubsetSymbol(DictEnumUtil.SUBSET_SYMBOL_MYZJ);
						orgnInfoMapper.updateByOrgnIdSelective(prevOrgn);
					}
				}
			}
			//重置缓存
			orgnListUtil.putList();
		}
	}
	
	/**
	 * 更新机构基本信息(通过机构主键)
	 * @param orgnInfo
	 * @throws Exception
	 */
	@Override
	public void updateByOrgnIdSelective(OrgnInfo orgnInfo) throws Exception {
		if (StringUtils.isNotBlank(orgnInfo.getOrgnId())) {
			if (StringUtils.isBlank(orgnInfo.getUpdateTime())) { //更新时间
				orgnInfo.setUpdateTime(DateUtil.getDate(DateUtil.yyyy_MM_dd_HH_mm_ss));
			}
			orgnInfoMapper.updateByOrgnIdSelective(orgnInfo); //更新机构
			orgnListUtil.putList(); //重置缓存
		}
	}
	
	/**
	 * 更新机构基本信息(通过机构主键)
	 * @param orgnInfo
	 * @throws Exception
	 */
	@Override
	public void updateByOrgnIdProcedure(OrgnInfo orgnInfo) throws Exception {
		if (StringUtils.isNotBlank(orgnInfo.getOrgnId())) {
			if (StringUtils.isBlank(orgnInfo.getUpdateTime())) { //更新时间
				orgnInfo.setUpdateTime(DateUtil.getDate(DateUtil.yyyy_MM_dd_HH_mm_ss));
			}
			//更新机构
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("orgnId", orgnInfo.getOrgnId());
			paramMap.put("prevId", orgnInfo.getPrevId());
			paramMap.put("areaId", orgnInfo.getAreaId());
			paramMap.put("orgnCode", orgnInfo.getOrgnCode());
			paramMap.put("orgnType", orgnInfo.getOrgnType());
			paramMap.put("orgnStep", null);
			paramMap.put("orgnName", orgnInfo.getOrgnName());
			paramMap.put("orgnPiny", orgnInfo.getOrgnPiny());
			paramMap.put("orgnRank", String.valueOf(orgnInfo.getOrgnRank()));
			paramMap.put("orgnSort", String.valueOf(orgnInfo.getOrgnSort()));
			paramMap.put("orgnNote", orgnInfo.getOrgnNote());
			paramMap.put("subsetSymbol", orgnInfo.getSubsetSymbol());
			paramMap.put("redactSymbol", orgnInfo.getRedactSymbol());
			paramMap.put("enableStatus", orgnInfo.getEnableStatus());
			paramMap.put("deleteStatus", orgnInfo.getDeleteStatus());
			paramMap.put("handleUserId", orgnInfo.getUpdateId());
			paramMap.put("handleUserName", null);
			paramMap.put("handleTime", orgnInfo.getUpdateTime());
			orgnInfoMapper.updateByOrgnIdProcedure(paramMap);
			if (null != paramMap.get("errorMsg")) {
				throw new Exception(paramMap.get("errorMsg"));
			}
			//重置缓存
			orgnListUtil.putList();
		}
	}
	
	/**
	 * 查询机构基本信息
	 * @param orgnInfo
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<OrgnInfo> select(OrgnInfo orgnInfo) throws Exception {
		List<OrgnInfo> orgnInfoList = orgnInfoMapper.select(orgnInfo);
		return orgnInfoList;
	}
	
	/**
	 * 统计机构编号数量
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public Integer tjbhsl(Map<String, String> paramMap) throws Exception {
		return orgnInfoMapper.tjbhsl(paramMap);
	}
	
	/**
	 * 查询机构基本信息(通过机构主键)
	 * @param orgnId
	 * @return
	 * @throws Exception
	 */
	@Override
	public OrgnInfo selectByOrgnId(String orgnId) throws Exception {
		if (StringUtils.isBlank(orgnId)) {
			return null;
		}
		OrgnInfo orgnInfo = orgnInfoMapper.selectByOrgnId(orgnId);
		return orgnInfo;
	}
	
	/**
	 * 查询父级机构信息(通过机构主键)
	 * @param orgnId
	 * @return
	 * @throws Exception
	 */
	@Override
	public OrgnInfo selectPrevByOrgnId(String orgnId) throws Exception {
		if (StringUtils.isBlank(orgnId)) {
			return null;
		}
		OrgnInfo prevOrgn = orgnInfoMapper.selectPrevByOrgnId(orgnId);
		return prevOrgn;
	}
	
	/**
	 * 查询机构基本信息(通过父级主键)
	 * @param prevId 
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<OrgnInfo> selectByPrevId(String prevId) throws Exception {
		List<OrgnInfo> orgnInfoList = orgnInfoMapper.selectByPrevId(prevId);
		return orgnInfoList;
	}
	
	/**
	 * 查询子级机构数量(通过机构主键)
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public Integer selectRankSizeByOrgnId(Map<String, String> paramMap) throws Exception {
		return orgnInfoMapper.selectRankSizeByOrgnId(paramMap);
	}
	
	/**
	 * 查询平级机构数量(通过机构主键)
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public Integer selectFlatSizeByOrgnId(Map<String, String> paramMap) throws Exception {
		return orgnInfoMapper.selectFlatSizeByOrgnId(paramMap);
	}
	
	/**
	 * 搜索机构信息数量
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public Integer searchSize(Map<String, Object> map) throws Exception {
		return orgnInfoMapper.searchSize(map);
	}

	/**
	 * 搜索机构信息列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<OrgnInfo> searchList(Map<String, Object> map)	throws Exception {
		return orgnInfoMapper.searchList(map);
	}
	
	/**
	 * 搜索机构信息分页
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageResult searchPage(Map<String, Object> map) throws Exception {
		Object ep = map.get("ep"); //每页数量
		Integer everyPage = ((ep == null || ep == "") ? Integer.valueOf(DictEnumUtil.DEFAULT_EVERYPAGE) : Integer.valueOf(String.valueOf(ep)));
		Object cn = map.get("cn"); //当前页码
		Integer currentNo = ((cn == null || cn == "") ? 1 : Integer.valueOf(String.valueOf(cn)));
		//总记录数
		Integer size = orgnInfoMapper.searchSize(map);
		PageInfo pageInfo = PageUtil.createPage(everyPage, currentNo, size); //分页实体
		map.put("page", pageInfo);
		List<OrgnInfo> orgnInfoList = null; //返回集合
		if (size != null && size > 0) {
			orgnInfoList = orgnInfoMapper.searchList(map);
			if (CollectionUtils.isNotEmpty(orgnInfoList)) {
				for (OrgnInfo orgnInfo : orgnInfoList) {
					areaFillUtil.fillAreaInfoOfModel(orgnInfo); //区域信息
					orgnFillUtil.fillOrgnInfoOfModel(orgnInfo); //父级机构
				}
			}
		}
		return new PageResult(pageInfo, orgnInfoList);
	}
}