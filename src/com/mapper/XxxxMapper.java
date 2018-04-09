package com.mapper;

import java.util.HashMap;
import java.util.List;

import com.model.Strw;
import com.model.Xxxx;

public interface XxxxMapper {
    int deleteByPrimaryKey(String xxid);

    int insert(Xxxx record);

    int insertSelective(Xxxx record);

    Xxxx selectByPrimaryKey(String xxid);

    int updateByPrimaryKeySelective(Xxxx record);

    int updateByPrimaryKey(Xxxx record);

	List<Xxxx> selectXxxx(HashMap<String, Object> paramMap);
	
	Integer searchXxxxOfSize(HashMap<String, Object> paramMap);

	List<Xxxx> searchXxxxOfList(HashMap<String, Object> paramMap);

	void autoInsertXxxx(HashMap<String, Object> hashMap);
}