package com.dao;

import java.sql.SQLException;

import com.db.LinkSql;

public class UppassDao {
	LinkSql ls=null;
	public UppassDao() {
		ls=new LinkSql();
	}
	public boolean upPass(String id,String pass,String newPass,String limit) {
		if(limit.equals("1")) {
			try {
				if(ls.selectSqlDate(String.format("select * from Doctor where Did='%s' and Dpass='%s'", id,pass)).next()) {
					ls.changeMySqlDate(String.format("update Doctor set Dpass='%s' where Did='%s'",newPass,id));
				}else {
					return false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}else if(limit.equals("2")) {
			try {
				if(ls.selectSqlDate(String.format("select * from Houseman where Hid='%s' and Hpass='%s'", id,pass)).next()) {
					ls.changeMySqlDate(String.format("update Houseman set Hpass='%s' where Hid='%s'",newPass,id));
				}else {
					return false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}else if(limit.equals("3")) {
			try {
				if(ls.selectSqlDate(String.format("select * from Patient where Pid='%s' and Ppass='%s'", id,pass)).next()) {
					ls.changeMySqlDate(String.format("update Patient set Ppass='%s' where Pid='%s'",newPass,id));
				}else {
					return false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		if(ls.getCheck()!=0) {
			return true;
		}else {
			return false;
		}
		
	}
}
