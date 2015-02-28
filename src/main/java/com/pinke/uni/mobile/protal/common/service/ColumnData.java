package com.pinke.uni.mobile.protal.common.service;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;

public class ColumnData {
	int namesize = 0;
	  byte[] name;
	  int valuesize = 0;
	  byte[] value;
	  int ressize = 0;
	  byte[] resdata;

	  public static ColumnData parser(DataInputStream bis)
	  {
	    ColumnData column = new ColumnData();
	    try {
	      column.namesize = bis.readInt();
	      column.name = new byte[column.namesize];
	      bis.read(column.name);
	      column.valuesize = bis.readInt();
	      column.value = new byte[column.valuesize];

	      bis.read(column.value);
	      column.ressize = bis.readInt();
	      if (column.ressize > 0)
	      {
	        column.resdata = new byte[column.ressize];
	        bis.read(column.resdata);
	      }
	    }
	    catch (IOException e) {
	      e.printStackTrace();
	      column = null;
	    }

	    return column;
	  }

	  public String toString()
	  {
	    String result = "";
	    result = result + "columnnamesize = " + this.namesize + "\n";
	    try {
	      String columnnamestr = new String(this.name, "UTF-8");
	      result = result + "columnname = " + columnnamestr + "\n";
	      result = result + "valuesize = " + this.valuesize + "\n";
	      String valuestr = "";
	      if (columnnamestr.equals("date")) {
	        long val = ByteInterpreter.byteTolong(this.value);
	        Date date = new Date();
	        date.setTime(val);
	        valuestr = date.toString();
	      } else if (columnnamestr.equals("size")) {
	        int val = ByteInterpreter.byteArrayToInt(this.value, 0);
	        valuestr = String.valueOf(val);
	      } else {
	        valuestr = new String(this.value, "UTF-8");
	        try
	        {
	          if (!valuestr.matches("^[0-9a-zA-Z一-龪:：,，、 ;；.。“”()（）\\[\\]_\\|\\v\\n-@'`^&%!！$?]*$"))
	            valuestr = String.valueOf(ByteInterpreter.byteArrayToInt(this.value, 0));
	        }
	        catch (ArrayIndexOutOfBoundsException e) {
	          valuestr = String.valueOf(this.value[(this.value.length - 1)]);
	        }

	      }

	      result = result + "value = " + valuestr + "\n";
	      result = result + "ressize = " + this.ressize + "\n";
	      if (this.ressize > 0)
	      {
	        String file_url = valuestr;
	        try
	        {
	          FileOutputStream fw = new FileOutputStream(file_url);
	          try {
	            fw.write(this.resdata);
	            result = result + "resdata = " + String.valueOf(ByteInterpreter.byteArrayToInt(this.resdata, 0)) + "\n";
	          }
	          catch (IOException e) {
	            e.printStackTrace();
	            try
	            {
	              fw.close();
	            } catch (IOException ex) {
	              e.printStackTrace();
	            }
	          }
	          finally
	          {
	            try
	            {
	              fw.close();
	            } catch (IOException e) {
	              e.printStackTrace();
	            }
	          }
	          try
	          {
	            fw.close();
	          } catch (IOException e) {
	            e.printStackTrace();
	          }

	        }
	        catch (FileNotFoundException e)
	        {
	          result = result + "resdata = \n";
	          e.printStackTrace();
	        }
	      } else {
	        result = result + "resdata = \n";
	      }
	    }
	    catch (UnsupportedEncodingException e) {
	      e.printStackTrace();
	    }
	    return result;
	  }

	  public void encode(DataOutputStream dos)
	  {
	    try {
	      dos.write(ByteInterpreter.intToByteArray(this.namesize));
	      dos.write(this.name);
	      dos.write(ByteInterpreter.intToByteArray(this.valuesize));
	      dos.write(this.value);
	      dos.write(ByteInterpreter.intToByteArray(this.ressize));
	      if (this.ressize > 0)
	      {
	        dos.write(this.resdata);
	      }
	    }
	    catch (IOException e) {
	      e.printStackTrace();
	    }
	  }

	  public void setname(String aName)
	  {
	    try {
	      this.name = aName.getBytes("UTF-8");
	      this.namesize = this.name.length;
	    }
	    catch (UnsupportedEncodingException e) {
	      e.printStackTrace();
	    }
	  }

	  public void setvalue(String aValue)
	  {
	    try {
	      this.value = aValue.getBytes("UTF-8");
	      this.valuesize = this.value.length;
	    }
	    catch (UnsupportedEncodingException e) {
	      e.printStackTrace();
	    }
	  }

	  public void setvalue(int aValue)
	  {
	    this.value = ByteInterpreter.intToByteArray(aValue);
	    this.valuesize = this.value.length;
	  }

	  public void setvalue(byte[] aValue)
	  {
	    this.value = aValue;
	    this.valuesize = this.value.length;
	  }

	  public void setres(byte[] aResData)
	  {
	    this.ressize = aResData.length;
	    this.resdata = aResData;
	  }
}
