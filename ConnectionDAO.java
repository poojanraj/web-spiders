package com.mom.DAO;

import java.sql.*;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.mom.model.Employees;

public class ConnectionDAO {
	public static Connection getConnection() {
		Connection con = null;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
		    con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "MOM", "redhat");
		} catch (Exception e) {
			System.out.println("here");
			System.out.println(e);
		}
		return con;

		
	}
	public static int insertEmployees(Employees e) {
		int status = 0;

		try {
			Connection con = ConnectionDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into employees(emp_id,emp_name,emp_email,emp_pass,emp_desg,dept_id,emp_status,emp_startdate) values(emp_id.NEXTVAL,?,?,?,?,?,1,?)");

			//ps.setInt(1, e.getemp_id());
			ps.setString(1, e.getemp_name());
			ps.setString(2, e.getemp_mail());
			ps.setString(3, Enc_Dec.encode(e.getemp_pass()));
			ps.setString(4, e.getemp_desg());
			ps.setInt(5, e.getdept_id());
			//ps.setBoolean(7, e.isemp_status());
			String sdate=e.getemp_startdate();
			//Date date = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(sdate);
			SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
			//java.sql.Date dateJoin= new java.sql.Date( date.getTime() ); 
			java.util.Date date=sdf1.parse(sdate);
			java.sql.Date sqdate=new java.sql.Date(date.getTime());
			ps.setDate(6, sqdate);

			status = ps.executeUpdate();
			con.close();

		} catch (Exception E) {
			System.out.println(E);
			System.out.println("here");
		}

		return status;
	}

	public static List<Employees> getAllEmployees() {
		List<Employees> list = new ArrayList<Employees>();
		try {
			Connection con = ConnectionDAO.getConnection();

			PreparedStatement ps = con.prepareStatement("select * from employees where emp_status=1 order by emp_id");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Employees e = new Employees();

				e.setemp_id(rs.getInt(1));
				e.setemp_name(rs.getString(2));
				e.setemp_mail(rs.getString(3));
				e.setemp_pass(rs.getString(4));
				e.setemp_desg(rs.getString(5));
				e.setdept_id(rs.getInt(6));
				e.setemp_status(rs.getBoolean(7));
				e.setemp_startdate(rs.getString(8));


				list.add(e);
			}
			con.close();

		} catch (Exception E) {
			System.out.println(E);
		}
		return list;
	}
	
	//for getting employee dtails by name
	public static Employees getEmployeeByName(String emp_name) {
		Employees e = new Employees();

		try {
			Connection con = ConnectionDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from employees where emp_name=? and emp_status=1 order by emp_startdate DESC");

			ps.setString(1, emp_name);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {


				e.setemp_id(rs.getInt(1));
				e.setemp_name(rs.getString(2));
				e.setemp_mail(rs.getString(3));
				e.setemp_pass(rs.getString(4));
				e.setemp_desg(rs.getString(5));
				e.setdept_id(rs.getInt(6));
				e.setemp_status(rs.getBoolean(7));
				e.setemp_startdate(rs.getString(8));

			}
			con.close();

		} catch (Exception E) {
			System.out.println(E);

		}
		return e;
	}


	public static Employees getCustomerById(int emp_id) {
		Employees e = new Employees();

		try {
			Connection con = ConnectionDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from employees where emp_id=?");

			ps.setInt(1, emp_id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {


				e.setemp_id(rs.getInt(1));
				e.setemp_name(rs.getString(2));
				e.setemp_mail(rs.getString(3));
				e.setemp_pass(rs.getString(4));
				e.setemp_desg(rs.getString(5));
				e.setdept_id(rs.getInt(6));
				e.setemp_status(rs.getBoolean(7));
				e.setemp_startdate(rs.getString(8));

			}
			con.close();

		} catch (Exception E) {
			System.out.println(E);

		}
		return e;
	}
	public static int updateEmployees(Employees e) {
		int status = 0;

		try {
			Connection con = ConnectionDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("update employees set emp_name=?,emp_email=?,emp_pass=?,emp_desg=?,dept_id=? where emp_id=?");

			//
			ps.setString(1, e.getemp_name());
			ps.setString(2, e.getemp_mail());
			ps.setString(3, Enc_Dec.encode(e.getemp_pass()));
			ps.setString(4, e.getemp_desg());
			ps.setInt(5, e.getdept_id());
			ps.setInt(6, e.getemp_id());
			
			status = ps.executeUpdate();
			con.close();
		} catch (Exception E) {
			System.out.println(E);
		}
		return status;
	}

	public static int deactivateEmployees(int emp_id) {
		int status = 0;

		try {
			Connection con = ConnectionDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("update employees set emp_status=0 where emp_id=?");

			ps.setInt(1, emp_id);
			status = ps.executeUpdate();

			con.close();
		} catch (Exception E) {
			System.out.println(E);
		}
		return status;
	}
	
	public static int exportEmployees() {
		int status = 0;

		try {
			
			Connection con = ConnectionDAO.getConnection();
	         Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
	         ResultSet rs = st.executeQuery("Select * from departments");

	         HSSFWorkbook workbook = new HSSFWorkbook();
	         HSSFSheet sheet = workbook.createSheet("lawix10");


	         Row row = sheet.createRow(0);
	         int x=0;
	         while (rs.next())
	         {
	         int dept_id=  rs.getInt(1);
	         String dept_name=rs.getString(2);
	         //String Order_type=  rs.getString(4);
	         //java.sql.Date date= rs.getDate(5);
	         //String datex= String.valueOf(date);

	         row.createCell(0).setCellValue(dept_id);
	         row.createCell(1).setCellValue(dept_name);
	        // row.createCell(2).setCellValue(Order_type);
	        // row.createCell(3).setCellValue(datex); 

	          }
		
	         x+=1;  



	        String yemi = "D:\\excel\\testlno9.xls";
	        FileOutputStream fileOut;
	        try {
	             fileOut = new FileOutputStream(yemi);
	             workbook.write(fileOut);
	             fileOut.close();
	                
		} 
	        catch(Exception e)
	        {
	        	System.out.println(e);
	        } 
		}
	        catch(Exception e)
	        {
	        	System.out.println(e);
	        }
		return status;

	}
		}
	
	
	
	
	
	
	
	
	
	
	

