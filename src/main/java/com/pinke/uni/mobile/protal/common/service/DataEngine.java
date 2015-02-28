package com.pinke.uni.mobile.protal.common.service;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Vector;

public class DataEngine {
	Vector tables = new Vector();

	  public void addTable(TableData data)
	  {
	    this.tables.add(data);
	  }

	  public String toString() {
	    String result = "";
	    int tablecount = 0;
	    TableData da = null;
	    tablecount = this.tables.size();
	    result = result + "start==========================================\n";
	    result = result + "\ntablecount = " + tablecount + "\n";
	    for (int index = 0; index < tablecount; index++)
	    {
	      result = result + "tableindex = " + index + "\n";
	      da = (TableData)this.tables.elementAt(index);
	      result = result + da.toString();
	    }
	    result = result + "end=============================================\n";
	    return result;
	  }

	  public void encode(DataOutputStream dos) {
	    int tablecount = this.tables.size();
	    try {
	      dos.write(ByteInterpreter.intToByteArray(tablecount));
	      System.out.println(dos.size());
	      for (int index = 0; index < tablecount; index++)
	      {
	        TableData table = (TableData)this.tables.elementAt(index);
	        table.encode(dos);
	      }
	    }
	    catch (IOException e) {
	      e.printStackTrace();
	    }
	  }
}
