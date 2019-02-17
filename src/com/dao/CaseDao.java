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

	/**
	 * 根据id查询病历
	 * @param id
	 * @return
	 */
	public CaseBean getCaseById(String id){
		String sql=String.format("select * from `Case` where Cid= %s ", id);
		rs=ls.selectSqlDate(sql);
		CaseBean cb=new CaseBean();
		try {
			while(rs.next()) {
				cb.setId(rs.getString("Cid"));
				cb.setText(rs.getString("Ccase"));
				cb.setPatient(rs.getString("Cpatient"));
				cb.setTime(rs.getString("Ctime"));
				cb.setDoctor(rs.getString("Cdoctor"));
				cb.setAudit(rs.getString("Caudit"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cb;
	}

	/**
	 * 病人查看病历
	 * @param name
	 * @param request
	 * @return
	 */
	public ArrayList<CaseBean> getCase(String name,HttpServletRequest request){
		String sql=String.format("select * from `Case` where Caudit=1 and Cpatient='%s'", name);
		sql = PageUtils.getPageSql(sql, "Case", "Cpatient", request);
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

	/**
	 * 医生查看病历
	 * @param request
	 * @return
	 */
	public ArrayList<CaseBean> getCase(int waitToUpdate,String name,HttpServletRequest request){
		request.setAttribute("waitToUpdate", waitToUpdate);

		String sql="select * from `Case`";

		if (waitToUpdate==1){
			sql="select * from `case` c where c.Cpatient in(SELECT p.Pname from patient p where p.Pcure in('手术治疗','住院治疗')) and c.Cdoctor='"+name+"'";
		}
		sql = PageUtils.getPageSql(sql, "Case", "Cpatient", request);

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

	/**
	 * 医生查看待审核病历
	 * @param request
	 * @return
	 */
	public ArrayList<CaseBean> getCaseCheck(HttpServletRequest request){
		String sql="select * from `Case` where Caudit=0";

		sql = PageUtils.getPageSql(sql, "Case", "Cpatient", request);

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
