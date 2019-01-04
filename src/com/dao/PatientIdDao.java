package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.PatientIdBean;
import com.db.LinkSql;

public class PatientIdDao {
	private LinkSql ls=null;
	private ResultSet rs=null;
	ArrayList<PatientIdBean> apb;
	public PatientIdDao() {
		ls=new LinkSql();
		apb=new ArrayList<PatientIdBean>();
	}
	public ArrayList<PatientIdBean> getPatientName(){
		System.out.println("接受到Patient的消息123456");
		String sql="select Pid,Pname from Patient";
		rs=ls.selectSqlDate(sql);
		try {
			while(rs.next()) {
				PatientIdBean pb=new PatientIdBean();
				System.out.println("接受到Patient的消息");
				pb.setId(rs.getString("Pid"));
				pb.setName(rs.getString("Pname"));
				apb.add(pb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return apb;
	}
}
