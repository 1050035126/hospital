package com.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Quit  extends ActionSupport{
	public String execute(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.invalidate();
		return SUCCESS;
	}
}
