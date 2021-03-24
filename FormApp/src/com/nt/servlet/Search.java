package com.nt.servlet;

import java.io.IOError;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Search extends HttpServlet {
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		
		PrintWriter pw=null;
		res.getWriter();
		res.setContentType("html/text");
		
		String name=req.getParameter("google");
		
		res.sendRedirect("https://www.google.co.in/search?q="+name);
		
		
	}

}
