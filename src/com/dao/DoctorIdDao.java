package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.DoctorIdBean;
import com.db.LinkSql;

public class DoctorIdDao {
	private LinkSql ls=null;
	private ResultSet rs=null;
	private ArrayList<DoctorIdBean> adi=null;
	public DoctorIdDao() {
		ls=new LinkSql();
		adi=new ArrayList<DoctorIdBean>();
	}
	
	public ArrayList<DoctorIdBean> getDoctorId(){
		String sql="select * from Doctor";
		rs=ls.selectSqlDate(sql);
		try {
			while(rs.next()) {
				DoctorIdBean db=new DoctorIdBean();
				db.setId(rs.getString("Did"));
				db.setName(rs.getString("Dname"));
				adi.add(db);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adi;
	}
}
