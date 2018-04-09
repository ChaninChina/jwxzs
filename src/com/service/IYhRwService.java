/**
 * 
 */
package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.model.Splc;

/**
 * @author Chanin
 *
 */
public interface IYhRwService {

	void updateYhRwShztByRwid(HashMap<String, Object> updateMap) throws Exception;

	void updateYhRw(HashMap<String, Object> updateMap) throws Exception;

	void updateYhRwWcztByHour() throws Exception;// 修改周期值为“每小时”的完成状态

	void updateYhRwWcztByDay() throws Exception;// 修改周期值为“每天”的完成状态

	void updateYhRwWcztByWeek() throws Exception;// 修改周期值为“每星期”的完成状态

	void updateYhRwWcztByMonth() throws Exception;// 修改周期值为“每月”的完成状态

	void updateYhRwWcztByQuarter() throws Exception;// 修改周期值为“每季度”的完成状态

	void updateYhRwWcztByYear() throws Exception;// 修改周期值为“每年”的完成状态

	List<String> selectYhidByRwid(HashMap<String, Object> hashMap) throws Exception;

}
