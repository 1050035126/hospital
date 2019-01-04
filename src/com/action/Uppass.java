package com.action;

import com.dao.UppassDao;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Uppass  extends ActionSupport{
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getNewPass() {
		return newPass;
	}

	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	private String id;
	private String pass;
	private String newPass;
	private String grade;
	
	

	public String execute() {
		UppassDao upd=new UppassDao();
		System.out.println("pass="+pass+" newPass="+newPass+" grade="+grade);
		if(upd.upPass(id, pass, newPass, grade)) {
			return SUCCESS;
		}else {
			return INPUT;
		}
	}
}
