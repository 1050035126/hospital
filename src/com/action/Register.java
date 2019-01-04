package com.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.RegisterDao;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Register  extends ActionSupport{
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getLimit() {
		return limit;
	}
	public void setLimit(String limit) {
		this.limit = limit;
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
	public String getSubject() {
		return subject;
	}
	public void getSubject(String subject) {
		this.subject=subject;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id=id;
	}
	public String getHdoctor() {
		return hdoctor;
	}
	public void setHdoctor(String hdoctor) {
		this.hdoctor=hdoctor;
	}
	public String getNurse() {
		return nurse;
	}
	public void setNurse(String nurse) {
		this.nurse=nurse;
	}
	public void setCure(String cure) {
		this.cure=cure;
	}
	public String getCure() {
		return cure;
	}
	private String id;
	private String name;
	private String pass;
	private String limit;
	private String phone;
	private String email;
	private String sex;
	private String age;
	private String subject;
	private String hdoctor;
	private String nurse;
	private String cure;
	@SuppressWarnings("unused")
	public String execute() {
		System.out.println("注册信息界面接受到数据");
		HttpSession session=ServletActionContext.getRequest().getSession();
		RegisterDao rs=new RegisterDao();
		if(limit.equals("1")) {
			rs.doctorRegister(id, name, pass, phone, email, sex, age);
		}else if(limit.equals("2")) {
			rs.housemanRegister(id, name, pass, phone, email, sex, age, hdoctor);
		}else if(limit.equals("3")) {
			rs.patientRegister(id, name, pass, phone, email, sex, age, subject,hdoctor,nurse,cure);
		}
		return SUCCESS;
	}
}
