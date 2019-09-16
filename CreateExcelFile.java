package com.mom.DAO;


import  java.io.*;  
import  java.sql.*;

import  org.apache.poi.hssf.usermodel.HSSFSheet;  
import  org.apache.poi.hssf.usermodel.HSSFWorkbook; 
import  org.apache.poi.hssf.usermodel.HSSFRow;
import  org.apache.poi.hssf.usermodel.HSSFCell;  

public class CreateExcelFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			String filename="D:\\data.xls" ;
			HSSFWorkbook hwb=new HSSFWorkbook();
			HSSFSheet sheet =  hwb.createSheet("new sheet");

			HSSFRow rowhead=   sheet.createRow((short)0);
			rowhead.createCell((short) 0).setCellValue("dept_id");
			rowhead.createCell((short) 1).setCellValue("dept_name");
			

			Class.forName("oracle.jdbc.driver.OracleDriver");
		    Connection connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "MOM", "redhat");
			Statement st=connect.createStatement();
			ResultSet rs=st.executeQuery("select * from departments");
			int i=1;
			while(rs.next()){
			HSSFRow row=   sheet.createRow((short)i);
			row.createCell((short) 0).setCellValue(Integer.toString(rs.getInt("dept_id")));
			row.createCell((short) 1).setCellValue(rs.getString("dept_name"));
			
			i++;
			}
			FileOutputStream fileOut =  new FileOutputStream(filename);
			hwb.write(fileOut);
			fileOut.close();
			System.out.println("Your excel file has been generated!");

			} catch ( Exception ex ) {
			    System.out.println(ex);

			}
			}		
	}


