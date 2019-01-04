package com.bean;

public class CaseBean {
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getPatient() {
		return patient;
	}
	public void setPatient(String patient) {
		this.patient = patient;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAudit() {
		return audit;
	}
	public void setAudit(String audit) {
		this.audit=audit;
	}
	private String id;
	private String text;
	private String patient;
	private String doctor;
	private String time;
	private String audit;
}
