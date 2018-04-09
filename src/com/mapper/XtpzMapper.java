package com.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.model.Xtpz;

public interface XtpzMapper {
    int deleteByPrimaryKey(String pzid);

    int insert(Xtpz record);

    int insertSelective(Xtpz record);

    Xtpz selectByPrimaryKey(String pzid);

    int updateByPrimaryKeySelective(Xtpz record);

    int updateByPrimaryKey(Xtpz record);

	/**
	 * @param paramMap
	 * @return
	 */
	List<Xtpz> selectXtpz(Map<String, String> paramMap);

	int selectCount(HashMap<String, Object> paramMap);
}