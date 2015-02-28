package com.pinke.uni.mobile.protal.common.service;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Vector;

public class TableData {
	int tablenamesize = 0;
	  byte[] tablename;
	  Vector rows = new Vector();

	  public static TableData parser(DataInputStream bis)
	  {
	    TableData table = new TableData();
	    try {
	      table.tablenamesize = bis.readInt();
	      table.tablename = new byte[table.tablenamesize];
	      bis.read(table.tablename);
	      int rowcount = bis.readInt();
	      for (int index = 0; index < rowcount; index++)
	      {
	        RowData row = RowData.parser(bis);
	        if (row != null)
	          table.addRow(row);
	      }
	    }
	    catch (IOException e) {
	      e.printStackTrace();
	      table = null;
	    }
	    return table;
	  }

	  public String toString() {
	    String result = "";

	    String tablenameStr = "";
	    try {
	      tablenameStr = new String(this.tablename, "UTF-8");
	    }
	    catch (UnsupportedEncodingException e) {
	      e.printStackTrace();
	    }
	    result = result + "tablenamesize = " + this.tablenamesize + "\n";
	    result = result + "tablename = " + tablenameStr + "\n";
	    result = result + "rowcount = " + this.rows.size() + "\n";
	    for (int index = 0; index < this.rows.size(); index++)
	    {
	      result = result + "\nrowindex = " + index + "\n";
	      RowData row = (RowData)this.rows.elementAt(index);
	      result = result + row.toString();
	    }

	    return result;
	  }

	  public void encode(DataOutputStream dos)
	  {
	    try {
	      dos.write(ByteInterpreter.intToByteArray(this.tablenamesize));
	      dos.write(this.tablename);
	      int rowcount = this.rows.size();
	      dos.write(ByteInterpreter.intToByteArray(rowcount));
	      for (int index = 0; index < rowcount; index++)
	      {
	        RowData row = (RowData)this.rows.elementAt(index);
	        row.encode(dos);
	      }
	    }
	    catch (IOException e) {
	      e.printStackTrace();
	    }
	  }

	  public void addRow(RowData arow)
	  {
	    this.rows.add(arow);
	  }

	  public void setname(String aName) {
	    try {
	      this.tablename = aName.getBytes("UTF-8");
	      this.tablenamesize = this.tablename.length;
	    }
	    catch (UnsupportedEncodingException e) {
	      e.printStackTrace();
	    }
	  }
}
