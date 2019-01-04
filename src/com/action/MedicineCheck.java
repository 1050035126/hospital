package com.action;

import java.util.ArrayList;

import com.bean.MedicineBean;
import com.dao.MedicineDao;
import com.opensymphony.xwork2.ActionSupport;

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
		amb=mcd.getMedicineCheck();
		return SUCCESS;
	}
}
