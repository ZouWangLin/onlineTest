package com.online.controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.online.entity.Subject;
import com.online.service.TestService;
import com.online.util.CookieUtils;
import com.online.util.E3Result;
import com.online.util.JsonUtils;
import com.online.util.Page;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateNotFoundException;

/**
 * 试题控制器类
 * 
 * @author 26282
 *
 */
@Controller
public class TestController {
	@Autowired
	private TestService testService;

	/**
	 * 批量导入试题模块
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/import/batchImport")
	@ResponseBody
	public Boolean batchImport(MultipartFile importFile) throws IOException {
		// 1.获取原文件名
		String name = importFile.getOriginalFilename();
		// 2.获取原文件后缀名
		String extend = FilenameUtils.getExtension(name);
		if (!extend.equals("xls") && !extend.equals("xlsx")) {
			// return E3Result.build(500, "你上传的文件格式不对!");
			return false;
		}
		// 3.获取文件字节流
		InputStream inputStream = importFile.getInputStream();
		// 4.调用Hutool的ExcelUtil工具类
		ExcelReader reader = ExcelUtil.getReader(inputStream);
		// 5.利用工具类将reader中的数据封装成一个个对象，最终形成一个List集合
		List<Subject> subjects = reader.readAll(Subject.class);
		for (Subject subject : subjects) {
			System.out.println(subject);
		}
		// 6.调用service，将数据填充进数据库，返回对应的E3Result对象
		E3Result e3Result = testService.insertBatch(subjects);
		if (e3Result.getStatus() != 200) {
			return false;
		}
		return true;
	}

	/**
	 * 根据用户传入的当前页数和每页显示的条数，返回对应的数据
	 * 
	 * @param page
	 *            当前页数
	 * @param size
	 *            每页显示的记录数
	 * @return 返回数据集合
	 */
	@RequestMapping("/managerTest/showTest")
	public String showTest(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "pageSize", defaultValue = "5") int pageSize, Model model) {
		// 1.调用service，获取对应的page对象
		@SuppressWarnings("unchecked")
		Page<Subject> data = testService.findTestByPages(page, pageSize);
		// 2.将page对象中的数据填充到域中，由于NavigationTag需要所以这里一定要写page
		model.addAttribute("page", data);
		// 3.页面跳转
		return "managerTest";
	}

	/**
	 * 根据用户传入的id查找对应的试题
	 * 
	 * @param subjectid
	 *            试题Id
	 * @return 返回试题对象
	 */
	@RequestMapping("/managerTest/viewTest")
	@ResponseBody
	public Subject viewTest(@RequestParam Integer subjectid, Model model) {
		// 1.调用service，获取对应的试题对象
		Subject subject = testService.findTestById(subjectid);
		return subject;
	}

	/**
	 * 根据用户传入的id删除对应的试题
	 * 
	 * @param subjectid
	 * @return
	 */
	@RequestMapping("/managerTest/deleteTest")
	@ResponseBody
	public E3Result deleteTest(@RequestParam Integer subjectid) {
		// 1.调用service,对试题进行删除
		E3Result e3Result = testService.deleteTest(subjectid);
		return e3Result;
	}

	/**
	 * 更新试题
	 * 
	 * @param subject
	 *            从表单获取到的数据封装成subject对象
	 * @return 返回E3Result对象
	 */
	@RequestMapping("/managerTest/updateTest")
	@ResponseBody
	public E3Result updateTest(Subject subject) {
		// 1.调用service，对试题进行更新操作
		E3Result e3Result = testService.updateTest(subject);
		return e3Result;
	}

	/**
	 * 一个个的添加试题
	 * 
	 * @param subject
	 *            从表单获取到的数据封装成subject对象
	 */
	@RequestMapping("/import/oneImport")
	public String addTest(Subject subject) {
		// 1.调用service，对试题进行增加操作
		testService.addTest(subject);
		return "importTest";
	}

	/**
	 * 搜索试题，高亮显示搜索的关键字
	 * 
	 * @param content
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/search/searchTest")
	public String searchTest(String searchContent, @RequestParam(defaultValue = "1", value = "page") int page,
			@RequestParam(defaultValue = "5", value = "pageSize") int pageSize, Model model) throws Exception {
		// 1.调用service，对试题进行solr搜索
		searchContent = new String(searchContent.getBytes("ISO8859-1"), "UTF-8");
		Page<Subject> pages = testService.searchTest(searchContent, page, pageSize);
		// 2.将对应的数据设置进域中
		model.addAttribute("page", pages);
		model.addAttribute("searchContent", searchContent);
		return "searchTest";
	}

	/**
	 * 生产试题 1.如果cookie中没有试题就从数据库中随机生成 2.如果cookie中有试题就从cookie中获取试题
	 * 
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 * @throws MalformedTemplateNameException
	 * @throws TemplateNotFoundException
	 */
	@RequestMapping("/student/test")
	public String toTest(Model model, HttpServletRequest request, HttpServletResponse response)
			throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException {
		// 定义试题集合对象
		List<Subject> datas = null;

		// 1.从cookie中获取数据
		String datasString = CookieUtils.getCookieValue(request, "ids", "UTF-8");
		// 2.说明有数据
		if (StringUtils.isNotBlank(datasString)) {
			// 3.进行字符串转list
			List<String> ids = JsonUtils.jsonToList(datasString, String.class);
			// 4.调用service同样获取试题
			datas = testService.findByList(ids);
		} else {
			// 1.调用service获取试题
			datas = testService.createTest();
			List<String> ids = new LinkedList<String>();
			for (Subject subject : datas) {
				ids.add(subject.getSubjectid() + "");
			}
			// 3.将数据写入cookie中，设置存活时间为30分钟
			CookieUtils.setCookie(request, response, "ids", JsonUtils.objectToJson(ids), 60 * 30, true);
		}
		// 3.将数据填充进域中
		model.addAttribute("datas", datas);
		// 4.设置考试开始时间
		HttpSession session = request.getSession();
		if (session.getAttribute("times") == null) {
			Date currentDate = new Date();
			Long endDate = currentDate.getTime() + 30 * 1000 * 60;
			session.setAttribute("times", new SimpleDateFormat("yyyy/MM/dd,HH:mm:ss").format(new Date(endDate)));
		}

		// 5.页面跳转
		return "studentTest";

	}

}
