package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class LinkSql {
	private static final String url = "jdbc:mysql://47.106.249.46:3306/hospital?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf-8&useSSL=false";
	private  static final String name = "com.mysql.jdbc.Driver";  
	private  static String user = "test";
	private  static String password = "test123";
	private static java.sql.ResultSet ret = null;
    public Connection conn = null;  
    public PreparedStatement pst = null; 
    private int check=1;
	public LinkSql(){
		System.out.println("pass="+password+" user"+user);
		try {  
            Class.forName(name);//链接
            conn = DriverManager.getConnection(url, user, password);//链接  
            System.out.println("连接成功");
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
	}


	public Connection getConn() {
		return conn;
	}

	public void changeMySqlDate(String sql) {
		try {
			System.out.println("接受到的Sql语句（插入删除类的）："+sql);
			pst=conn.prepareStatement(sql);
			check=pst.executeUpdate();
//			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
	}
	
	public int getCheck() {
		return check;
	}
	
	public ResultSet selectSqlDate(String sql) {
		try {
			System.out.println("接受到的Sql语句（选择类的）："+sql);
			pst=conn.prepareStatement(sql);
			ret = pst.executeQuery();
			return ret;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}
	
	public void closeMySql() {
		try {  
            this.conn.close();   
        } catch (SQLException e) {  
            e.printStackTrace();  
        }
	}
	
    @SuppressWarnings("static-access")
	public void closeChart() {  
        try {    
            this.pst.close();
            this.ret.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    } 
}