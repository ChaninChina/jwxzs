package com.mapper;

import java.util.HashMap;
import java.util.List;

import com.model.RwjlTm;

public interface RwjlTmMapper {
    int deleteByPrimaryKey(String rwtmid);

    int insert(RwjlTm record);

    int insertSelective(RwjlTm record);

    RwjlTm selectByPrimaryKey(String rwtmid);

    int updateByPrimaryKeySelective(RwjlTm record);

    int updateByPrimaryKeyWithBLOBs(RwjlTm record);

    int updateByPrimaryKey(RwjlTm record);

	List<RwjlTm> selectRwjlTm(HashMap<String, Object> p1);
}