package com.mapper;

import java.util.HashMap;
import java.util.List;

import com.model.RwjlTmTjmx;

public interface RwjlTmTjmxMapper {
    int deleteByPrimaryKey(String mxid);

    int insert(RwjlTmTjmx record);

    int insertSelective(RwjlTmTjmx record);

    RwjlTmTjmx selectByPrimaryKey(String mxid);

    int updateByPrimaryKeySelective(RwjlTmTjmx record);

    int updateByPrimaryKey(RwjlTmTjmx record);

	List<RwjlTmTjmx> selectRwjlTmTjmx(HashMap<String, Object> hashMap);
}