package com.mapper;

import com.model.Tmmb;

public interface TmmbMapper {
    int deleteByPrimaryKey(String tmmbid);

    int insert(Tmmb record);

    int insertSelective(Tmmb record);

    Tmmb selectByPrimaryKey(String tmmbid);

    int updateByPrimaryKeySelective(Tmmb record);

    int updateByPrimaryKey(Tmmb record);
}