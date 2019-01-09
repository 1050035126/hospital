package com.dao;

import com.db.LinkSql;

public class CheckDao {
    LinkSql ls = null;

    public CheckDao() {
        ls = new LinkSql();
    }

    public void check(String type, String id, String audit) {
        String sql = "";
        if (type.equals("case")) {
            sql = String.format("update `Case` set Caudit='%s' where Cid='%s'", audit, id);
        } else if (type.equals("medicine")) {
            sql = String.format("update Medicine set Maudit='%s' where Mid='%s'", audit, id);
        }
        ls.changeMySqlDate(sql);
    }
}
