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
import com.mapper.StFjMapper;
import com.mapper.StxxMapper;
import com.mapper.XxxxMapper;
import com.model.Fjxx;
import com.model.Strw;
import com.model.Stxx;
import com.model.Xxxx;
import com.model.Yhxx;
import com.service.IStrwService;
import com.service.IStxxService;
import com.service.IXxxxService;
import com.util.DateUtil;
import com.util.UUIDUtil;
import com.util.dict.DictEnumUtil;
import com.util.jg.OrgnListUtil;
import com.util.page.PageInfo;
import com.util.page.PageResult;
import com.util.page.PageUtil;

/**
 * @author Chanin
 *
 */
public class XxxxService implements IXxxxService{
	
	
	@Resource
	private XxxxMapper xxxxMapper;

	/**
	 * 查询消息信息
	 */
	@Override
	public List<Xxxx> selectXxxx(HashMap<String, Object> paramMap) throws Exception{
		// TODO Auto-generated method stub
		return xxxxMapper.selectXxxx(paramMap);
	}

	/**
	 * 分页获取消息信息
	 */
	@Override
	public PageResult<Xxxx> selectXxxxPage(HashMap<String, Object> paramMap) throws Exception {
		Object ep = paramMap.get("ep"); //每页数量
		Integer everyPage = ((ep == null || ep == "") ? Integer.valueOf(DictEnumUtil.DEFAULT_EVERYPAGE) : Integer.valueOf(String.valueOf(ep)));
		Object cn = paramMap.get("cn"); //当前页码
		Integer currentNo = ((cn == null || cn == "") ? 1 : Integer.valueOf(String.valueOf(cn)));

		//总记录数
		Integer size = xxxxMapper.searchXxxxOfSize(paramMap);
		PageInfo pageInfo = PageUtil.createPage(everyPage, currentNo, size); //分页实体
		paramMap.put("page", pageInfo);
		List<Xxxx> strws = null;//返回集合
		if(size != null && size > 0){
			strws = xxxxMapper.searchXxxxOfList(paramMap);
		}
		return new PageResult<Xxxx>(pageInfo, strws);

	}

	/**
	 * 自动生成提醒类型为“自动提醒”，记录周期类型为“每小时”的提醒消息
	 */
	@Override
	public void insertXxxxByHour() throws Exception {
		autoInsertXxxxByJlzqlx(DictEnumUtil.JLZQ_HOUR);//记录周期类型“每小时”
	}

	/**
	 * 自动生成提醒类型为“自动提醒”，记录周期类型为“每天”的提醒消息
	 */
	@Override
	public void insertXxxxByDay() throws Exception {
		autoInsertXxxxByJlzqlx(DictEnumUtil.JLZQ_DAY);//记录周期类型“每天”
		
	}

	/**
	 * 自动生成提醒类型为“自动提醒”，记录周期类型为“每星期”的提醒消息
	 */
	@Override
	public void insertXxxxByWeek() throws Exception {
		autoInsertXxxxByJlzqlx(DictEnumUtil.JLZQ_WEEK);//记录周期类型“每星期”
		
	}

	/**
	 * 自动生成提醒类型为“自动提醒”，记录周期类型为“每月”的提醒消息
	 */
	@Override
	public void insertXxxxByMonth() throws Exception {
		autoInsertXxxxByJlzqlx(DictEnumUtil.JLZQ_MONTH);//记录周期类型“每月”
		
	}

	/**
	 * 自动生成提醒类型为“自动提醒”，记录周期类型为“每季度”的提醒消息
	 */
	@Override
	public void insertXxxxByQuarter() throws Exception {
		autoInsertXxxxByJlzqlx(DictEnumUtil.JLZQ_QUARTER);//记录周期类型“每季度”
		
	}

	/**
	 * 自动生成提醒类型为“自动提醒”，记录周期类型为“每年”的提醒消息
	 */
	@Override
	public void insertXxxxByYear() throws Exception {
		autoInsertXxxxByJlzqlx(DictEnumUtil.JLZQ_YEAR);	//记录周期类型“每年”
	}

	private void autoInsertXxxxByJlzqlx(String jlzqlx) {
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("enableStatus",DictEnumUtil.ENABLE_STATUS_YQY);
		hashMap.put("deleteStatus",DictEnumUtil.DELETE_STATUS_WSC);
		hashMap.put("ydzt",DictEnumUtil.YDZT_WWD);//阅读状态-未阅读
		hashMap.put("wczt",DictEnumUtil.WCZT_WWC);//完成状态-未完成
		hashMap.put("txlx",DictEnumUtil.TXLX_AUTO);//提醒类型-自动提醒
		hashMap.put("jlzqlx",jlzqlx);//记录周期类型
		xxxxMapper.autoInsertXxxx(hashMap);
	}


	
}
