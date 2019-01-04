package com.action;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.CaseBean;
import com.dao.CaseDao;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Case  extends ActionSupport{
	public ArrayList<CaseBean> getAcb() {
		return acb;
	}
	public void setAcb(ArrayList<CaseBean> acb) {
		this.acb = acb;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	private String grade;
	private String name;
	ArrayList<CaseBean> acb=new ArrayList<CaseBean>();
	@SuppressWarnings("unused")
	public String execute(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		CaseDao cd=new CaseDao();
		if(grade.equals("3")) {
			acb=cd.getCase(name);
		}else {
			acb=cd.getCase();
		}
		return SUCCESS;
	}
}
