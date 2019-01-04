package com.bean;

public class UserPatientBean {
	private String id;
	private String name;
	private String sex;
	private String age;
	private String phone;
	private String email;
	private String subject;
	private String limit;
	private String nurse;
	private String doctor;
	private String cure;
	public void setCure(String cure) {
		this.cure=cure;
	}
	public String getCure() {
		return cure;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor=doctor;
	}
	public String getNurse() {
		return nurse;
	}
	public void setNurse(String nurse) {
		this.nurse=nurse;
	}
	public String getLimit() {
		return limit;
	}
	public void setLimit(String limit) {
		this.limit=limit;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
}
