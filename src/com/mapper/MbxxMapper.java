package com.mapper;

import java.util.HashMap;
import java.util.List;

import com.model.Mbxx;

public interface MbxxMapper {
    int deleteByPrimaryKey(String mbid);

    int insert(Mbxx record);

    int insertSelective(Mbxx record);

    Mbxx selectByPrimaryKey(String mbid);

    int updateByPrimaryKeySelective(Mbxx record);

    int updateByPrimaryKey(Mbxx record);

	/**
	 * @param paramMap
	 * @return
	 */
	List<Mbxx> selectMbXx(HashMap<String, String> paramMap);

	List<Mbxx> selectMbxxByRwid(HashMap<String, Object> paramMap);
}