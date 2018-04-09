package com.mapper;

import com.model.Qzfz;

public interface QzfzMapper {
    int deleteByPrimaryKey(String qzfzid);

    int insert(Qzfz record);

    int insertSelective(Qzfz record);

    Qzfz selectByPrimaryKey(String qzfzid);

    int updateByPrimaryKeySelective(Qzfz record);

    int updateByPrimaryKey(Qzfz record);
}