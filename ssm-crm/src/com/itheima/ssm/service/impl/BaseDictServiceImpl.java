package com.itheima.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.ssm.mapper.BaseDictMapper;
import com.itheima.ssm.pojo.BaseDict;
import com.itheima.ssm.service.BaseDictService;

@Service

public class BaseDictServiceImpl implements BaseDictService {
	@Autowired
	private BaseDictMapper baseDictMapper;
	@Override
	public List<BaseDict> findBaseDictBySourceCode(String sourceCode) {
		
		return baseDictMapper.findBaseDictByTypeCode(sourceCode);
	}

	@Override
	public List<BaseDict> findBaseDictByIndustoryCode(String industoryCode) {
		// TODO Auto-generated method stub
		return baseDictMapper.findBaseDictByTypeCode(industoryCode);
	}

	@Override
	public List<BaseDict> findBaseDictByLevelCode(String levelCode) {
		// TODO Auto-generated method stub
		return baseDictMapper.findBaseDictByTypeCode(levelCode);
	}

}
