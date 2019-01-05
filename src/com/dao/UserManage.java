package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Utils.PageUtils;
import com.bean.UserManageBean;
import com.db.LinkSql;

import javax.servlet.http.HttpServletRequest;

public class UserManage {
    LinkSql ls = null;
    ArrayList<UserManageBean> umb = null;

    public UserManage() {
        ls = new LinkSql();
        umb = new ArrayList<UserManageBean>();
    }

    public ArrayList<UserManageBean> getUserManage(HttpServletRequest request) {
        String sqlDoctor = "Select * from Doctor";
        String sqlHouseman = "Select * from Houseman";

        sqlDoctor = PageUtils.getPageSql(sqlDoctor, "Doctor", "Dname", request);
        sqlHouseman = PageUtils.getPageSql(sqlHouseman, "Houseman", "Hname", request);

        ResultSet Doctor = ls.selectSqlDate(sqlDoctor);
        ResultSet Houseman = ls.selectSqlDate(sqlHouseman);
        try {
            while (Doctor.next()) {
                UserManageBean um = new UserManageBean();
                um.setId(Doctor.getString("Did"));
                um.setName(Doctor.getString("Dname"));
                um.setAge(Doctor.getString("Dage"));
                um.setSex(Doctor.getString("Dsex"));
                um.setIsDoc("在职医生");
                um.setPhone(Doctor.getString("Dphone"));
                um.setEmail(Doctor.getString("Demail"));
                um.setLimit(Doctor.getString("Limit"));
                umb.add(um);
            }
            while (Houseman.next()) {
                UserManageBean um = new UserManageBean();
                um.setId(Houseman.getString("Hid"));
                um.setName(Houseman.getString("Hname"));
                um.setAge(Houseman.getString("Hage"));
                um.setSex(Houseman.getString("Hsex"));
                um.setIsDoc("实习医生");
                um.setPhone(Houseman.getString("Hphone"));
                um.setEmail(Houseman.getString("Hemail"));
                um.setLimit(Houseman.getString("Limit"));
                umb.add(um);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return umb;
    }
}
