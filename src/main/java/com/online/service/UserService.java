package com.online.service;

import java.util.List;

import com.online.entity.Student;
import com.online.util.E3Result;

/**
 * 用户服务层
 * @author 26282
 *
 */
public interface UserService {
	/**
	 * 确认用户的登录
	 * @param role		用户的角色
	 * @param username	用户id号
	 * @param password	密码
	 * @return
	 */
	E3Result checkLogin(String role, String userId, String password);
	/**
	 * 计算学生分数
	 * @param result	试题id+学生答案集合
	 * @return
	 */
	E3Result calcStudentScore(List<String> result);
	/**
	 * 设置学生成绩
	 * @param student
	 */
	void setScore(Student student);
	/**
	 * 根据学生学号查找学生的个人信息
	 * @param studentId
	 * @return
	 */
	Student searchStudentByNo(int studentId);
	/**
	 * 根据当前学生的班级号，查询学生所在的班级名
	 * @param classno		学生班级号
	 * @return				学生班级名
	 */
	String searchClassNameByClassNo(Integer classno);

}
