package com.action;

import com.dao.ChangeMassDao;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ChangeMass extends ActionSupport {
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	public String getCure() {
		return cure;
	}
	public void setCure(String cure) {
		this.cure = cure;
	}
	public String getNurse() {
		return nurse;
	}
	public void setNurse(String nurse) {
		this.nurse = nurse;
	}
	private String id;
	private String grade;
	private String name;
	private String sex;
	private String age;
	private String phone;
	private String email;
	private String doctor;
	private String cure;
	private String nurse;
	public String execute(){
		ChangeMassDao cm=new ChangeMassDao();
		if(grade.equals("1")) {
			cm.setChangeMassDoctor(id, name, sex, age, phone, email);
		}else if(grade.equals("2")) {
			cm.setChangeMassHouseman(id, name, sex, age, phone, email);
		}else if(grade.equals("3")) {
			cm.setChangeMassPatient(id, name, sex, age, phone, email,doctor,cure,nurse);
		}
		if(cm.getCheckSql()>0) {
			return SUCCESS;
		}else {
			return INPUT;
		}
	}
}
