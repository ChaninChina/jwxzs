package com.mapper;

import com.model.YhczRz;

public interface YhczRzMapper {
    int deleteByPrimaryKey(String id);

    int insert(YhczRz record);

    int insertSelective(YhczRz record);

    YhczRz selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(YhczRz record);

    int updateByPrimaryKey(YhczRz record);
}