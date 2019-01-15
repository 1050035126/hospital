package com.action;

import java.util.ArrayList;
import java.util.List;

import com.bean.CaseMedicine;
import com.bean.MedicineBean;
import com.dao.CaseMedicineDao;
import com.dao.MedicineDao;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

@SuppressWarnings("serial")
public class MedicineCheck extends ActionSupport {

    List<CaseMedicine> caseMedicineList;

    public String execute() {
        CaseMedicineDao caseMedicineDao = new CaseMedicineDao();
        caseMedicineList = caseMedicineDao.getMedicineWaitAudit(ServletActionContext.getRequest());
        return SUCCESS;
    }

    public List<CaseMedicine> getCaseMedicineList() {
        return caseMedicineList;
    }

    public void setCaseMedicineList(List<CaseMedicine> caseMedicineList) {
        this.caseMedicineList = caseMedicineList;
    }
}
