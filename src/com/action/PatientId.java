package com.action;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.PatientIdBean;
import com.dao.PatientIdDao;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class PatientId  extends ActionSupport{
	ArrayList<PatientIdBean> ap=new ArrayList<PatientIdBean>();
	private String type;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type=type;
	}
	public ArrayList<PatientIdBean> getAp() {
		return ap;
	}
	public void setAp(ArrayList<PatientIdBean> ap) {
		this.ap = ap;
	}
	@SuppressWarnings("unused")
	public String execute(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		PatientIdDao pid=new PatientIdDao();
		System.out.println("过这里了吗");
		ap=pid.getPatientName();
		if(type.equals("case")) {
			return SUCCESS;
		}else if(type.equals("medicine")){
			return INPUT;
		}
		return SUCCESS;	
	}
}
