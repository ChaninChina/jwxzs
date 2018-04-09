package com.mapper;

import java.util.HashMap;
import java.util.List;

import com.model.Strw;

public interface StrwMapper {
    int deleteByPrimaryKey(String rwid);

    int insert(Strw record);

    int insertSelective(Strw record);

    Strw selectByPrimaryKey(String rwid);

    int updateByPrimaryKeySelective(Strw record);

    int updateByPrimaryKey(Strw record);

	List<Strw> selectStrw(HashMap<String, Object> paramMap);

	int checkPermission(HashMap<String, Object> paramMap);

	Integer searchStrwOfSize(HashMap<String, Object> paramMap);

	List<Strw> searchStrwOfList(HashMap<String, Object> paramMap);

	Integer searchStrwZtOfSize(HashMap<String, Object> paramMap);

	List<Strw> searchStrwZtOfList(HashMap<String, Object> paramMap);

	List<Strw> selectStrwWWC(HashMap<String, Object> paramMap);

	Integer searchStrwKeyOfSize(HashMap<String, Object> paramMap);

	List<Strw> searchStrwKeyOfList(HashMap<String, Object> paramMap);

	List<Strw> selectYhStrw(HashMap<String, Object> paramMap);



//	Integer searchStrwWWCOfSize(HashMap<String, Object> paramMap);
//
//	List<Strw> searchStrwWWCOfList(HashMap<String, Object> paramMap);
}