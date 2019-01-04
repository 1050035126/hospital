package com.dao;

import com.db.LinkSql;

public class AddCaseDao {
	LinkSql ls=null;
	public AddCaseDao() {
		ls=new LinkSql();
	}
	public boolean addCase(String text,String patient,String time,String doctor,String audit) {
		String sql=String.format("insert into `Case`(Ccase,Cpatient,Ctime,Cdoctor,Caudit)values('%s','%s','%s','%s','%s')"
				, text,patient,time,doctor,audit);
		ls.changeMySqlDate(sql);
		if(ls.getCheck()!=0) {
			return true;
		}else {
			return false;
		}
	}
}
