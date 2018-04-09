package com.mapper;

import java.util.HashMap;
import java.util.List;

import com.model.Splc;

public interface SplcMapper {
    int deleteByPrimaryKey(String lcid);

    int insert(Splc record);

    int insertSelective(Splc record);

    Splc selectByPrimaryKey(String lcid);

    int updateByPrimaryKeySelective(Splc record);

    int updateByPrimaryKey(Splc record);

	List<Splc> selectSplc(HashMap<String, Object> spclMap);
}