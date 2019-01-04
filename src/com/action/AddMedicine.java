package com.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.dao.AddMedicineDao;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AddMedicine extends ActionSupport {
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
	public void setManage(String manage) {
		this.manage=manage;
	}
	public String getManage() {
		return manage;
	}
	private String grade;
	private String doctor;
	private String text;
	private String patient;
	private String time;
	private String manage;
	public String execute(){
		System.out.println("manage"+manage);
		AddMedicineDao mb=new AddMedicineDao();
		Date d = new Date(); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        time = sdf.format(d); 
        grade="0";
        if(mb.addMedicine(text, patient, time, doctor, grade,manage)) {
        	return SUCCESS;
        }else {
        	return INPUT;
        }
		
	}
}
