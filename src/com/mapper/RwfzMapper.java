package com.mapper;

import com.model.Rwfz;

public interface RwfzMapper {
    int deleteByPrimaryKey(String rwfzid);

    int insert(Rwfz record);

    int insertSelective(Rwfz record);

    Rwfz selectByPrimaryKey(String rwfzid);

    int updateByPrimaryKeySelective(Rwfz record);

    int updateByPrimaryKey(Rwfz record);
}