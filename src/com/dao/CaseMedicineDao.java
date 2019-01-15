package com.dao;

import com.Utils.PageUtils;
import com.bean.CaseBean;
import com.bean.CaseMedicine;
import com.db.LinkSql;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CaseMedicineDao {

    private LinkSql ls = null;
    private ArrayList<CaseBean> acb = null;
    private ResultSet rs = null;

    public CaseMedicineDao() {
        ls = new LinkSql();
        acb = new ArrayList<CaseBean>();
    }

    /**
     * 根据病历id查询药品
     */
    public List<CaseMedicine> getMedicineByCaseId(String caseId) {
        String sql = String.format("select * from case_medicine where case_id='%s'", caseId);
        rs = ls.selectSqlDate(sql);

        List<CaseMedicine> medicineList = new ArrayList<>();
        try {
            while (rs.next()) {
                CaseMedicine medicine = new CaseMedicine();
                medicine.setId(rs.getInt("id"));
                medicine.setCaseId(rs.getString("case_id"));
                medicine.setMedicineName(rs.getString("medicine_name"));
                medicine.setQuantity(rs.getString("quantity"));
                medicine.setAudit(rs.getString("audit"));
                medicineList.add(medicine);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicineList;
    }


    /**
     * 查询待审核的药品
     */
    public List<CaseMedicine> getMedicineWaitAudit(HttpServletRequest request) {
        String sql = "select * from case_medicine where audit=0";
        sql = PageUtils.getPageSql(sql, "case_medicine", "medicine_name", request);

        rs = ls.selectSqlDate(sql);

        List<CaseMedicine> medicineList = new ArrayList<>();
        try {
            while (rs.next()) {
                CaseMedicine medicine = new CaseMedicine();
                medicine.setId(rs.getInt("id"));
                medicine.setCaseId(rs.getString("case_id"));
                medicine.setMedicineName(rs.getString("medicine_name"));
                medicine.setQuantity(rs.getString("quantity"));
                medicine.setAudit(rs.getString("audit"));
                medicineList.add(medicine);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicineList;
    }

    /**
     * 添加药品
     *
     * @param caseId
     * @param medicineName
     * @param quantity
     * @return
     */
    public int addMedicineByCaseId(String caseId, String medicineName, String quantity, String audit) {
        String sql = String.format("INSERT INTO case_medicine (case_id, medicine_name,quantity,audit) VALUES (%s,'%s','%s','%s')", caseId, medicineName, quantity, audit);

        PreparedStatement preparedStatement = null;
        int key = -1;
        try {
            preparedStatement = ls.getConn().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            while (generatedKeys.next()) {
                key = generatedKeys.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return key;
    }

    /**
     * 删除病历对应的单个药品
     *
     * @param id
     * @return
     */
    public boolean deleteMedicineById(String id) {
        String sql = String.format("delete from case_medicine where id=%s", id);
        ls.changeMySqlDate(sql);
        if (ls.getCheck() != 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 审核药品
     *
     * @param id
     * @param audit
     * @return
     */
    public boolean auditMedicineById(String id, String audit) {
        String sql = String.format("update case_medicine c set c.audit='%s' where id= %s", audit, id);
        ls.changeMySqlDate(sql);
        if (ls.getCheck() != 0) {
            return true;
        } else {
            return false;
        }
    }


}
