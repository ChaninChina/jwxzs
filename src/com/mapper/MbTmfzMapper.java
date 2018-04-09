package com.mapper;

import java.util.HashMap;
import java.util.List;

import com.model.MbTmfz;

public interface MbTmfzMapper {
    int deleteByPrimaryKey(String tmfzid);

    int insert(MbTmfz record);

    int insertSelective(MbTmfz record);

    MbTmfz selectByPrimaryKey(String tmfzid);

    int updateByPrimaryKeySelective(MbTmfz record);

    int updateByPrimaryKey(MbTmfz record);

	/**
	 * @param p2
	 * @return
	 */
	List<MbTmfz> selectMbTmFz(HashMap<String, Object> p2);
}