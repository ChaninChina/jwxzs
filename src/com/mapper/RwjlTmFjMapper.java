package com.mapper;

import com.model.RwjlTmFj;

public interface RwjlTmFjMapper {
    int deleteByPrimaryKey(String glid);

    int insert(RwjlTmFj record);

    int insertSelective(RwjlTmFj record);

    RwjlTmFj selectByPrimaryKey(String glid);

    int updateByPrimaryKeySelective(RwjlTmFj record);

    int updateByPrimaryKey(RwjlTmFj record);
}