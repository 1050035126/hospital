package com.action;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.MedicineBean;
import com.dao.MedicineDao;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Medicine extends ActionSupport {
	ArrayList<MedicineBean> amb=new ArrayList<MedicineBean>();
	public ArrayList<MedicineBean> getAmb() {
		return amb;
	}
	public void setAmb(ArrayList<MedicineBean> amb) {
		this.amb = amb;
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
	private String grade;
	private String name;
	@SuppressWarnings("unused")
	public String execute(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		MedicineDao mcd=new MedicineDao();
		if(grade.equals("3")) {
			System.out.print("病人的在执行"+grade);
			amb=mcd.getMedicine(name,ServletActionContext.getRequest());
		}else {
			System.out.print("医生的在执行"+grade);
			amb=mcd.getMedicine(ServletActionContext.getRequest());
		}
		return SUCCESS;
	}
}
