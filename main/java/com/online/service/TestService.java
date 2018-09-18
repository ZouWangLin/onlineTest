package com.online.service;

import java.util.List;
import java.util.Set;

import com.online.entity.Subject;
import com.online.util.E3Result;
import com.online.util.Page;

public interface TestService {
	/**
	 * 批量导入试题
	 * @param subjects	传入试题集合
	 * @return			返回E3Result对象
	 */
	public E3Result insertBatch(List<Subject> subjects);
	/**
	 * 分页显示数据
	 * @param page		传入当前页码
	 * @param size		传入当前页需要显示的记录条数
	 * @return			返回Page对象
	 */
	public Page<Subject> findTestByPages(int page, int size);
	/**
	 * 根据id查找试题
	 * @param subjectid	传入试题id
	 * @return			返回对应的试题Page对象
	 */
	public Subject findTestById(Integer subjectid);
	/**
	 * 根据主键删除数据
	 * @param subjectid	传入试题id
	 * @return			返回E3Result对象
	 */
	public E3Result deleteTest(Integer subjectid);
	/**
	 * 根据传入的对象对试题进行更新操作
	 * @param subject	传入的试题对象
	 * @return			返回E3Result对象
	 */
	public E3Result updateTest(Subject subject);
	/**
	 * 增加试题
	 * @param subject
	 */
	public void addTest(Subject subject);
	/**
	 * 搜索试题
	 * @param content	输入查找试题的关键字
	 * @param pageSize  传入每页显示多少条数据
	 * @param page      传入当前页码
	 */
	public Page<Subject> searchTest(String content, int page, int pageSize);
	/**
	 * 生成试卷
	 * @return	返回Subject对象集合
	 */
	public List<Subject> createTest();
	/**
	 * 生成试卷（用户重复刷新的时候）
	 * @param ids	试题id集合
	 * @return
	 */
	public List<Subject> findByList(List<String> ids);

}
