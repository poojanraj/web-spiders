package com.mom.DAO;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDatabase 
{
	public static void main(String[] args) 
	{
		try{
			
		
	Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "MOM", "redhat");
    
    Statement statement = connect.createStatement();
    ResultSet resultSet = statement.executeQuery("select * from departments");
    XSSFWorkbook workbook = new XSSFWorkbook(); 
    XSSFSheet spreadsheet = workbook.createSheet("departments db");
    
    XSSFRow row = spreadsheet.createRow(1);
    XSSFCell cell;
    cell = row.createCell(1);
    cell.setCellValue("dept_id");
    cell = row.createCell(2);
    cell.setCellValue("dept_name");
   
    int i = 2;

    while(resultSet.next()) 
    {
       row = spreadsheet.createRow(i);
       cell = row.createCell(1);
       cell.setCellValue(resultSet.getInt("dept_id"));
       cell = row.createCell(2);
       cell.setCellValue(resultSet.getString("dept_name"));
       i++;
    }
		
	
    FileOutputStream out = new FileOutputStream(new File("exceldatabase1.xls"));
    workbook.write(out);
    out.close();
    
    System.out.println("exceldatabase1.xls written successfully");
	}
	
	catch( Exception ex ) 
	{
	    System.out.println(ex);
	}
}
}
