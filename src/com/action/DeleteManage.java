package com.action;

import com.dao.DeleteDao;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class DeleteManage extends ActionSupport {
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	private String type;
	public String execute(){
		DeleteDao dl=new DeleteDao();
		if(type.equals("在职医生")) {
			dl.delDoctor(id);
		}else if(type.equals("实习医生")) {
			dl.delHouseman(id);
		}
		return SUCCESS;
	}
}
