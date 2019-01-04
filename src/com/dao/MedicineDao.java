package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.MedicineBean;
import com.db.LinkSql;

public class MedicineDao {
	private LinkSql ls=null;
	private ResultSet rs=null;
	private ArrayList<MedicineBean> amb=null;
	public MedicineDao() {
		ls=new LinkSql();
		amb=new ArrayList<MedicineBean>();
	}
	public ArrayList<MedicineBean> getMedicine(String name){
		String sql=String.format("select * from Medicine where Maudit=1 and Dpatient='%s'", name);
		System.out.println(sql);
		rs=ls.selectSqlDate(sql);
		try {
			while(rs.next()) {
				System.out.println("这里应该出来点啥");
				MedicineBean mb=new MedicineBean();
				mb.setId(rs.getString("Mid"));
				mb.setName(rs.getString("Mname"));
				mb.setAudit(rs.getString("Maudit"));
				mb.setDoctor(rs.getString("Mdoctor"));
				mb.setPatient(rs.getString("Dpatient"));
				mb.setTime(rs.getString("Mtime"));
				amb.add(mb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return amb;
	}
	public ArrayList<MedicineBean> getMedicine(){
		String sql="select * from Medicine where Maudit=1";
		System.out.println("这里是药品的");
		rs=ls.selectSqlDate(sql);
		try {
			while(rs.next()) {
				System.out.println("这里应该出来点啥");
				MedicineBean mb=new MedicineBean();
				mb.setId(rs.getString("Mid"));
				mb.setName(rs.getString("Mname"));
				mb.setAudit(rs.getString("Maudit"));
				mb.setDoctor(rs.getString("Mdoctor"));
				mb.setPatient(rs.getString("Dpatient"));
				mb.setTime(rs.getString("Mtime"));
				mb.setManage(rs.getString("Mmanage"));
				amb.add(mb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return amb;
	}
	public ArrayList<MedicineBean> getMedicineCheck(){
		String sql="select * from Medicine where Maudit=0";
		rs=ls.selectSqlDate(sql);
		try {
			while(rs.next()) {
				MedicineBean mb=new MedicineBean();
				mb.setId(rs.getString("Mid"));
				mb.setName(rs.getString("Mname"));
				mb.setAudit(rs.getString("Maudit"));
				mb.setDoctor(rs.getString("Mdoctor"));
				mb.setPatient(rs.getString("Dpatient"));
				mb.setTime(rs.getString("Mtime"));
				mb.setManage(rs.getString("Mmanage"));
				amb.add(mb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return amb;
	}
	
}
