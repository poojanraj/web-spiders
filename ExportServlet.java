package com.mom.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mom.DAO.ConnectionDAO;
import com.mom.model.Employees;
import com.mom.model.departments;


@WebServlet("/ExportServlet")
public class ExportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ExportServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		 int dept_id=Integer.parseInt(request.getParameter("dept_id"));
		 String dept_name=request.getParameter("dept_name");  
		
		 departments d=new departments();  
		 d.setDept_id(dept_id);
	        d.setDept_name(dept_name);  
	        
	        int status = ConnectionDAO.exportEmployees();
			
			if(status>0)
			{
				request.getRequestDispatcher("Reg_Successful.jsp").include(request, response);
			}
			else
			{
				out.print("<p> Sorry !! Unable to Save  </p>");
			}
			out.close();
			
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		doGet(request, response);
	}
	

}
