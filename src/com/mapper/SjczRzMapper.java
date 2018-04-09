package com.mapper;

import com.model.SjczRz;

public interface SjczRzMapper {
    int deleteByPrimaryKey(String id);

    int insert(SjczRz record);

    int insertSelective(SjczRz record);

    SjczRz selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SjczRz record);

    int updateByPrimaryKeyWithBLOBs(SjczRz record);

    int updateByPrimaryKey(SjczRz record);
}