package com.online.service;

import java.util.List;

import com.online.entity.TbClass;

/**
 * 班级Service
 * @author 26282
 *
 */
public interface ClassService {
	/**
	 * 查询所有的班级对象
	 * @return	返回班级对象集合
	 */
	List<TbClass> selectAll();
	/**
	 * 导出成绩
	 * @param classno
	 */
	void exportClass(int classno);

}
