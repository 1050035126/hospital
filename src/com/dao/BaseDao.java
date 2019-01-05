package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.db.LinkSql;

public class BaseDao {
    LinkSql ls = null;
    private ResultSet rs = null;

    public BaseDao() {
        ls = new LinkSql();
    }

    public int getPageNum(String sql2, String searchColumn, String searchWords) {
        try {
            StringBuffer sql = new StringBuffer(sql2.replace("*", "count(1)"));

            if (searchWords != null && !"".equals(searchWords)) {
                if (sql.indexOf("where") == -1) {
                    sql.append(" where ");
                } else {
                    sql.append(" and ");
                }

                sql.append(searchColumn).append(" like '%").append(searchWords).append("%'");
            }
            rs = ls.selectSqlDate(sql.toString());
            rs.next();
            return rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


}
