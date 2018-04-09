/**
 * 
 */
package com.service.Impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.mapper.FjxxMapper;
import com.mapper.QzxxMapper;
import com.mapper.StFjMapper;
import com.mapper.StrwMapper;
import com.mapper.StxxMapper;
import com.mapper.YhQzMapper;
import com.model.Fjxx;
import com.model.Strw;
import com.model.Stxx;
import com.model.Yhxx;
import com.service.IStrwService;
import com.service.IStxxService;
import com.util.dict.DictEnumUtil;
import com.util.jg.OrgnListUtil;
import com.util.page.PageInfo;
import com.util.page.PageResult;
import com.util.page.PageUtil;

/**
 * @author Chanin
 *
 */
public class StrwService implements IStrwService {

	@Resource
	private StxxMapper stXxMapper;

	@Resource
	private StrwMapper strwMapper;

	@Resource
	private QzxxMapper qzxxMapper;

	@Resource
	private YhQzMapper yhQzMapper;
	@Resource
	private OrgnListUtil orgnListUtil;
	@Resource
	private FjxxMapper fjXxMapper;
	@Resource
	private StFjMapper stFjMapper;

	@Resource
	private IStxxService stxxService;

	/**
	 * 通过任务ID和用户ID判断用户是否有权限执行该任务
	 */
	@Override
	public boolean hasPermission(String rwid, String yhid) throws Exception {
		// TODO Auto-generated method stub
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("rwid", rwid);
		paramMap.put("yhid", yhid);
		paramMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
		int count = strwMapper.checkPermission(paramMap);
		return count == 1;
	}

	/**
	 * 通过实体ID获取实体任务信息
	 */
	@Override
	public List<Strw> selectStrwByStId(String stid, String yhid) throws Exception {
		// TODO Auto-generated method stub
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("stid", stid);
		paramMap.put("yhid", yhid);
		paramMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
		return strwMapper.selectYhStrw(paramMap);
	}
	//通过用户ID任务ID获取实体任务以及实体任务相关的实体信息
	@Override
	public Strw selectStrwByRwId(String rwid, String yhid) throws Exception {
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("rwid", rwid);
		paramMap.put("yhid", yhid);
		paramMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
		List<Strw> strws = strwMapper.selectYhStrw(paramMap);//获取实体任务信息
		if (CollectionUtils.isEmpty(strws)) {
			throw new Exception("未找到相关任务信息！");
		}
		Strw strw = strws.get(0);
		strw.setHasPermission(true);
		HashMap<String, Object> stxxParamMap = new HashMap<>();
		stxxParamMap.put("stid", strw.getStid());
		stxxParamMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
		List<Stxx> stxxs = stxxService.selectStxx(stxxParamMap);//获取实体信息
		if (CollectionUtils.isNotEmpty(stxxs)) {
			strw.setStxx(stxxs.get(0));
		}

		return strw;
	}

//	@Override
//	public PageResult<Strw> selectStrwPage(HashMap<String, Object> paramMap) throws Exception {
//		Object ep = paramMap.get("ep"); // 每页数量
//		Integer everyPage = ((ep == null || ep == "") ? Integer.valueOf(DictEnumUtil.DEFAULT_EVERYPAGE)
//				: Integer.valueOf(String.valueOf(ep)));
//		Object cn = paramMap.get("cn"); // 当前页码
//		Integer currentNo = ((cn == null || cn == "") ? 1 : Integer.valueOf(String.valueOf(cn)));
//
//		// 总记录数
//		Integer size = strwMapper.searchStrwOfSize(paramMap);
//		PageInfo pageInfo = PageUtil.createPage(everyPage, currentNo, size); // 分页实体
//		paramMap.put("page", pageInfo);
//		List<Strw> strws = null;// 返回集合
//		if (size != null && size > 0) {
//			strws = strwMapper.searchStrwOfList(paramMap);
//			if (CollectionUtils.isNotEmpty(strws)) {
//				for (Strw strw : strws) {
//					HashMap<String, Object> stParamMap = new HashMap<>();
//					stParamMap.put("stid", strw.getStid());
//					strw.setHasPermission(true);
//					stParamMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
//					List<Stxx> stxxs = stxxService.selectStxx(stParamMap);
//					if (CollectionUtils.isNotEmpty(stxxs)) {
//						strw.setStxx(stxxs.get(0));
//					}
//				}
//			}
//		}
//		return new PageResult<Strw>(pageInfo, strws);
//
//	}

	/**
	 * 查询实体任务
	 */
	@Override
	public List<Strw> selectStrw(HashMap<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		List<Strw> strws = strwMapper.selectStrw(paramMap);
		if (!CollectionUtils.isEmpty(strws)) {
			fillStrw(strws);
		}
		return strws;
	}

	private void fillStrw(List<Strw> strws) {
		// TODO Auto-generated method stub

	}

	/**
	 * 分页获取用户实体任务 从YH_RW表中查询
	 */
	@Override
	public PageResult<Strw> selectStrwPageZT(HashMap<String, Object> paramMap) throws Exception {
		Object ep = paramMap.get("ep"); // 每页数量
		Integer everyPage = ((ep == null || ep == "") ? Integer.valueOf(DictEnumUtil.DEFAULT_EVERYPAGE)
				: Integer.valueOf(String.valueOf(ep)));
		Object cn = paramMap.get("cn"); // 当前页码
		Integer currentNo = ((cn == null || cn == "") ? 1 : Integer.valueOf(String.valueOf(cn)));

		// 总记录数
		Integer size = strwMapper.searchStrwZtOfSize(paramMap);
		PageInfo pageInfo = PageUtil.createPage(everyPage, currentNo, size); // 分页实体
		paramMap.put("page", pageInfo);
		List<Strw> strws = null;// 返回集合
		if (size != null && size > 0) {
			strws = strwMapper.searchStrwZtOfList(paramMap);
			if (CollectionUtils.isNotEmpty(strws)) {
				for (Strw strw : strws) {
					HashMap<String, Object> stParamMap = new HashMap<>();
					stParamMap.put("stid", strw.getStid());
					strw.setHasPermission(true);
					stParamMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
					List<Stxx> stxxs = stxxService.selectStxx(stParamMap);
					if (CollectionUtils.isNotEmpty(stxxs)) {
						strw.setStxx(stxxs.get(0));
					}
				}
			}
		}
		return new PageResult<Strw>(pageInfo, strws);
	}

	/**
	 * 从YH_RW表中查询用户不同状态的实体任务数量
	 */
	@Override
	public int selectCount(HashMap<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return strwMapper.searchStrwZtOfSize(paramMap);
	}

	/**
	 * 查询用户未完成的实体任务
	 */
	@Override
	public List<Strw> selectStrwWWC(HashMap<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		List<Strw> strws = strwMapper.selectStrwWWC(paramMap);
		for (Strw strw : strws) {
			strw.setHasPermission(true);
		}
		return strws;
	}

	/**
	 * 通过关键字搜索用户可执行的任务
	 */
	@Override
	public PageResult<Strw> searchStrw(HashMap<String, Object> paramMap) throws Exception {
		Object ep = paramMap.get("ep"); // 每页数量
		Integer everyPage = ((ep == null || ep == "") ? Integer.valueOf(DictEnumUtil.DEFAULT_EVERYPAGE)
				: Integer.valueOf(String.valueOf(ep)));
		Object cn = paramMap.get("cn"); // 当前页码
		Integer currentNo = ((cn == null || cn == "") ? 1 : Integer.valueOf(String.valueOf(cn)));

		// 总记录数
		Integer size = strwMapper.searchStrwKeyOfSize(paramMap);
		PageInfo pageInfo = PageUtil.createPage(everyPage, currentNo, size); // 分页实体
		paramMap.put("page", pageInfo);
		List<Strw> strws = null;// 返回集合
		if (size != null && size > 0) {
			strws = strwMapper.searchStrwKeyOfList(paramMap);
			if (CollectionUtils.isNotEmpty(strws)) {
				for (Strw strw : strws) {
					HashMap<String, Object> stParamMap = new HashMap<>();
					stParamMap.put("stid", strw.getStid());
					strw.setHasPermission(true);
					stParamMap.put("deleteStatus", DictEnumUtil.DELETE_STATUS_WSC);
					List<Stxx> stxxs = stxxService.selectStxx(stParamMap);
					if (CollectionUtils.isNotEmpty(stxxs)) {
						strw.setStxx(stxxs.get(0));
					}
				}
			}
		}
		return new PageResult<Strw>(pageInfo, strws);
	}

	//通过用户ID和实体ID获取实体任务
	@Override
	public List<Strw> selectYhStrw(HashMap<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return strwMapper.selectYhStrw(paramMap);
	}

}
