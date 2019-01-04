package com.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.UserPatientBean;
import com.db.LinkSql;

public class UserPatientDao {
	private LinkSql ls=null;
	private ResultSet rs=null;
	private ArrayList<UserPatientBean> pbb=null;
	public UserPatientDao() {
		ls=new LinkSql();
		pbb=new ArrayList<UserPatientBean>();
	}
	
	public ArrayList<UserPatientBean> userPatient() {
		String sql="select * from Patient";
		rs=ls.selectSqlDate(sql);
		try {
			while(rs.next()) {
				UserPatientBean pb=new UserPatientBean();
				pb.setName(rs.getString("Pname"));
				pb.setAge(rs.getString("Page"));
				pb.setSex(rs.getString("Psex"));
				pb.setId(rs.getString("Pid"));
				pb.setPhone(rs.getString("Pphone"));
				pb.setEmail(rs.getString("Pemail"));
				pb.setSubject(rs.getString("Psubject"));
				pb.setNurse(rs.getString("Pnurse"));
				pb.setLimit(rs.getString("Limit"));
				pb.setDoctor(rs.getString("Pdoctor"));
				pb.setCure(rs.getString("Pcure"));
				pbb.add(pb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pbb;
	}
}
