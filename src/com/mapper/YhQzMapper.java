package com.mapper;

import java.util.HashMap;
import java.util.List;

import com.model.YhQz;

public interface YhQzMapper {
    int deleteByPrimaryKey(String qzYhId);

    int insert(YhQz record);

    int insertSelective(YhQz record);

    YhQz selectByPrimaryKey(String qzYhId);

    int updateByPrimaryKeySelective(YhQz record);

    int updateByPrimaryKey(YhQz record);

	List<YhQz> selectYhQz(HashMap<String, Object> yhqzParamMap);
}