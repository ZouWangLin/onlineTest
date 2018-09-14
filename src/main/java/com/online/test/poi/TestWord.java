/*package com.online.test.poi;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.Test;

public class TestWord {
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

}
*/