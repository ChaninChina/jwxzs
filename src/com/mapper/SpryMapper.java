package com.mapper;

import com.model.Spry;

public interface SpryMapper {
    int deleteByPrimaryKey(String ryxxId);

    int insert(Spry record);

    int insertSelective(Spry record);

    Spry selectByPrimaryKey(String ryxxId);

    int updateByPrimaryKeySelective(Spry record);

    int updateByPrimaryKey(Spry record);
}