package com.action;

import com.dao.CaseMedicineDao;
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
    private String audit;

    public String execute() {
        CheckDao cd = new CheckDao();
        System.out.println("id=" + id + "\ttype=" + type);
        if (type.equals("case")) {
            cd.check("case", id, audit);
            return SUCCESS;
        } else if (type.equals("medicine")) {
            CaseMedicineDao caseMedicineDao = new CaseMedicineDao();
            caseMedicineDao.auditMedicineById(id, audit);
            return INPUT;
        } else {
            return INPUT;
        }
    }


    public String getAudit() {
        return audit;
    }

    public void setAudit(String audit) {
        this.audit = audit;
    }
}
