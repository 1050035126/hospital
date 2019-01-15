package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Utils.PageUtils;
import com.bean.MedicineBean;
import com.db.LinkSql;

import javax.servlet.http.HttpServletRequest;

public class MedicineDao {
    private LinkSql ls = null;
    private ResultSet rs = null;
    private ArrayList<MedicineBean> amb = null;

    public MedicineDao() {
        ls = new LinkSql();
        amb = new ArrayList<MedicineBean>();
    }

    public ArrayList<MedicineBean> getMedicine(String name, HttpServletRequest request) {
        String sql = String.format("select * from Medicine where Maudit=1 and Dpatient='%s'", name);
        sql = PageUtils.getPageSql(sql, "Medicine", "Mname", request);


        rs = ls.selectSqlDate(sql);
        try {
            while (rs.next()) {
                MedicineBean mb = new MedicineBean();
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

    public ArrayList<MedicineBean> getMedicine(HttpServletRequest request) {
        String sql = "select * from Medicine where Maudit=1";

        sql = PageUtils.getPageSql(sql, "Medicine", "Mname", request);

        rs = ls.selectSqlDate(sql);
        try {
            while (rs.next()) {
                MedicineBean mb = new MedicineBean();
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

    public ArrayList<MedicineBean> getMedicineCheck(HttpServletRequest request) {
        String sql = "select * from Medicine where Maudit=0";
        sql = PageUtils.getPageSql(sql, "Medicine", "Mname", request);

        rs = ls.selectSqlDate(sql);
        try {
            while (rs.next()) {
                MedicineBean mb = new MedicineBean();
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

    /**I
     * 查询所有的药品
     * @return
     */
    public ArrayList<MedicineBean> getMedicineAll() {
        String sql = "select * from Medicine";
        rs = ls.selectSqlDate(sql);
        try {
            while (rs.next()) {
                MedicineBean mb = new MedicineBean();
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
            e.printStackTrace();
        }
        return amb;
    }

}
