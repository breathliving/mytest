package com.itheima.ssm.mapper;

import java.util.List;

import com.itheima.ssm.pojo.BaseDict;

public interface BaseDictMapper {
	
	public List<BaseDict> findBaseDictByTypeCode(String typeCode);
}
