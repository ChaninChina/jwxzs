/**
 * 
 */
package com.service.Impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import com.mapper.SplcMapper;
import com.mapper.YhRwMapper;
import com.model.Splc;
import com.service.ISplcService;
import com.service.IYhRwService;
import com.util.dict.DictEnumUtil;

/**
 * @author Chanin
 *
 */
public class YhRwService implements IYhRwService {
	@Resource
	YhRwMapper yhRwMapper;

	/**
	 * 通过任务ID修改YH_RW表中的审核状态
	 */
	@Override
	public void updateYhRwShztByRwid(HashMap<String, Object> updateMap) throws Exception {
		// TODO Auto-generated method stub
		yhRwMapper.updateYhRw(updateMap);
	}

	/**
	 * 修改用户任务
	 */
	@Override
	public void updateYhRw(HashMap<String, Object> updateMap) throws Exception {
		// TODO Auto-generated method stub
		yhRwMapper.updateYhRw(updateMap);
		
	}

	/**
	 * 重新将满足条件（任务在当前周期内已完成，并且任务未停止，任务数未达到最大）的任务记录周期为“每小时”的任务设置为未完成
	 */
	@Override
	public void updateYhRwWcztByHour() throws Exception {
		// TODO Auto-generated method stub
		HashMap<String, Object> updateMap = new HashMap<>();
		updateMap.put("jlzqlx", DictEnumUtil.JLZQ_HOUR);
		updateMap.put("newwczt", DictEnumUtil.WCZT_WWC);
		yhRwMapper.updateYhRwWczt(updateMap);
	}

	/**
	 * 重新将满足条件（任务在当前周期内已完成，并且任务未停止，任务数未达到最大）的任务记录周期为“每天”的任务设置为未完成
	 */
	@Override
	public void updateYhRwWcztByDay() throws Exception {
		// TODO Auto-generated method stub
		HashMap<String, Object> updateMap = new HashMap<>();
		updateMap.put("jlzqlx", DictEnumUtil.JLZQ_DAY);
		updateMap.put("newwczt", DictEnumUtil.WCZT_WWC);
		yhRwMapper.updateYhRwWczt(updateMap);
	}

	/**
	 * 重新将满足条件（任务在当前周期内已完成，并且任务未停止，任务数未达到最大）的任务记录周期为“每星期”的任务设置为未完成
	 */
	@Override
	public void updateYhRwWcztByWeek() throws Exception {
		// TODO Auto-generated method stub
		HashMap<String, Object> updateMap = new HashMap<>();
		updateMap.put("jlzqlx", DictEnumUtil.JLZQ_WEEK);
		updateMap.put("newwczt", DictEnumUtil.WCZT_WWC);
		yhRwMapper.updateYhRwWczt(updateMap);
	}

	/**
	 * 重新将满足条件（任务在当前周期内已完成，并且任务未停止，任务数未达到最大）的任务记录周期为“每月”的任务设置为未完成
	 */
	@Override
	public void updateYhRwWcztByMonth() throws Exception {
		// TODO Auto-generated method stub
		HashMap<String, Object> updateMap = new HashMap<>();
		updateMap.put("jlzqlx", DictEnumUtil.JLZQ_MONTH);
		updateMap.put("newwczt", DictEnumUtil.WCZT_WWC);
		yhRwMapper.updateYhRwWczt(updateMap);
	}

	/**
	 * 重新将满足条件（任务在当前周期内已完成，并且任务未停止，任务数未达到最大）的任务记录周期为“每季度”的任务设置为未完成
	 */
	@Override
	public void updateYhRwWcztByQuarter() throws Exception {
		// TODO Auto-generated method stub
		HashMap<String, Object> updateMap = new HashMap<>();
		updateMap.put("jlzqlx", DictEnumUtil.JLZQ_QUARTER);
		updateMap.put("newwczt", DictEnumUtil.WCZT_WWC);
		yhRwMapper.updateYhRwWczt(updateMap);
	}

	/**
	 * 重新将满足条件（任务在当前周期内已完成，并且任务未停止，任务数未达到最大）的任务记录周期为“每年”的任务设置为未完成
	 */
	@Override
	public void updateYhRwWcztByYear() throws Exception {
		// TODO Auto-generated method stub
		HashMap<String, Object> updateMap = new HashMap<>();
		updateMap.put("jlzqlx", DictEnumUtil.JLZQ_YEAR);
		updateMap.put("newwczt", DictEnumUtil.WCZT_WWC);
		yhRwMapper.updateYhRwWczt(updateMap);
	}

	@Override
	public List<String> selectYhidByRwid(HashMap<String, Object> hashMap) throws Exception {
		// TODO Auto-generated method stub
		return yhRwMapper.selectYhidByRwid(hashMap);
	}

}
