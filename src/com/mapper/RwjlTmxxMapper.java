package com.mapper;

import java.util.HashMap;
import java.util.List;

import com.model.RwjlTmxx;

public interface RwjlTmxxMapper {
    int deleteByPrimaryKey(String rwxxid);

    int insert(RwjlTmxx record);

    int insertSelective(RwjlTmxx record);

    RwjlTmxx selectByPrimaryKey(String rwxxid);

    int updateByPrimaryKeySelective(RwjlTmxx record);

    int updateByPrimaryKey(RwjlTmxx record);

	List<RwjlTmxx> selectRwjlTmxx(HashMap<String, Object> p2);
}