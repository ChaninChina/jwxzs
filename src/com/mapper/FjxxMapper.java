package com.mapper;

import java.util.HashMap;
import java.util.List;

import com.model.Fjxx;

public interface FjxxMapper {
    int deleteByPrimaryKey(String fjid);

    int insert(Fjxx record);

    int insertSelective(Fjxx record);

    Fjxx selectByPrimaryKey(String fjid);

    int updateByPrimaryKeySelective(Fjxx record);

    int updateByPrimaryKey(Fjxx record);

	List<Fjxx> selectStFjxx(HashMap<String, String> stFjMap);

	List<Fjxx> selectRwjlTmfj(HashMap<String, Object> p3);

	String selectRwfj(HashMap<String, Object> hashMap);
}