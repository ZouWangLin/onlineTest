package com.online.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.online.dao.StudentMapper;
import com.online.entity.Student;
import com.online.entity.StudentExample;
import com.online.entity.StudentExample.Criteria;
import com.online.service.StudentService;
import com.online.util.Page;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentMapper studentMapper;
	@Override
	public List<Student> findByClassNo(int classno) {
		//设置查询条件
		StudentExample example=new StudentExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andClassnoEqualTo(classno);
		//执行查询
		List<Student> list = studentMapper.selectByExample(example);
		return list;
	}
	@Override
	public Page<Student> selectStudentByClassno(int classno, int page, int pageSize) {
		//设置已经知道的属性值
		Page<Student> data = new Page<Student>();//创建page对象
		data.setPage(page);//设置当前页
		data.setSize(pageSize);//设置每页显示的条数
		
		
		//1.设置查询条件
		PageHelper.startPage(page, pageSize);//设置起始页和每页显示的条数
		StudentExample example=new StudentExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andClassnoEqualTo(classno);
		//2.执行查询
		List<Student> rows = studentMapper.selectByExample(example);
		//3.利用pageInfo获取总页数等数据
		PageInfo<Student> pageInfo = new PageInfo<Student>(rows);
		
		
		//设置获取到的属性
		data.setRows(rows);//填充list集合数据
		data.setTotal(pageInfo.getTotal());//填充总页数
		return data;
	}
	@Override
	public List<Student> selectStudentByNo(int classno) {
		//1.创建需要的对象
		StudentExample example=new StudentExample();
		Criteria createCriteria = example.createCriteria();
		//2.设置查询的条件
		createCriteria.andClassnoEqualTo(classno);
		//3.执行查询
		List<Student> data = studentMapper.selectByExample(example);
		return data;
	}

}
