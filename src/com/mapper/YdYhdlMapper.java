package com.mapper;

import java.util.HashMap;
import java.util.List;

import com.model.YdYhdl;

public interface YdYhdlMapper {
    int deleteByPrimaryKey(String yhid);

    int insert(YdYhdl record);

    int insertSelective(YdYhdl record);

    YdYhdl selectByPrimaryKey(String yhid);

    int updateByPrimaryKeySelective(YdYhdl record);

    int updateByPrimaryKey(YdYhdl record);
    
    List<YdYhdl> selectYdYhdl(HashMap<String, Object> paramMap);
}