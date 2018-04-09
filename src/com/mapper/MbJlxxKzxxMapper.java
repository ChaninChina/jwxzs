package com.mapper;

import com.model.MbJlxxKzxx;

public interface MbJlxxKzxxMapper {
    int deleteByPrimaryKey(String xxid);

    int insert(MbJlxxKzxx record);

    int insertSelective(MbJlxxKzxx record);

    MbJlxxKzxx selectByPrimaryKey(String xxid);

    int updateByPrimaryKeySelective(MbJlxxKzxx record);

    int updateByPrimaryKey(MbJlxxKzxx record);
}