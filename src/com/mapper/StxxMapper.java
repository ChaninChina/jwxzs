package com.mapper;

import java.util.HashMap;
import java.util.List;

import com.model.Stxx;

public interface StxxMapper {
    int deleteByPrimaryKey(String stid);

    int insert(Stxx record);

    int insertSelective(Stxx record);

    Stxx selectByPrimaryKey(String stid);

    int updateByPrimaryKeySelective(Stxx record);

    int updateByPrimaryKey(Stxx record);

	/**
	 * @param paramMap
	 * @return
	 */
	List<Stxx> selectStxx(HashMap<String, Object> paramMap);
}