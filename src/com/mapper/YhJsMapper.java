package com.mapper;

import com.model.YhJs;

public interface YhJsMapper {
    int deleteByPrimaryKey(String yhJsId);

    int insert(YhJs record);

    int insertSelective(YhJs record);

    YhJs selectByPrimaryKey(String yhJsId);

    int updateByPrimaryKeySelective(YhJs record);

    int updateByPrimaryKey(YhJs record);
}