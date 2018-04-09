package com.mapper;

import java.util.HashMap;
import java.util.List;

import com.model.MbJlxx;

public interface MbJlxxMapper {
    int deleteByPrimaryKey(String xxid);

    int insert(MbJlxx record);

    int insertSelective(MbJlxx record);

    MbJlxx selectByPrimaryKey(String xxid);

    int updateByPrimaryKeySelective(MbJlxx record);

    int updateByPrimaryKey(MbJlxx record);

	List<MbJlxx> selectMbjlxx(HashMap<String, Object> p4);
}