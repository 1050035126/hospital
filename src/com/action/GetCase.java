package com.action;

import com.bean.CaseBean;
import com.bean.CaseMedicine;
import com.bean.DoctorIdBean;
import com.bean.MedicineBean;
import com.dao.CaseDao;
import com.dao.CaseMedicineDao;
import com.dao.DoctorIdDao;
import com.dao.MedicineDao;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;

public class GetCase extends ActionSupport {
    public CaseBean caseBean;
    public String id;
    public String returnTo;
    public List<CaseMedicine> caseMedicineList;
    public ArrayList<MedicineBean> medicineList;

    public ArrayList<DoctorIdBean> getAdi() {
        return adi;
    }

    public void setAdi(ArrayList<DoctorIdBean> adi) {
        this.adi = adi;
    }

    private ArrayList<DoctorIdBean> adi;

    public String execute() {
        CaseDao cd = new CaseDao();
        caseBean = cd.getCaseById(id);

        CaseMedicineDao caseMedicineDao = new CaseMedicineDao();
        caseMedicineList = caseMedicineDao.getMedicineByCaseId(id);

        if ("show".equals(returnTo)) {
            return INPUT;
        } else {
            DoctorIdDao did = new DoctorIdDao();
            adi = did.getDoctorId();

            MedicineDao medicineDao = new MedicineDao();
            medicineList = medicineDao.getMedicineAll();
            return SUCCESS;
        }
    }


    public CaseBean getCaseBean() {
        return caseBean;
    }

    public void setCaseBean(CaseBean caseBean) {
        this.caseBean = caseBean;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReturnTo() {
        return returnTo;
    }

    public void setReturnTo(String returnTo) {
        this.returnTo = returnTo;
    }

    public List<CaseMedicine> getCaseMedicineList() {
        return caseMedicineList;
    }

    public ArrayList<MedicineBean> getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(ArrayList<MedicineBean> medicineList) {
        this.medicineList = medicineList;
    }

    public void setCaseMedicineList(List<CaseMedicine> caseMedicineList) {
        this.caseMedicineList = caseMedicineList;
    }
}
