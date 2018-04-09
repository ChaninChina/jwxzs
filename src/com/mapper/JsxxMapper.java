package com.mapper;

import com.model.Jsxx;

public interface JsxxMapper {
    int deleteByPrimaryKey(String jsid);

    int insert(Jsxx record);

    int insertSelective(Jsxx record);

    Jsxx selectByPrimaryKey(String jsid);

    int updateByPrimaryKeySelective(Jsxx record);

    int updateByPrimaryKey(Jsxx record);
}