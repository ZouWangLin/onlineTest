package com.online.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.online.dao.StudentMapper;
import com.online.dao.SubjectMapper;
import com.online.dao.TbClassMapper;
import com.online.dao.TeacherMapper;
import com.online.entity.Student;
import com.online.entity.StudentExample;
import com.online.entity.Subject;
import com.online.entity.SubjectResult;
import com.online.entity.TbClass;
import com.online.entity.Teacher;
import com.online.entity.TeacherExample;
import com.online.entity.TeacherExample.Criteria;
import com.online.service.UserService;
import com.online.util.E3Result;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private TeacherMapper teacherMapper;
	@Autowired
	private SubjectMapper subjectMapper;
	@Autowired
	private TbClassMapper tbClassMapper;
	@Override
	public E3Result checkLogin(String role, String userId, String password) {
		Integer userIdInfo = null;
		try{
			userIdInfo=Integer.parseInt(userId);
		}catch(Exception exception){
			userIdInfo=0;
		}
		
		//1.根据角色的不同做出不同的反应
		if("teacher".equals(role)){
			//2.(教师模块)设置查询条件
			TeacherExample example=new TeacherExample();
			Criteria createCriteria = example.createCriteria();
			createCriteria.andTeacheridEqualTo(userIdInfo);
			//3.执行查询
			List<Teacher> data = teacherMapper.selectByExample(example);
			if(data==null||data.size()<=0){
				//4.没有查询到结果
				return E3Result.build(500, "用户名不存在!");
			}
			//5.如果当前用户名存在
			if(!data.get(0).getPassword().equals(password)){
				//6.密码错误
				return E3Result.build(500, "密码错误!");
			}
			return E3Result.build(200, "teacher", data.get(0));
		}else if("student".equals(role)){
			//2.(学生模块)设置查询条件
			StudentExample example=new StudentExample();
			com.online.entity.StudentExample.Criteria createCriteria = example.createCriteria();
			createCriteria.andStudentidEqualTo(userIdInfo);
			//3.执行查询
			List<Student> data = studentMapper.selectByExample(example);
			if(data==null||data.size()<=0){
				//4.没有查询到结果
				return E3Result.build(500, "用户名不存在!");
			}
			//5.如果当前用户名存在
			if(!data.get(0).getPassword().equals(password)){
				//6.密码错误
				return E3Result.build(500, "密码错误!");
			}
			return E3Result.build(200, "student", data.get(0));
		}else{
			return E3Result.build(500, "非法登录!");
		}
	}
	@Override
	public E3Result calcStudentScore(List<String> result) {
		//定义一个集合存储所有试题数据
		List<SubjectResult> list = new LinkedList<SubjectResult>();
		//定义初始分数
		int score=0;
		//1.遍历result集合
		for (String string : result) {
			//2.切割数据,info[0]代表用户的答案，info[1]代表当前试题id
			String[] info = string.split("-");
			//3.根据试题id获取试题对象
			Subject subject = subjectMapper.selectByPrimaryKey(Integer.parseInt(info[1]));
			//4.进行结果判定
			if(subject.getSubjectanswer().equals(info[0])){
				//5.说明答对试题
				score+=10;//加分操作
			}
			//6.填充数据 第一个参数填充状态，第二个参数填充分数，第三个参数填充变形后的subject对象
			SubjectResult subjectResult = new SubjectResult(subject.getSubjectid(),subject.getSubjecttitle(),subject.getSubjectoptiona()
					,subject.getSubjectoptionb(),subject.getSubjectoptionc(),subject.getSubjectoptiond(),
					subject.getSubjectanswer(),subject.getSubjectparse());
			subjectResult.setStudentAnswer(info[0]);
			list.add(subjectResult);//将当前试题加入集合中，方便后续给用户展示试题
		}
		return E3Result.build(200, score+"", list);
	}
	@Override
	public void setScore(Student student) {
		studentMapper.updateByPrimaryKeySelective(student);
	}
	@Override
	public Student searchStudentByNo(int searchContent) {
		Student student = studentMapper.selectByPrimaryKey(searchContent);
		return student;
	}
	@Override
	public String searchClassNameByClassNo(Integer classno) {
		TbClass tbClass = tbClassMapper.selectByPrimaryKey(classno);
		return tbClass.getClassname();
	}

}
