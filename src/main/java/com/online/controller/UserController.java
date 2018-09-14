package com.online.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.online.entity.QueryVo;
import com.online.entity.Student;
import com.online.entity.Subject;
import com.online.entity.Teacher;
import com.online.service.UserService;
import com.online.util.E3Result;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateNotFoundException;

/**
 * 用户控制类
 * @author 26282
 *
 */
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;
	@Value("${HTML_GEN_PATH}")
	private String path;
	/**
	 * 用户的登录
	 * @param role		用户的角色
	 * @return
	 */
	@RequestMapping("/user/loginCheck")
	@ResponseBody
	public E3Result login(@RequestParam String role,String userId,String password,HttpSession session){
		//调用service
		E3Result e3Result=userService.checkLogin(role,userId,password);
		if(e3Result.getStatus()==200&&e3Result.getMsg().equals("teacher")){
			//存储进session中
			session.setAttribute("teacher", (Teacher)e3Result.getData());
		}else{
			//存储进session中
			session.setAttribute("student", (Student)e3Result.getData());
		}
		return e3Result;
	}
	/**
	 * 统计学生的考试分数，答案是否正确
	 * @param result	试题id+学生答案组成的字符串集合
	 * @return			跳转到分数显示页面
	 * @throws IOException 
	 * @throws ParseException 
	 * @throws MalformedTemplateNameException 
	 * @throws TemplateNotFoundException 
	 */
	@RequestMapping("/student/calcStudentScore")
	public String calcStudentScore(QueryVo queryVo,Model model,HttpSession session) throws Exception{
		//1.调用service获取成绩，获取解析
		E3Result e3Result=userService.calcStudentScore(queryVo.getResult());
		//2.填充数据
		model.addAttribute("e3Result", e3Result);
		/**
		 * 生成静态模板模块，方便老师查看当前学生的考试情况
		 */
		//1.获取Configuration对象
		Configuration configuration = freeMarkerConfigurer.getConfiguration();
		//2.获取template对象
		Template template = configuration.getTemplate("showScore.ftl");
		//3.创建数据集
		Map<String,Object> data=new HashMap<String,Object>();
		//4.添加数据
		data.put("subjects", (List<Subject>)e3Result.getData());
		//5.获取session中的user对象
		Student student = (Student) session.getAttribute("student");
		student.setResult(Integer.parseInt(e3Result.getMsg()));//设置分数
		data.put("student", student);//加入map集合中去
		//6.创建writer对象
		Writer fileWriter = new FileWriter(new File(path+"/"+student.getStudentid()+".html"));
		//7.调用process方法写出
		template.process(data, fileWriter);
		//8.关闭流
		fileWriter.close();
		//9.更新学生成绩
		userService.setScore(student);
		//9.页面跳转
		return "showScore";
	}
	
	/**
	 * 用户的退出
	 * @param request
	 * @return
	 */
	@RequestMapping("/user/userOut")
	@ResponseBody
	public E3Result userOut(HttpServletRequest request){
		//1.获取session
		HttpSession session=request.getSession();
		//2.判断session
		if(session.getAttribute("student")!=null){
			//3.进行session销毁操作
			session.setAttribute("student", null);
		}
		if(session.getAttribute("teacher")!=null){
			//3.进行session销毁操作
			session.setAttribute("teacher", null);
		}
		return E3Result.ok();
	}
	
	/**
	 * 根据当前学生学号查找当前学生个人信息
	 * @param searchContent
	 * @return
	 */
	@RequestMapping("/search/searchStudent")
	public String searchStudent(String searchContent,Model model){
		String className= null;
		//1.设置学生id初始值为0
		int studentId=0;
		//2.防止用户输入非法数据
		try{
			studentId=Integer.parseInt(searchContent);
		}catch(Exception exception){
			return "searchStudent";
		}
		//3.执行查询
		Student student=userService.searchStudentByNo(studentId);
		if(student!=null){
			className=userService.searchClassNameByClassNo(student.getClassno());
		}
		//4.将数据设置到域中
		model.addAttribute("student", student);
		model.addAttribute("searchContent", searchContent);
		model.addAttribute("classname", className);
		//5.页面跳转
		return "searchStudent";
		
	}

}
