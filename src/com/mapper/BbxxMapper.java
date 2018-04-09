package com.mapper;

import java.util.List;
import java.util.Map;

import com.model.Bbxx;

public interface BbxxMapper {
    int deleteByPrimaryKey(String bbid);

    int insert(Bbxx record);

    int insertSelective(Bbxx record);

    Bbxx selectByPrimaryKey(String bbid);

    int updateByPrimaryKeySelective(Bbxx record);

    int updateByPrimaryKey(Bbxx record);

	/**
	 * @param paramMap
	 * @return
	 */
	List<Bbxx> selectBbxx(Map<String, Object> paramMap);
}