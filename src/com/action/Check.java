package com.action;

import com.dao.CheckDao;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Check extends ActionSupport {
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	private String type;
	private String id;
	public String execute(){
		CheckDao cd=new CheckDao();
		System.out.println("id="+id+"\ttype="+type);
		if(type.equals("case")) {
			cd.check("case", id);
			return SUCCESS;
		}else if(type.equals("medicine")){
			cd.check("medicine", id);
			return INPUT;
		}else {
			return INPUT;
		}
	}
}
