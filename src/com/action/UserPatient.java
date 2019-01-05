package com.action;

import java.util.ArrayList;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import com.bean.UserPatientBean;
import com.dao.UserPatientDao;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UserPatient extends ActionSupport {
    HttpSession session = ServletActionContext.getRequest().getSession();
    ArrayList<UserPatientBean> upb = new ArrayList<UserPatientBean>();

    public ArrayList<UserPatientBean> getUpb() {
        return upb;
    }

    public void setUpb(ArrayList<UserPatientBean> upb) {
        this.upb = upb;
    }


    public String execute() {
        upb = new UserPatientDao().userPatient(ServletActionContext.getRequest());
        return SUCCESS;
    }
}
