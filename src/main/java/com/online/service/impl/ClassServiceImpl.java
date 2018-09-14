package com.online.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.dao.TbClassMapper;
import com.online.entity.TbClass;
import com.online.entity.TbClassExample;
import com.online.service.ClassService;
@Service
public class ClassServiceImpl implements ClassService {
	@Autowired
	private TbClassMapper tbClassMapper;
	@Override
	public List<TbClass> selectAll() {
		TbClassExample example=new TbClassExample();
		List<TbClass> classs = tbClassMapper.selectByExample(example);
		return classs;
	}
	@Override
	public void exportClass(int classno) {
		
	}

}
