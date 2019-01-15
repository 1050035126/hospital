package com.action;

import com.dao.CaseDao;
import com.dao.CaseMedicineDao;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

public class CaseMedicineAction extends ActionSupport {
    public int id;
    public String caseId;
    public String medicineName;
    public String quantity;
    public String audit;
    public String doMethod;
    public String result;

    public String execute() {
        CaseMedicineDao caseMedicineDao = new CaseMedicineDao();
        if ("add".equals(doMethod)) {
            id = caseMedicineDao.addMedicineByCaseId(caseId, medicineName, quantity, audit);
        } else if ("delete".equals(doMethod)) {
            caseMedicineDao.deleteMedicineById(id + "");
        } else if ("audit".equals(doMethod)) {
            caseMedicineDao.auditMedicineById(id + "", audit);
        }
        return "success";
    }


    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getAudit() {
        return audit;
    }

    public void setAudit(String audit) {
        this.audit = audit;
    }

    public String getDoMethod() {
        return doMethod;
    }

    public void setDoMethod(String doMethod) {
        this.doMethod = doMethod;
    }
}
