package com.online.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.online.entity.Student;
import com.online.entity.TbClass;
import com.online.service.ClassService;
import com.online.service.StudentService;
import com.online.service.UserService;
import com.online.util.Page;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;

@Controller
public class ClassController {
	@Autowired
	private ClassService classService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private UserService userService;

	/**
	 * 查询所有的班级
	 * 
	 * @return 返回TbClass对象集合
	 */
	@RequestMapping("/class/findAll")
	@ResponseBody
	public List<TbClass> selectClassName() {
		// 1.执行service查找所有的班级
		List<TbClass> classs = classService.selectAll();
		// 2.将对象转换成json传给前端
		return classs;
	}

	/**
	 * 根据classno分页查找当前班级下的学生
	 * 
	 * @param classno
	 *            班级号
	 * @param page
	 *            当前页码
	 * @param pageSize
	 *            每页显示的记录数
	 * @param model
	 * @return 返回逻辑视图
	 */
	@RequestMapping("/class/selectClass")
	public String selectClass(int classno, @RequestParam(defaultValue = "1", value = "page") int page,
			@RequestParam(defaultValue = "5", value = "pageSize") int pageSize, Model model) {
		String classname = null;
		// 1.调用service查找学生，获得page对象
		Page<Student> data = studentService.selectStudentByClassno(classno, page, pageSize);
		// 2.调用userService查找学生班级名
		if (classno != -1) {
			classname = userService.searchClassNameByClassNo(classno);
		}
		// 3.由于NavigationTag的存在，这里必须设置域为page
		model.addAttribute("page", data);
		model.addAttribute("classno", classno);
		model.addAttribute("classname", classname);
		// 4.页面跳转
		return "searchClass";

	}

	/**
	 * 导出成绩
	 * 
	 * @param classno
	 *            班级号
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/class/exportClass")
	public String exportClass(int classno, HttpServletResponse response, HttpServletRequest request) throws IOException {
		// 1.调用service根据班级号查找学生
		List<Student> datas = studentService.selectStudentByNo(classno);
		//2.根据班级号获取班级名
		String className = userService.searchClassNameByClassNo(classno);
		// 2.创建数据集合
		List<Map> result = new LinkedList<Map>();
		
		/* 导出成绩模块,利用Hutool工具 */
		// 1.通过工具类创建writer，默认创建xls格式
		ExcelWriter writer = ExcelUtil.getWriter();
		for (Student student : datas) {
			Map<String, Object> rows = new LinkedHashMap<String,Object>();
			rows.put("学生学号", student.getStudentid());
			rows.put("学生姓名", student.getUsername());
			rows.put("学生成绩", student.getResult());
			rows.put("学生所在班级", className);
			result.add(rows);
		}
		writer.merge(3, className+"班成绩表");
		// 2.一次性写出内容，使用默认样式
		writer.write(result);
		// 3.response为HttpServletResponse对象
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		// 4.test.xls是弹出下载对话框的文件名，不能为中文，中文请自行编码
		response.setHeader("Content-Disposition", "attachment;filename=classGrade.xls");
		ServletOutputStream out = response.getOutputStream();
		writer.flush(out);
		// 5.关闭writer，释放内存
		writer.close();
		return null;
	}

}
