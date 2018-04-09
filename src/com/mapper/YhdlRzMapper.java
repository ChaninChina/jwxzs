package com.mapper;

import com.model.YhdlRz;

public interface YhdlRzMapper {
    int deleteByPrimaryKey(String id);

    int insert(YhdlRz record);

    int insertSelective(YhdlRz record);

    YhdlRz selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(YhdlRz record);

    int updateByPrimaryKeyWithBLOBs(YhdlRz record);

    int updateByPrimaryKey(YhdlRz record);
}