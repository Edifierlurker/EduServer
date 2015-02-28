package com.pinke.uni.mobile.protal.util;


import java.sql.Connection;

import com.zte.ssb.framework.SSBBus;
import com.zte.ssb.framework.base.JDBCBaseDao;
import com.zte.zxywpub.BaseDataSource;

public class DataConnectionUtil extends JDBCBaseDao
{
    public Connection getConn()
    {
      BaseDataSource dataSource = (BaseDataSource)SSBBus.findDomainService("dataSource");

      super.setDataSource(dataSource);
      Connection conn = super.getConnection();
      return conn;
    }
}