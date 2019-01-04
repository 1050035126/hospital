package com.dao;

import com.db.LinkSql;

public class ChangeCMDao {
	private LinkSql ls=null;
	private int result=0;
	public ChangeCMDao() {
		ls=new LinkSql();
	}
	
	public void changeCase(String id,String text,String doctor) {
		String sql=String.format("update `Case` set Ccase='%s' where Cid='%s' and Cdoctor='%s' and DATEDIFF(Ctime,NOW())=0"
				, text,id,doctor);
		runSql(sql);
	}
	public void changeMedicine(String id,String text) {
		String sql=String.format("update Medicine set Mname='%s' where Mid='%s'"
				, text,id);
		runSql(sql);
	}
	private void runSql(String sql) {
		System.out.println(sql);
		ls.changeMySqlDate(sql);
		result=ls.getCheck();
	}
	public int getChackSql() {
		return result;
	}
}
