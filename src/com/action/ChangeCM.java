package com.action;

import com.dao.ChangeCMDao;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ChangeCM  extends ActionSupport{
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
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	private String doctor;
	private String type;
	private String id;
	private String text;
	public String execute(){
		System.out.println(String.format("接受到的数据为：1->%s\t2->%s\t3->%s",id,type,text));
		ChangeCMDao ccmd=new ChangeCMDao();
		if(type.equals("case")) {
			ccmd.changeCase(id, text,doctor);
		}else if(type.equals("medicine")) {
			ccmd.changeMedicine(id, text);
		}else {
			return INPUT;
		}
		if(ccmd.getChackSql()>0) {
			return SUCCESS;
		}else {
			return INPUT;
		}
	}
}
