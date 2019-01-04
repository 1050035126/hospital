package com.action;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.dao.AddCaseDao;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AddCase extends ActionSupport {
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getPatient() {
		return patient;
	}
	public void setPatient(String patient) {
		this.patient = patient;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	private String grade;
	private String doctor;
	private String text;
	private String patient;
	private String time;
	public String execute(){
		AddCaseDao acd=new AddCaseDao();
		Date d = new Date(); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        time = sdf.format(d); 
        System.out.println("这是正是医生添加的"+grade+" 医生"+doctor);
        if(grade.equals("1")) {
        	grade="1";
        }else {
        	grade="0";
        }
        if(acd.addCase(text, patient, time, doctor, grade)) {
        	return SUCCESS;
        }else {
        	return INPUT;
        }
		
	}
}
