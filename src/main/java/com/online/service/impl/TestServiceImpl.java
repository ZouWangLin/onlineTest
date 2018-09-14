package com.online.service.impl;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.online.dao.SubjectMapper;
import com.online.entity.Subject;
import com.online.entity.SubjectExample;
import com.online.service.TestService;
import com.online.util.E3Result;
import com.online.util.Page;

import cn.hutool.core.util.RandomUtil;
/**
 * 试题业务类
 * @author 26282
 *
 */
@Service
public class TestServiceImpl implements TestService {
	@Autowired
	private SubjectMapper subjectMapper;
	@Autowired
	private SolrServer solrServer;
	@Override
	public E3Result insertBatch(List<Subject> subjects) {
		//1.对数据进行判断
		if(subjects==null||subjects.size()==0){
			return E3Result.build(500, "上传失败!");
		}
		//2.如果传入的数据有效，就遍历集合
		for (Subject subject : subjects) {
			//3.将数据插入到数据库
			subjectMapper.insert(subject);
			//4.并给对应的试题添加索引库
			SolrInputDocument solrInputDoucment = new SolrInputDocument();//5.创建文件对象
			//6.将数据添加进域中
			solrInputDoucment.addField("id", subject.getSubjectid());
			solrInputDoucment.addField("subjecttitle", subject.getSubjecttitle());
			solrInputDoucment.addField("subjectoptiona", subject.getSubjectoptiona());
			solrInputDoucment.addField("subjectoptionb", subject.getSubjectoptionb());
			solrInputDoucment.addField("subjectoptionc", subject.getSubjectoptionc());
			solrInputDoucment.addField("subjectoptiond", subject.getSubjectoptiond());
			solrInputDoucment.addField("subjectanswer", subject.getSubjectanswer());
			solrInputDoucment.addField("subjectparse", subject.getSubjectparse());
			try {
				//7.将数据添加进solrServer中
				solrServer.add(solrInputDoucment);
				//8.提交
				solrServer.commit();
			} catch (SolrServerException | IOException e) {
				throw new RuntimeException("添加solr索引出问题!");
			}
			
		}
		return E3Result.ok();
	}
	@Override
	public Page<Subject> findTestByPages(int page, int size) {
		//1.创建一个Page对象，为其填充需要的数据
		Page<Subject> data = new Page<Subject>();
		//设置已经知道的数据
		data.setPage(page);
		data.setSize(size);
		//2.利用PageHelper设置起始页，和每页显示的记录数
		PageHelper.startPage(page, size);
		//3.执行查询，获取当页数据
		SubjectExample example=new SubjectExample();
		List<Subject> subjects = subjectMapper.selectByExample(example);
		//4.填充data的rows属性
		data.setRows(subjects);
		//5.利用PageInfo获取总页数
		PageInfo<Subject> pageInfo = new PageInfo<Subject>(subjects);
		data.setTotal(pageInfo.getTotal());
		//6.返回填充好数据的Page对象
		return data;
		
	}
	@Override
	public Subject findTestById(Integer subjectid) {
		Subject subject = subjectMapper.selectByPrimaryKey(subjectid);
		return subject;
	}
	@Override
	public E3Result deleteTest(Integer subjectid) {
		//1.调用删除方法
		int key = subjectMapper.deleteByPrimaryKey(subjectid);
		if(key==1){
			//2.删除solr索引库中的数据
			try {
				solrServer.deleteById(subjectid+"");
				solrServer.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return E3Result.ok();
		}
		return E3Result.build(500, "删除失败!");
	}
	@Override
	public E3Result updateTest(Subject subject) {
		//1.调用更新方法
		int key=subjectMapper.updateByPrimaryKeySelective(subject);
		if(key==1){
			//2.修改solr索引库中的数据
			SolrInputDocument solrInputDocument = new SolrInputDocument();
			solrInputDocument.addField("id", subject.getSubjectid());
			solrInputDocument.addField("subjecttitle", subject.getSubjecttitle());
			solrInputDocument.addField("subjectoptiona", subject.getSubjectoptiona());
			solrInputDocument.addField("subjectoptionb", subject.getSubjectoptionb());
			solrInputDocument.addField("subjectoptionc", subject.getSubjectoptionc());
			solrInputDocument.addField("subjectoptiond", subject.getSubjectoptiond());
			solrInputDocument.addField("subjectanswer", subject.getSubjectanswer());
			solrInputDocument.addField("subjectparse", subject.getSubjectparse());
			try {
				solrServer.add(solrInputDocument);
				//提交
				solrServer.commit();
			} catch (SolrServerException | IOException e) {
				e.printStackTrace();
			}
			return E3Result.ok();
		}
		return E3Result.build(500, "删除失败!");
	}
	@Override
	public void addTest(Subject subject) {
		subjectMapper.insert(subject);
		SolrInputDocument solrInputDoucment = new SolrInputDocument();//5.创建文件对象
		//6.将数据添加进域中
		solrInputDoucment.addField("id", subject.getSubjectid());
		solrInputDoucment.addField("subjecttitle", subject.getSubjecttitle());
		solrInputDoucment.addField("subjectoptiona", subject.getSubjectoptiona());
		solrInputDoucment.addField("subjectoptionb", subject.getSubjectoptionb());
		solrInputDoucment.addField("subjectoptionc", subject.getSubjectoptionc());
		solrInputDoucment.addField("subjectoptiond", subject.getSubjectoptiond());
		solrInputDoucment.addField("subjectanswer", subject.getSubjectanswer());
		solrInputDoucment.addField("subjectparse", subject.getSubjectparse());
		try {
			//7.将数据添加进solrServer中
			solrServer.add(solrInputDoucment);
			//8.提交
			solrServer.commit();
		} catch (SolrServerException | IOException e) {
			throw new RuntimeException("添加solr索引出问题!");
		}
	}
	
	@Override
	public Page<Subject> searchTest(String content, int page, int pageSize) {
		Page<Subject> pages = new Page<Subject>();
		List<Subject> datas = new LinkedList<Subject>();
		//1.创建查询对象
		SolrQuery solrQuery = new SolrQuery();
		//2.设置默认查找域
		solrQuery.set("df", "subject_keywords");
		solrQuery.setQuery(content);
		//3.设置分页相关的
		if(page<=0){
			page=1;
		}
		solrQuery.setStart((page-1)*pageSize);//设置起始页
		solrQuery.setRows(pageSize);//设置当前页显示的数据条数
		solrQuery.setHighlight(true);//开启高亮
		solrQuery.addHighlightField("subjecttitle,subjectoptiona,subjectoptionb,subjectoptionc,"
				+ "subjectoptiond,"+"subjectparse");//设置高亮域
		solrQuery.setHighlightSimplePre("<font color='red'>");//设置前缀
		solrQuery.setHighlightSimplePost("</font>");//设置后缀
		//4.执行查询
		QueryResponse queryResponse = null;
		try {
			queryResponse=solrServer.query(solrQuery);
		} catch (SolrServerException e) {
			throw new RuntimeException("solr搜索出问题了!");
		}
		//5.获取查询的结果
		SolrDocumentList results = queryResponse.getResults();
		long numFound = results.getNumFound();//获取总记录数
		//6.设置总记录数
		pages.setTotal(numFound);
		//7.获取高亮域
		Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
		for (SolrDocument solrDocument : results) {
			//8.创建Subject对象，设置属性
			Subject subject = new  Subject();
			subject.setSubjectid(Integer.parseInt((String) solrDocument.get("id")));
			//9.高亮显示上面指定的域
			String subjecttitle=null;
			subjecttitle=changeHighLine("subjecttitle",highlighting,solrDocument);
			
			String subjectoptiona=null;
			subjectoptiona=changeHighLine("subjectoptiona",highlighting,solrDocument);
			
			String subjectoptionb=null;
			subjectoptionb=changeHighLine("subjectoptionb",highlighting,solrDocument);
			
			String subjectoptionc=null;
			subjectoptionc=changeHighLine("subjectoptionc",highlighting,solrDocument);
			
			String subjectoptiond=null;
			subjectoptiond=changeHighLine("subjectoptiond",highlighting,solrDocument);
			
			String subjectparse=null;
			subjectparse=changeHighLine("subjectparse",highlighting,solrDocument);
			
			//设置属性
			subject.setSubjecttitle(subjecttitle);
			subject.setSubjectoptiona(subjectoptiona);
			subject.setSubjectoptionb(subjectoptionb);
			subject.setSubjectoptionc(subjectoptionc);
			subject.setSubjectoptiond(subjectoptiond);
			subject.setSubjectparse(subjectparse);
			subject.setSubjectanswer((String)solrDocument.get("subjectanswer"));
			//10.数据填充
			datas.add(subject);
		}
		//11.设置进page对象中
		pages.setRows(datas);
		pages.setSize(pageSize);
		pages.setPage(page);
		return pages;
	}
	/**
	 * 给对应的属性设置高亮的前缀后后缀
	 * @param property		对应的属性值
	 * @param highlighting	高亮集合
	 * @return				返回修改后的值
	 */
	public String changeHighLine(String property,Map<String, Map<String, List<String>>> highlighting
			,SolrDocument solrDocument){
		List<String> propertyList = highlighting.get(solrDocument.get("id")).get(property);
		if(propertyList!=null&&propertyList.size()>0){
			property=propertyList.get(0);//添加修饰后的值
		}else{
			property=(String) solrDocument.get(property);//原始值
		}
		return property;
	}
	
	
	@Override
	public List<Subject> createTest() {
		//1.利用dao从数据库中获取所有试题
		SubjectExample example=new SubjectExample();
		List<Subject> subjects = subjectMapper.selectByExample(example);
		//2.调用hutool获取10道不重复的试题
		Set<Subject> datas = RandomUtil.randomEleSet(subjects, 10);
		//3.进行转换
		return new LinkedList<Subject>(datas);
	}
	@Override
	public List<Subject> findByList(List<String> ids) {
		//1.创建对象
		LinkedList<Subject> list = new LinkedList<Subject>();
		//2.调用map
		for (String id : ids) {
			//3.调用方法根据id查找试题对象
			Subject subject = subjectMapper.selectByPrimaryKey(Integer.parseInt(id));
			list.add(subject);
		}
		return list;
	}

}
