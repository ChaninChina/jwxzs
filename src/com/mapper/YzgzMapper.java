package com.mapper;

import com.model.Yzgz;

public interface YzgzMapper {
    int deleteByPrimaryKey(String yzgzid);

    int insert(Yzgz record);

    int insertSelective(Yzgz record);

    Yzgz selectByPrimaryKey(String yzgzid);

    int updateByPrimaryKeySelective(Yzgz record);

    int updateByPrimaryKey(Yzgz record);
}