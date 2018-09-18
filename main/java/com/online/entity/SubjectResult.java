package com.online.entity;

/**
 * 试题结果对象(在subject基础上添加用户答案属性)
 * 
 * @author 26282
 *
 */
public class SubjectResult extends Subject {
	private String studentAnswer;// 当前题用户答案
	
	public SubjectResult(){
		super();
	}
	
	public SubjectResult(Integer subjectid,String subjecttitle,String subjectoptiona
			,String subjectoptionb,String subjectoptionc,String subjectoptiond
			,String subjectanswer,String subjectparse) {
		super(subjectid,subjecttitle,subjectoptiona
				,subjectoptionb,subjectoptionc,subjectoptiond
				,subjectanswer,subjectparse);
	}

	public String getStudentAnswer() {
		return studentAnswer;
	}

	public void setStudentAnswer(String studentAnswer) {
		this.studentAnswer = studentAnswer;
	}
	
	

}
