package com.action;

import java.util.ArrayList;

import com.bean.MedicineBean;
import com.dao.MedicineDao;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

@SuppressWarnings("serial")
public class MedicineCheck extends ActionSupport {
	ArrayList<MedicineBean> amb=new ArrayList<MedicineBean>();
	public ArrayList<MedicineBean> getAmb() {
		return amb;
	}
	public void setAmb(ArrayList<MedicineBean> amb) {
		this.amb = amb;
	}
	public String execute(){
		MedicineDao mcd=new MedicineDao();
		amb=mcd.getMedicineCheck(ServletActionContext.getRequest());
		return SUCCESS;
	}
}
