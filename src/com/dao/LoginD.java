package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.db.LinkSql;
public class LoginD {
	LinkSql ls=null;
	private String name;
	private String limit;
	private ResultSet rs=null;
	public LoginD(){
		ls=new LinkSql();
	}
	public boolean logined(String grade,String name,String pass) {
		String sql="";
		if(grade.equals("1")) {
			sql=String.format("select * from Doctor where Did='%s' and Dpass='%s'", name,pass);
		}else if(grade.equals("2")) {
			sql=String.format("select * from Houseman where Hid='%s' and Hpass='%s'", name,pass);
		}else if(grade.equals("3")) {
			sql=String.format("select * from Patient where Pid='%s' and Ppass='%s'", name,pass);
		}
		System.out.println(sql);
		try {
			rs=ls.selectSqlDate(sql);
			if(rs.next()) {
				name=rs.getString(getGrade(grade)+"name");
				limit=rs.getString("Limit");
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	private String getGrade(String grade) {
		if(grade.equals("1")) {
			return "D";
		}else if(grade.equals("2")) {
			return "H";
		}else if(grade.equals("3")) {
			return "p";
		}
		return "";
	}
	public String getName() {
		return name;
	}
	public String getLimit() {
		return limit;
	}
}
