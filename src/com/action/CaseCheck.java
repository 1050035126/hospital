package com.action;

import java.util.ArrayList;

import com.bean.CaseBean;
import com.dao.CaseDao;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

@SuppressWarnings("serial")
public class CaseCheck extends ActionSupport {
	public ArrayList<CaseBean> getAcb() {
		return acb;
	}
	public void setAcb(ArrayList<CaseBean> acb) {
		this.acb = acb;
	}
	ArrayList<CaseBean> acb=new ArrayList<CaseBean>();
	public String execute(){
		CaseDao cd=new CaseDao();
		acb=cd.getCaseCheck(ServletActionContext.getRequest());
		System.out.println("审核模块儿");
		return SUCCESS;
	}
}
