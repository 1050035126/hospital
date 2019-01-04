package com.dao;

import com.db.LinkSql;

public class DeleteDao {
	LinkSql ls=null;
	public DeleteDao() {
		ls=new LinkSql();
	}
	
	public int getCheckSql() {
		return ls.getCheck();
	}
	
	private void runSql(String sql) {
		ls.changeMySqlDate(sql);
		
	}
	
	public void delDoctor(String id) {
		String sql=String.format("delete from Doctor where Did='%s'", id);
		runSql(sql);
	}
	
	public void delHouseman(String id) {
		String sql=String.format("delete from Houseman where Hid='%s'", id);
		runSql(sql);
	}
	
	public void delPatient(String id) {
		String sql=String.format("delete from Patient where Pid='%s'", id);
		runSql(sql);
	}
	
	public void delCase(String id) {
		String sql=String.format("delete from `Case` where Cid='%s'", id);
		runSql(sql);
	}
	
	public void delMedicine(String id) {
		String sql=String.format("delete from Medicine where Mid='%s'", id);
		runSql(sql);
	}
}
