package com.mapper;

import java.util.HashMap;
import java.util.List;

import com.model.MbTmkz;

public interface MbTmkzMapper {
    int deleteByPrimaryKey(String kzid);

    int insert(MbTmkz record);

    int insertSelective(MbTmkz record);

    MbTmkz selectByPrimaryKey(String kzid);

    int updateByPrimaryKeySelective(MbTmkz record);

    int updateByPrimaryKey(MbTmkz record);

	List<MbTmkz> selectMbTmKz(HashMap<String, Object> p2);
}