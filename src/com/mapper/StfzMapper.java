package com.mapper;

import com.model.Stfz;

public interface StfzMapper {
    int deleteByPrimaryKey(String stfzid);

    int insert(Stfz record);

    int insertSelective(Stfz record);

    Stfz selectByPrimaryKey(String stfzid);

    int updateByPrimaryKeySelective(Stfz record);

    int updateByPrimaryKey(Stfz record);
}