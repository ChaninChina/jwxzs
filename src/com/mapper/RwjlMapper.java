package com.mapper;

import java.util.HashMap;
import java.util.List;

import com.model.Rwjl;
import com.util.page.PageResult;

public interface RwjlMapper {
    int deleteByPrimaryKey(String rwjlid);

    int insert(Rwjl record);

    int insertSelective(Rwjl record);

    Rwjl selectByPrimaryKey(String rwjlid);

    int updateByPrimaryKeySelective(Rwjl record);

    int updateByPrimaryKey(Rwjl record);

	List<Rwjl> selectRwjl(HashMap<String, Object> paramMap);
	
	int searchRwjlOfSize(HashMap<String, Object> paramMap);
	
	List<Rwjl> searchRwjlOfList(HashMap<String, Object> paramMap);


}