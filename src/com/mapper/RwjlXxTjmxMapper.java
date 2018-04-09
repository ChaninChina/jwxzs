package com.mapper;

import java.util.HashMap;
import java.util.List;

import com.model.RwjlXxTjmx;

public interface RwjlXxTjmxMapper {
    int deleteByPrimaryKey(String mxid);

    int insert(RwjlXxTjmx record);

    int insertSelective(RwjlXxTjmx record);

    RwjlXxTjmx selectByPrimaryKey(String mxid);

    int updateByPrimaryKeySelective(RwjlXxTjmx record);

    int updateByPrimaryKey(RwjlXxTjmx record);

	List<RwjlXxTjmx> selectRwjlXxTjmx(HashMap<String, Object> hashMap);
}