package com.dao;
import com.db.LinkSql;

public class RegisterDao {
	private LinkSql ls=null;
	public RegisterDao() {
		ls=new LinkSql();
	}
//	private String name;
//	private String pass;
//	private String limit;
//	private String phone;
//	private String email;
//	private String sex;
//	private String age;
	public void doctorRegister(String id,String name,String pass,String phone,String email,String sex,String age) {
		String sql="";
		sql=String.format("insert into Doctor(Did,Dpass,Dname,Dsex,Dage,Dphone,Demail,`Limit`)"
				+ "values('%s','%s','%s','%s','%s','%s','%s','%s')", 
				id,pass,name,sex,age,phone,email,"1");
		System.out.println(sql);
		ls.changeMySqlDate(sql);
	}
	
	public void housemanRegister(String id,String name,String pass,String phone,String email,String sex,String age,String hdoctor) {
		String sql="";
		sql=String.format("insert into Houseman(Hid,Hpass,Hname,Hsex,Hage,Hphone,Hemail,`Limit`,Hdoctor)"
				+ "values('%s','%s','%s','%s','%s','%s','%s','%s','%s')", 
				id,pass,name,sex,age,phone,email,"2",hdoctor);
		System.out.println(sql);
		ls.changeMySqlDate(sql);
	}
	
	public void patientRegister(String id,String name,String pass,String phone,String email,String sex,String age,String subject,String hdoctor,String nurse,String cure) {
		String sql="";
		sql=String.format("insert into Patient(Pid,Ppass,Pname,Psex,Page,Pphone,Pemail,`Limit`,Psubject,Pdoctor,Pnurse,Pcure)"
				+ "values('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')", 
				id,pass,name,sex,age,phone,email,"3",subject,hdoctor,nurse,cure);
		System.out.println(sql);
		ls.changeMySqlDate(sql);
		
	}
}
