package com.mapper;

import com.model.StFj;

public interface StFjMapper {
    int deleteByPrimaryKey(String stfjid);

    int insert(StFj record);

    int insertSelective(StFj record);

    StFj selectByPrimaryKey(String stfjid);

    int updateByPrimaryKeySelective(StFj record);

    int updateByPrimaryKey(StFj record);
}