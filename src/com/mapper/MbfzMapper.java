package com.mapper;

import com.model.Mbfz;

public interface MbfzMapper {
    int deleteByPrimaryKey(String mbfzid);

    int insert(Mbfz record);

    int insertSelective(Mbfz record);

    Mbfz selectByPrimaryKey(String mbfzid);

    int updateByPrimaryKeySelective(Mbfz record);

    int updateByPrimaryKey(Mbfz record);
}