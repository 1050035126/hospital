package com.dao;

import com.db.LinkSql;

public class CheckDao {
	LinkSql ls=null;
	public CheckDao() {
		ls=new LinkSql();
	}
	
	public void check(String type,String id) {
		String sql="";
		if(type.equals("case")) {
			sql=String.format("update `Case` set Caudit='1' where Cid='%s'", id);
		}else if(type.equals("medicine")){
			sql=String.format("update Medicine set Maudit='1' where Mid='%s'", id);
		}
		ls.changeMySqlDate(sql);
	}
}
