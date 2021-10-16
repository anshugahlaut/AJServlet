package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBTestServlet extends HttpServlet {
	
	static {
		System.out.println("LcTestServlet:: static block");
		}
	
	public DBTestServlet() {
		System.out.println("LcTestServlet:: 0-param constructor");		
	}
	
	/* @Override
    public void init() throws ServletException {
    	System.out.println("DBTestServlet.init()");
    	ServletConfig cg=getServletConfig();
    	System.out.println("driver class name::"+cg.getInitParameter("driverClass"));
		System.out.println("jdbc url::"+cg.getInitParameter("url"));
    }*/
	
	
	/*@Override
	public void init(ServletConfig cg) throws ServletException {
		System.out.println("LcTestServlet::init(ServletConfig cg)");
		//super.init(cg);
		//read init param values from Servletconfig obj
		System.out.println("driver class name::"+cg.getInitParameter("driverClass"));
		System.out.println("jdbc url::"+cg.getInitParameter("url"));
		System.out.println("db username:"+cg.getInitParameter("dbuser"));
		System.out.println("db pwd::"+cg.getInitParameter("dbpwd"));
		//Write JDBC code here using the jdbc propertues available in ServletConfig obj
				
	}*/
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("LcTestServlet.doGet(req,res)");
		ServletConfig cg=getServletConfig();
		System.out.println("db username:"+cg.getInitParameter("dbuser"));
		System.out.println("db pwd::"+cg.getInitParameter("dbpwd"));
	    //destroy();
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//write message to response object using PrintWriter
		pw.println("<h1 style='color:red;text-align:center'> Date and Time::"+new java.util.Date()+"</h1>");
		//close stream
		pw.close();
	}
	
	
	@Override
	public void destroy() {
		System.out.println("LcTestServlet::destroy()");
	}

		
}//class
