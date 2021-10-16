package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetCapitalsServlet extends HttpServlet {

	@Override
	 public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	        //get PrintWriter
            PrintWriter pw=res.getWriter();
	      //set response content type
	      res.setContentType("text/html");
	     //read form data
	      int country=Integer.parseInt(req.getParameter("country"));
	      //get capital city name
	      String capitals[]=new String[] {"New Delhi","Islamabad","Washington DC","Beijing"};
	      String countries[]=new String[] {"India","pakistan","USA","china"};
	      pw.println("<h1 style='color:blue;text-align:center'>Capital name of country "+countries[country]+"  is::  "+capitals[country]+"</h1>");
	      //add home hyperlink
	      pw.println("<a href='page.html'>home</a>");
	      //close stream
	      pw.close();
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	
}
   