package com.mapper;

import com.model.Yhdl;

public interface YhdlMapper {
    int deleteByPrimaryKey(String id);

    int insert(Yhdl record);

    int insertSelective(Yhdl record);

    Yhdl selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Yhdl record);

    int updateByPrimaryKeyWithBLOBs(Yhdl record);

    int updateByPrimaryKey(Yhdl record);
}