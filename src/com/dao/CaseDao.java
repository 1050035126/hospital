package com.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Utils.PageUtils;
import com.bean.CaseBean;
import com.db.LinkSql;

import javax.servlet.http.HttpServletRequest;

public class CaseDao {
	private LinkSql ls=null;
	private ArrayList<CaseBean> acb=null;
	private ResultSet rs=null;
	public CaseDao() {
		ls=new LinkSql();
		acb=new ArrayList<CaseBean>();
	}
	public ArrayList<CaseBean> getCase(String name,HttpServletRequest request){
		String sql=String.format("select * from `Case` where Caudit=1 and Cpatient='%s'", name);
		sql = PageUtils.getPageSql(sql, "Case", "Ccase", request);
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
	public ArrayList<CaseBean> getCase(HttpServletRequest request){
		String sql="select * from `Case` where Caudit=1";

		sql = PageUtils.getPageSql(sql, "Case", "Ccase", request);

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
	
	public ArrayList<CaseBean> getCaseCheck(HttpServletRequest request){
		String sql="select * from `Case` where Caudit=0";

		sql = PageUtils.getPageSql(sql, "Case", "Ccase", request);

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
