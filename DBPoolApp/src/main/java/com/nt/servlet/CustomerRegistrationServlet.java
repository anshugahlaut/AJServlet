//CustomerRegistrationServlet.java
package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class CustomerRegistrationServlet extends HttpServlet {
	private static final String CUSTOMER_INSERT_QUERY="INSERT INTO SERVLET_CUSTOMER VALUES(CUST_CNO.NEXTVAL,?,?,?,?)";
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//Get PrintWriter
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form data (req param values)
		String name=req.getParameter("cname");
		String addrs=req.getParameter("cadd");
		float billAmt=Float.parseFloat(req.getParameter("billAmt"));
		long mobileNo=Long.parseLong(req.getParameter("mobileNo"));
		//get pooled JDBC con object
		try(Connection con=getPooledConnection();
				PreparedStatement ps=con.prepareStatement(CUSTOMER_INSERT_QUERY);
				){
			//set values to query params
			ps.setString(1,name);
			ps.setString(2,addrs);
			ps.setFloat(3, billAmt);
			ps.setLong(4, mobileNo);
			//execute the Query
			int result=ps.executeUpdate();
			//process the result
			if(result==1)
				pw.println("<h1 style='color:green'>Customer is registered </h1>");
			else
				pw.println("<h1 style='color:green'>Customer is not registered </h1>");
		       //add hyperlink
			   pw.println("<br><br><a href='Customer_register.html'>home </a>");
			   //close stream
			   pw.close();		
		}//try
		catch(SQLException se) {
			se.printStackTrace();
			pw.println("<h1 style='color:green'>Internal Problem-Try again "+se.getMessage()+" </h1>");
			//add hyperlink
			pw.println("<br><br><a href='customer_register.html'>home </a>");
		}
		catch(Exception e) {
			e.printStackTrace();
			pw.println("<h1 style='color:green'>Internal Problem-Try again::"+e.getMessage()+" </h1>");
			//add hyperlink
			pw.println("<br><br><a href='customer_register.html'>home </a>");
		}

	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

 
	//helper method
	private Connection getPooledConnection()throws Exception {
		//create InitialContext object
		InitialContext ic=new InitialContext();
		//Get Datasource object ref through lookup operation
		DataSource ds=(DataSource)ic.lookup("DsJndi");
		//get Pooled JDBC connection
		Connection con=ds.getConnection();
		return con;		
	}

}
