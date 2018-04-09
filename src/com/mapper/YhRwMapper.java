package com.mapper;

import java.util.HashMap;
import java.util.List;

import com.model.YhRw;

public interface YhRwMapper {
    int deleteByPrimaryKey(String yhRwId);

    int insert(YhRw record);

    int insertSelective(YhRw record);

    YhRw selectByPrimaryKey(String yhRwId);

    int updateByPrimaryKeySelective(YhRw record);

    int updateByPrimaryKey(YhRw record);

	void updateYhRw(HashMap<String, Object> updateMap);

	void updateYhRwWczt(HashMap<String, Object> updateMap);

	List<String> selectYhidByRwid(HashMap<String, Object> hashMap);
}