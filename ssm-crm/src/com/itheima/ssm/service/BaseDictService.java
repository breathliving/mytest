package com.itheima.ssm.service;

import java.util.List;

import com.itheima.ssm.pojo.BaseDict;

public interface BaseDictService {

	List<BaseDict> findBaseDictBySourceCode(String sourceCode);

	List<BaseDict> findBaseDictByIndustoryCode(String industoryCode);

	List<BaseDict> findBaseDictByLevelCode(String levelCode);

}
