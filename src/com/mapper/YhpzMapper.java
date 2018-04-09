package com.mapper;

import com.model.Yhpz;

public interface YhpzMapper {
    int deleteByPrimaryKey(String pzid);

    int insert(Yhpz record);

    int insertSelective(Yhpz record);

    Yhpz selectByPrimaryKey(String pzid);

    int updateByPrimaryKeySelective(Yhpz record);

    int updateByPrimaryKey(Yhpz record);
}