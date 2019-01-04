package com.action;

import com.dao.DeleteDao;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class DeleteMedicine extends ActionSupport  {
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id=id;
	}
	public String execute(){
		DeleteDao dl=new DeleteDao();
		dl.delMedicine(id);
		return SUCCESS;
	}
}
