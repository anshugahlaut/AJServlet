//ExcelServlet.java
package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExcelServlet extends HttpServlet
{
	
	static {
		System.out.println("ExcelTestServlet:: static block");
		}
	
	public ExcelServlet() {
		System.out.println("ExcelTestServlet:: 0-param constructor");		
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("ExcelServlet::init(ServletConfig cg)");
	}
	
	
	protected void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		System.out.println("ExcelServlet.service(-,-)");
		//set response content type
		res.setContentType("application/vnd.ms-excel");
		//get Printwriter Stream
		PrintWriter pw=res.getWriter();
		//write output content browser
		pw.println("<table border='1' align='center'>");
		pw.println("<tr> <th> Player name </th> <th> Medal </th> <th> Category </th> </tr>");
		pw.println("<tr> <th> Neeraj Chopra </th> <th> Gold </th> <th> Javeline throw </th> </tr>");
		pw.println("<tr> <th> Meera Bai Chanu </th> <th> Silver </th> <th> Weight Lifting </th> </tr>");
		pw.println("<tr> <th> Ravi Kumar Dahiya </th> <th> Silver </th> <th> Wrestling </th> </tr>");
		pw.println("<tr> <th> PV Sindhu </th> <th> Bronze </th> <th> Badminton </th> </tr>"); 
		pw.println("<tr> <th> Lovlina </th> <th> Bronze </th> <th> Boxing </th> </tr>"); 
		pw.println("<tr> <th> Hockey </th> <th> Bronze </th> <th> Mens Hockey </th> </tr>"); 
		pw.println("<tr> <th> Bajrang Punia </th> <th> Bronze </th> <th> Wrestling </th> </tr>"); 
		pw.println("</table>");
		//close stream 
		pw.close();
	}//service
}//class