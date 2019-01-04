package com.action;

import com.dao.DeleteDao;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class DeleteCase extends ActionSupport  {
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id=id;
	}
	public String execute(){
		DeleteDao dl=new DeleteDao();
		dl.delCase(id);
		return SUCCESS;
	}
}
