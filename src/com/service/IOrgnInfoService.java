package com.service;

import java.util.List;
import java.util.Map;

import com.model.OrgnInfo;
import com.util.page.PageResult;

/**
 * 机构基本信息Service
 * @author QingLong
 */
public interface IOrgnInfoService {
	
	/**
	 * 保存机构基本信息
	 * @param orgnInfo
	 * @throws Exception
	 */
	public void insert(OrgnInfo orgnInfo) throws Exception;
	
	/**
	 * 删除机构基本信息(通过机构主键)
	 * @param orgnId
	 * @throws Exception
	 */
	public void deleteByOrgnId(String orgnId) throws Exception;
	
	/**
	 * 删除机构基本信息(通过机构主键)
	 * @param orgnInfo
	 * @throws Exception
	 */
	public void deleteByOrgnIdLogically(OrgnInfo orgnInfo) throws Exception;
	
	/**
	 * 更新机构基本信息(通过机构主键)
	 * @param orgnInfo
	 * @throws Exception
	 */
	public void updateByOrgnIdSelective(OrgnInfo orgnInfo) throws Exception;
	
	/**
	 * 更新机构基本信息(通过机构主键)
	 * @param orgnInfo
	 * @throws Exception
	 */
	public void updateByOrgnIdProcedure(OrgnInfo orgnInfo) throws Exception;
	
	/**
	 * 查询机构基本信息
	 * @param orgnInfo
	 * @throws Exception
	 */
	public List<OrgnInfo> select(OrgnInfo orgnInfo) throws Exception;
	
	/**
	 * 统计机构编号数量
	 * @param paramMap 条件
	 * @return
	 * @throws Exception
	 */
	public Integer tjbhsl(Map<String, String> paramMap) throws Exception;
	
	/**
	 * 查询机构基本信息(通过机构主键)
	 * @param orgnId
	 * @return orgnInfo
	 * @throws Exception
	 */
	public OrgnInfo selectByOrgnId(String orgnId) throws Exception;
	
	/**
	 * 查询机构基本信息(通过父级主键)
	 * @param prevId
	 * @return List<OrgnInfo>
	 * @throws Exception
	 */
	public List<OrgnInfo> selectByPrevId(String prevId) throws Exception;
	
	/**
	 * 查询父级机构信息(通过机构主键)
	 * @param orgnId
	 * @return orgnInfo
	 * @throws Exception
	 */
	public OrgnInfo selectPrevByOrgnId(String orgnId) throws Exception;
	
	/**
	 * 查询子级机构数量(通过机构主键)
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public Integer selectRankSizeByOrgnId(Map<String, String> paramMap) throws Exception;
	
	/**
	 * 查询平级机构数量(通过机构主键)
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public Integer selectFlatSizeByOrgnId(Map<String, String> paramMap) throws Exception;
	
	/**
	 * 搜索机构信息数量
	 * @param map 条件
	 * @return Integer
	 * @throws Exception
	 */
	public Integer searchSize(Map<String, Object> map) throws Exception;
	
	/**
	 * 搜索机构信息列表
	 * @param map 条件
	 * @return List<OrgnInfo>
	 * @throws Exception
	 */
	public List<OrgnInfo> searchList(Map<String, Object> map) throws Exception;
	
	/**
	 * 搜索机构信息分页
	 * @param map 条件
	 * @return PageResult
	 * @throws Exception
	 */
	public PageResult searchPage(Map<String, Object> map) throws Exception;
}