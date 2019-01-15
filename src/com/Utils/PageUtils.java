package com.Utils;

import com.dao.BaseDao;
import com.opensymphony.xwork2.ActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PageUtils {


    public static String getPageSql(String sql, String tableName, String searchColumn, HttpServletRequest request) {
        int pageSize = 5;

        int currentPage = 0;
        Object cu = request.getParameter("currentPage");
        if (cu != null) {
            currentPage = Integer.valueOf(cu.toString());
        }

        String searchWords = "";
        Object search = request.getParameter("searchWords");
        if (search != null) {
            searchWords = search.toString();
        }


        if (currentPage < 1) {
            currentPage = 1;
        }

        int count = new BaseDao().getPageNum(sql, searchColumn, searchWords);

        int lastPage = (int) Math.ceil(count / Double.valueOf(pageSize));
        if (lastPage == 0) {
            lastPage = 1;
        }

        if (currentPage > lastPage) {
            currentPage = lastPage;
        }

        int begin = (currentPage - 1) * pageSize;
        int end = currentPage * pageSize;
        if (searchWords == null) {
            searchWords = "";
        }

        StringBuffer str = new StringBuffer(sql);
        if (str.indexOf("where") == -1) {
            str.append(" where ");
        } else {
            str.append(" and ");
        }
        str.append(searchColumn).append(" like '%").append(searchWords);
        str.append("%' limit ").append(begin).append(",").append(pageSize);


        request.setAttribute("currentPage", currentPage);
        request.setAttribute("searchWords", searchWords);
        request.setAttribute("count", count);
        request.setAttribute("lastPage", lastPage);
        return str.toString();
    }

}
