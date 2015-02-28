package com.pinke.uni.mobile.protal.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ChannelDataSourceUtil {

    private static DataConnectionUtil dbutil = new DataConnectionUtil();
 
    /**
     * @param sql
     * @param params
     * @return
     */
    public List getList(String sql, Object[] params) {
        return getList(sql, params, 0, -1);
    }

    public List getList(String sql, Object[] params, int startCol, int endCol) {
        Connection conn = dbutil.getConn();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<String[]> list = new ArrayList<String[]>();
        try {
            stmt = conn.prepareStatement(sql);

            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    stmt.setObject(i + 1, params[i]);
                }
            }

            rs = stmt.executeQuery();

            if (endCol == -1) {
                endCol = rs.getMetaData().getColumnCount();
            }

            int len = endCol - startCol;

            while (rs.next()) {
                String[] info = new String[len];
                for (int i = 0, j = startCol; j < endCol; i++, j++) {
                    info[i] = formatNull(rs.getString(j + 1));
                }
                list.add(info);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResultSet(rs);
            closeStatement(stmt);
            closeConn(conn);
        }
        return list;
    }

    /**
     * 格式化字符串
     * 
     * @param rsString
     *            被格式化的字符串
     * @return 字符串为null则返回""，否则返回原字符串。
     */
    private String formatNull(String rsString) {
        return rsString == null ? "" : rsString;
    }

    /**
     * 关闭结果集（忽略异常）
     * 
     * @param rs
     *            结果集
     */
    public void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭SQL语句对象（忽略异常）
     * 
     * @param stmt
     *            SQL语句对象
     */
    public void closeStatement(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭连接（忽略异常）
     * 
     * @param stmt
     *            SQL语句对象
     */
    public void closeConn(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean insertMess(String sql, Object[] params) {
        Connection conn = dbutil.getConn();
        
        PreparedStatement stmt = null;
        int rs = -1;
        try {
            stmt = conn.prepareStatement(sql);

            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    stmt.setObject(i + 1, params[i]);
                }
            }

            rs = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatement(stmt);
            closeConn(conn);
        }
        return rs > 0 ? true : false;
    }
}

