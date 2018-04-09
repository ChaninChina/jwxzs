package com.mapper;

import java.util.HashMap;
import java.util.List;

import com.model.Yhzh;

public interface YhzhMapper {
    int deleteByPrimaryKey(String zhid);

    int insert(Yhzh record);

    int insertSelective(Yhzh record);

    Yhzh selectByPrimaryKey(String zhid);

    int updateByPrimaryKeySelective(Yhzh record);

    int updateByPrimaryKey(Yhzh record);
    
    List<Yhzh> selectYhzh(HashMap<String,Object> paramMap);
}