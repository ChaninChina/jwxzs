package com.mapper;

import com.model.Qxxx;

public interface QxxxMapper {
    int deleteByPrimaryKey(String qxId);

    int insert(Qxxx record);

    int insertSelective(Qxxx record);

    Qxxx selectByPrimaryKey(String qxId);

    int updateByPrimaryKeySelective(Qxxx record);

    int updateByPrimaryKey(Qxxx record);
}