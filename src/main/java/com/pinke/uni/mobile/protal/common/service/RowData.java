package com.pinke.uni.mobile.protal.common.service;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Vector;

public class RowData {
	Vector columnsdatas = new Vector();

	  public static RowData parser(DataInputStream bis)
	  {
	    RowData row = new RowData();
	    try {
	      int columnconut = bis.readInt();
	      for (int index = 0; index < columnconut; index++)
	      {
	        ColumnData columns = ColumnData.parser(bis);
	        if (columns != null)
	          row.addColumn(columns);
	      }
	    }
	    catch (IOException e) {
	      e.printStackTrace();
	      row = null;
	    }
	    return row;
	  }

	  public String toString() {
	    String result = "";
	    result = result + "columscount = " + this.columnsdatas.size() + "\n";
	    for (int index = 0; index < this.columnsdatas.size(); index++)
	    {
	      result = result + "columsindex = " + index + "\n";
	      ColumnData colums = (ColumnData)this.columnsdatas.elementAt(index);
	      result = result + colums.toString();
	    }
	    return result;
	  }

	  public void addColumn(ColumnData acolumn) {
	    this.columnsdatas.add(acolumn);
	  }

	  public void encode(DataOutputStream dos)
	  {
	    int columncount = this.columnsdatas.size();
	    try {
	      dos.write(ByteInterpreter.intToByteArray(columncount));
	      for (int index = 0; index < columncount; index++)
	      {
	        ColumnData column = (ColumnData)this.columnsdatas.elementAt(index);
	        column.encode(dos);
	      }
	    }
	    catch (IOException e) {
	      e.printStackTrace();
	    }
	  }
}
