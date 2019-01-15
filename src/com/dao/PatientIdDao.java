package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.PatientIdBean;
import com.db.LinkSql;

public class PatientIdDao {
    private LinkSql ls = null;
    private ResultSet rs = null;
    ArrayList<PatientIdBean> apb;

    public PatientIdDao() {
        ls = new LinkSql();
        apb = new ArrayList<PatientIdBean>();
    }

    /**
     * 通过id查询单个病人的信息
     *
     * @param id
     * @return
     */
    public PatientIdBean getPatientById(String id) {
        String sql = "select * from Patient p where p.Pid = '%s'";
        rs = ls.selectSqlDate(String.format(sql, id));
        PatientIdBean pb = new PatientIdBean();
        try {
            while (rs.next()) {
                pb.setId(rs.getString("Pid"));
                pb.setName(rs.getString("Pname"));
                pb.setAge(rs.getString("Page"));
                pb.setSex(rs.getString("Psex"));
                pb.setPhone(rs.getString("Pphone"));
                pb.setMail(rs.getString("Pemail"));
                pb.setDoctor(rs.getString("Pdoctor"));
                pb.setNurse(rs.getString("Pnurse"));
                pb.setCure(rs.getString("Pcure"));
                pb.setSubject(rs.getString("Psubject"));
                pb.setPsymptom(rs.getString("Psymptom"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pb;
    }


    public ArrayList<PatientIdBean> getPatientName() {
        System.out.println("接受到Patient的消息123456");
        String sql = "select Pid,Pname from Patient";
        rs = ls.selectSqlDate(sql);
        try {
            while (rs.next()) {
                PatientIdBean pb = new PatientIdBean();
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
