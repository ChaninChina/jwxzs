package com.mapper;

import com.model.QzBz;

public interface QzBzMapper {
    int deleteByPrimaryKey(String bsmid);

    int insert(QzBz record);

    int insertSelective(QzBz record);

    QzBz selectByPrimaryKey(String bsmid);

    int updateByPrimaryKeySelective(QzBz record);

    int updateByPrimaryKey(QzBz record);
}