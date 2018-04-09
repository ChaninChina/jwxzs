package com.mapper;

import com.model.Spxx;

public interface SpxxMapper {
    int deleteByPrimaryKey(String spxxId);

    int insert(Spxx record);

    int insertSelective(Spxx record);

    Spxx selectByPrimaryKey(String spxxId);

    int updateByPrimaryKeySelective(Spxx record);

    int updateByPrimaryKey(Spxx record);
}