package com.mapper;

import java.util.HashMap;
import java.util.List;

import com.model.Yhxx;

public interface YhxxMapper {
    int deleteByPrimaryKey(String yhid);

    int insert(Yhxx record);

    int insertSelective(Yhxx record);

    Yhxx selectByPrimaryKey(String yhid);

    int updateByPrimaryKeySelective(Yhxx record);

    int updateByPrimaryKey(Yhxx record);

	/**
	 * @param paramMap
	 * @return
	 */
	List<Yhxx> selectYhxx(HashMap<String, Object> paramMap);

	/**
	 * @param paramMap
	 * @return
	 */
	int updateYhxx(HashMap<String, Object> paramMap);

	Yhxx selectYhxxByToken(String token);
}