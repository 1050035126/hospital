package com.action;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.UserManageBean;
import com.dao.UserManage;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UserManageAction extends ActionSupport{
	ArrayList<UserManageBean> umb=new ArrayList<UserManageBean>();
	public ArrayList<UserManageBean> getUmb() {
		return umb;
	}
	public void setUmb(ArrayList<UserManageBean> umb) {
		this.umb = umb;
	}
	UserManage um=new UserManage();
	@SuppressWarnings("unused")
	public String execute(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		umb=um.getUserManage();
		for(int i=0;i<umb.size();i++) {
			UserManageBean u=umb.get(i);
			System.out.println(String.format("1->%s\t2->%s\t3->%s\t4->%s\t5->%s", 
					u.getPhone(),u.getEmail(),u.getEmail(),u.getIsDoc(),u.getName()));
			
		}
		return SUCCESS;
	}
}
