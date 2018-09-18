package com.online.service;

import java.util.List;

import com.online.entity.Student;
import com.online.util.Page;

/**
 * 学生service层
 * @author 26282
 *
 */
public interface StudentService {
	/**
	 * 根据班级号查找学生
	 * @param classno
	 * @return
	 */
	List<Student> findByClassNo(int classno);
	/**
	 * 根据班级号分页查找当前班级下的所有学生
	 * @param classno
	 * @param page
	 * @param pageSize
	 */
	Page<Student> selectStudentByClassno(int classno, int page, int pageSize);
	/**
	 * 根据班级号查找当前班级下的所有学生
	 * @param classno
	 * @return
	 */
	List<Student> selectStudentByNo(int classno);

}
