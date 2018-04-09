/**
 * 
 */
package com.service;

import java.util.HashMap;
import java.util.List;

import com.model.Stxx;
import com.model.Xxxx;
import com.model.Yhxx;
import com.util.page.PageResult;

/**
 * @author Chanin
 *
 */
public interface IXxxxService {

	List<Xxxx> selectXxxx(HashMap<String, Object> paramMap) throws Exception;

	PageResult<Xxxx> selectXxxxPage(HashMap<String, Object> paramMap) throws Exception;

	void insertXxxxByHour() throws Exception;
	
	void insertXxxxByDay() throws Exception;// 自动插入周期值为“每天”的提醒消息

	void insertXxxxByWeek() throws Exception;// 自动插入周期值为“每星期”的提醒消息

	void insertXxxxByMonth() throws Exception;// 自动插入周期值为“每月”的提醒消息

	void insertXxxxByQuarter() throws Exception;// 自动插入周期值为“每季度”的提醒消息

	void insertXxxxByYear() throws Exception;// 自动插入周期值为“每年”的提醒消息
	

}
