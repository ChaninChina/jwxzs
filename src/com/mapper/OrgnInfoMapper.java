package com.mapper;

import java.util.List;
import java.util.Map;

import com.model.OrgnInfo;

/**
 * 机构基本信息Mapper
 * @author QingLong
 */
public interface OrgnInfoMapper {
	
	/**
	 * 保存机构基本信息
	 * @param orgnInfo
	 */
	public void insert(OrgnInfo orgnInfo);
	
	/**
	 * 删除机构基本信息(通过机构主键)
	 * @param orgnId
	 */
	public void deleteByOrgnId(String orgnId);
	
	/**
	 * 更新机构基本信息(通过机构主键)
	 * @param orgnInfo
	 */
	public void updateByOrgnIdSelective(OrgnInfo orgnInfo);
	
	/**
	 * 更新机构基本信息(通过机构主键)
	 * @param paramMap
	 */
	public void updateByOrgnIdProcedure(Map<String, String> paramMap);
	
	/**
	 * 查询机构基本信息
	 * @param orgnInfo
	 * @return
	 */
	public List<OrgnInfo> select(OrgnInfo orgnInfo);
	
	/**
	 * 统计机构编号数量
	 * @param paramMap
	 * @return
	 */
	public Integer tjbhsl(Map<String, String> paramMap);
	
	/**
	 * 查询机构基本信息(通过机构主键)
	 * @param orgnId
	 * @return
	 */
	public OrgnInfo selectByOrgnId(String orgnId);
	
	/**
	 * 查询机构基本信息(通过父级主键)
	 * @param prevId
	 * @return
	 */
	public List<OrgnInfo> selectByPrevId(String prevId);
	
	/**
	 * 查询父级机构信息(通过机构主键)
	 * @param orgnId
	 * @return
	 */
	public OrgnInfo selectPrevByOrgnId(String orgnId);
	
	/**
	 * 查询子级机构数量(通过机构主键)
	 * @param paramMap
	 * @return
	 */
	public Integer selectRankSizeByOrgnId(Map<String, String> paramMap);
	
	/**
	 * 查询平级机构数量(通过机构主键)
	 * @param paramMap
	 * @return
	 */
	public Integer selectFlatSizeByOrgnId(Map<String, String> paramMap);
	
	/**
	 * 搜索机构信息数量
	 * @param map
	 * @return
	 */
	public Integer searchSize(Map<String, Object> map);
	
	/**
	 * 搜索机构信息列表
	 * @param map
	 * @return
	 */
	public List<OrgnInfo> searchList(Map<String, Object> map);
}