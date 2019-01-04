package com.dao;

import com.db.LinkSql;

public class AddMedicineDao {
	LinkSql ls=null;
	public AddMedicineDao() {
		ls=new LinkSql();
	}
	public boolean addMedicine(String text,String patient,String time,String doctor,String audit,String manage) {
		String sql="";
		if(manage.equals("1")) {
			sql=String.format("insert into Medicine(Mname,Dpatient,Mtime,Mdoctor,Maudit,Mmanage)values('%s','%s','%s','%s','%s','%s')"
					, text,patient,time,doctor,"0",manage);
		}else {
			sql=String.format("insert into Medicine(Mname,Dpatient,Mtime,Mdoctor,Maudit,Mmanage)values('%s','%s','%s','%s','%s','%s')"
					, text,patient,time,doctor,"1",manage);
		}
		System.out.println("药品管理"+sql);
		ls.changeMySqlDate(sql);
		if(ls.getCheck()!=0) {
			return true;
		}else {
			return false;
		}
	}
	
}
