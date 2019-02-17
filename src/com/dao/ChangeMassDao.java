package com.dao;

import com.db.LinkSql;

public class ChangeMassDao {
	private LinkSql ls=null;
	private int result;
	public ChangeMassDao() {
		ls=new LinkSql();
	}
	
	public void setChangeMassDoctor(String id,String name,String sex,String age,String phone,String email) {
		String sql=String.format("update Doctor set Dname='%s',Dsex='%s',Dage='%s',Dphone='%s',Demail='%s' where Did='%s'"
				,name,sex,age,phone,email,id);
		runSql(sql);
	}
	
	public void setChangeMassHouseman(String id,String name,String sex,String age,String phone,String email) {
		String sql=String.format("update Houseman set Hname='%s',Hsex='%s',Hage='%s',Hphone='%s',Hemail='%s' where Hid='%s'"
				,name,sex,age,phone,email,id);
		runSql(sql);
	}
	public void setChangeMassPatient(String id,String name,String sex,String age,String phone,String email,String doctor,String cure,String nurse) {
		String sql=String.format("update Patient set Pname='%s',Psex='%s',Page='%s',Pphone='%s',Pemail='%s',Pdoctor='%s',Pcure='%s',Pnurse='%s' where Pid='%s'"
				,name,sex,age,phone,email,doctor,cure,nurse,id);
		runSql(sql);
		String sql2=String.format("update `Case` set Cdoctor='%s' where Cpatient='%s'",doctor,id);
		nextRunSql(sql2);
	}
	private void runSql(String sql) {
		ls.changeMySqlDate(sql);
		result=ls.getCheck();
	}
	private void nextRunSql(String sql) {
		ls.changeMySqlDate(sql);
	}
	public int getCheckSql() {
		return result;
	}
}
