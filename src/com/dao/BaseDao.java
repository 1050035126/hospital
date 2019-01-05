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

    public int getPageNum(String tableName, String searchColumn, String searchWords) {
        try {
            StringBuffer sql = new StringBuffer("select count(1) from ");
            sql.append(tableName);
            if (searchWords != null && !"".equals(searchWords)) {
                sql.append(" where ").append(searchColumn).append(" like '%").append(searchWords).append("%'");
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
