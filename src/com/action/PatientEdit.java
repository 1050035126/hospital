package com.action;

import java.util.ArrayList;

import com.bean.DoctorIdBean;
import com.bean.PatientIdBean;
import com.dao.DoctorIdDao;
import com.dao.PatientIdDao;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class PatientEdit extends ActionSupport  {
	private String id;
	private String grade;
	public void setGrade(String grade) {
		this.grade=grade;
	}
	public String getGrade() {
		return grade;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ArrayList<DoctorIdBean> getAdi() {
		return adi;
	}
	public void setAdi(ArrayList<DoctorIdBean> adi) {
		this.adi = adi;
	}
	private ArrayList<DoctorIdBean> adi;
	private PatientIdBean patient;
	public String execute(){
		//查询医生
		DoctorIdDao did=new DoctorIdDao();
		adi=did.getDoctorId();

		//查询病人完整信息
		PatientIdDao patientIdDao=new PatientIdDao();
		patient=patientIdDao.getPatientById(id);
		return SUCCESS;
	}
















	public PatientIdBean getPatient() {
		return patient;
	}

	public void setPatient(PatientIdBean patient) {
		this.patient = patient;
	}
}
