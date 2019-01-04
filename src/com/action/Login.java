package com.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.LoginD;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Login extends ActionSupport{
	private String name;
	private String pass;
	private String grade;
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
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public String execute(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		System.out.println(String.format("1->%s\t2->%s\t3->%s\t",grade,name,pass));
		if(grade==null||name==null||pass==null) {
			if(session.getAttribute("username")==null) {
				return INPUT;
			}else {
				return SUCCESS;
			}
		}
		LoginD ld=new LoginD();
		if(ld.logined(grade, name, pass)) {
//			System.out.println("正确");
			session.setAttribute("username", name);
			session.setAttribute("grade", grade);
			session.setAttribute("name", ld.getName());
			return SUCCESS;
			
		}else {
//			System.out.println("错误");
			return INPUT;
		}
		
	}
}
