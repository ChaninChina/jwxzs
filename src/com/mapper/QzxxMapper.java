package com.mapper;

import java.util.HashMap;
import java.util.List;

import com.model.Qzxx;

public interface QzxxMapper {
    int deleteByPrimaryKey(String qzid);

    int insert(Qzxx record);

    int insertSelective(Qzxx record);

    Qzxx selectByPrimaryKey(String qzid);

    int updateByPrimaryKeySelective(Qzxx record);

    int updateByPrimaryKey(Qzxx record);

	List<Qzxx> selectQzxx(HashMap<String, Object> paramMap);

	List<Qzxx> selectQzxxByQzBzm(HashMap<String, Object> paramMap);
}