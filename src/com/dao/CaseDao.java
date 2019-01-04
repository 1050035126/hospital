package com.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.CaseBean;
import com.db.LinkSql;

public class CaseDao {
	private LinkSql ls=null;
	private ArrayList<CaseBean> acb=null;
	private ResultSet rs=null;
	public CaseDao() {
		ls=new LinkSql();
		acb=new ArrayList<CaseBean>();
	}
	public ArrayList<CaseBean> getCase(String name){
		String sql=String.format("select * from `Case` where Caudit=1 and Cpatient='%s'", name);
		System.out.println(sql);
		rs=ls.selectSqlDate(sql);
		try {
			while(rs.next()) {
				CaseBean cb=new CaseBean();
				cb.setId(rs.getString("Cid"));
				cb.setText(rs.getString("Ccase"));
				cb.setPatient(rs.getString("Cpatient"));
				cb.setTime(rs.getString("Ctime"));
				cb.setDoctor(rs.getString("Cdoctor"));
				cb.setAudit(rs.getString("Caudit"));
				acb.add(cb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return acb;
	}
	public ArrayList<CaseBean> getCase(){
		String sql="select * from `Case` where Caudit=1";
		rs=ls.selectSqlDate(sql);
		try {
			while(rs.next()) {
				CaseBean cb=new CaseBean();
				cb.setId(rs.getString("Cid"));
				cb.setText(rs.getString("Ccase"));
				cb.setPatient(rs.getString("Cpatient"));
				cb.setTime(rs.getString("Ctime"));
				cb.setDoctor(rs.getString("Cdoctor"));
				cb.setAudit(rs.getString("Caudit"));
				acb.add(cb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return acb;
	}
	
	public ArrayList<CaseBean> getCaseCheck(){
		String sql="select * from `Case` where Caudit=0";
		rs=ls.selectSqlDate(sql);
		try {
			while(rs.next()) {
				CaseBean cb=new CaseBean();
				cb.setId(rs.getString("Cid"));
				cb.setText(rs.getString("Ccase"));
				cb.setPatient(rs.getString("Cpatient"));
				cb.setTime(rs.getString("Ctime"));
				cb.setDoctor(rs.getString("Cdoctor"));
				cb.setAudit(rs.getString("Caudit"));
				acb.add(cb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return acb;
	}
}
