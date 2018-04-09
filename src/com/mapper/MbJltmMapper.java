package com.mapper;

import java.util.HashMap;
import java.util.List;

import com.model.MbJltm;

public interface MbJltmMapper {
    int deleteByPrimaryKey(String tmid);

    int insert(MbJltm record);

    int insertSelective(MbJltm record);

    MbJltm selectByPrimaryKey(String tmid);

    int updateByPrimaryKeySelective(MbJltm record);

    int updateByPrimaryKey(MbJltm record);

	List<MbJltm> selectMbJlTm(HashMap<String, Object> p3);
}