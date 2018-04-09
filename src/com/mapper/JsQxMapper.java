package com.mapper;

import com.model.JsQx;

public interface JsQxMapper {
    int deleteByPrimaryKey(String jsQxId);

    int insert(JsQx record);

    int insertSelective(JsQx record);

    JsQx selectByPrimaryKey(String jsQxId);

    int updateByPrimaryKeySelective(JsQx record);

    int updateByPrimaryKey(JsQx record);
}