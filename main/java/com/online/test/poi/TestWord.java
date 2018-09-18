package com.online.test.poi;

import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.online.dao.TeacherMapper;
import com.online.entity.Teacher;

public class TestWord {
	@Autowired
	private TeacherMapper teacherMapper;
	@Test  
	   public void testSimpleWrite() throws Exception {  
	      //新建一个文档  
	      XWPFDocument doc = new XWPFDocument();  
	      //创建一个段落  
	      XWPFParagraph para = doc.createParagraph();  
	       
	      //一个XWPFRun代表具有相同属性的一个区域。  
	      XWPFRun run = para.createRun();  
	      run.setBold(true); //加粗  
	      run.setText("加粗的内容");  
	      run = para.createRun();  
	      run.setColor("FF0000");  
	      run.setText("红色的字。");  
	      OutputStream os = new FileOutputStream("D:\\simpleWrite.docx");  
	      //把doc输出到输出流  
	      doc.write(os);  
	      os.close();
	   } 
	
	@Test
	public void testMapper(){
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		Teacher teacher = new Teacher();
		teacher.setTeacherid(100);
		teacher.setUsername("test");
		teacher.setPassword("test");
		teacherMapper.insert(teacher);
	}

}
