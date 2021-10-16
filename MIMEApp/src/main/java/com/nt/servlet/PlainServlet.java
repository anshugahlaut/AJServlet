//PlainServlet.java
package com.nt.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class PlainServlet extends HttpServlet
{
	
	static {
		System.out.println("PlainServlet:: static block");
		}
	
	public PlainServlet() {
		System.out.println("LcTestServlet:: 0-param constructor");		
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("PlainServlet::init(ServletConfig cg)");
	}
	
	
	protected void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
     System.out.println("PlainServlet.service()");
		//set response content type
	 res.setContentType("text/plain");
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