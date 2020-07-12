package com.nt.servlet;
import javax.servlet.*;

import javax.servlet.http.*;
import java.io.*;
import java.util.*;


public  class WishServlet extends HttpServlet 
	{
	@ Override
public void service (HttpServletRequest req,HttpServletResponse res) throws ServletException ,IOException{

	PrintWriter pw = null;
	Calendar calendar =null;
	int hour=0;

	// general setting 
	pw= res.getWriter();

	// set content type 

	res.setContentType("text/html");

	// get system date 

	calendar=Calendar.getInstance();
	hour = calendar.get(Calendar.HOUR_OF_DAY);
    Date d= new Date();
	pw.print("<h1 style='color:red'><center>Date and time is "+d+" </center></h1>");
    pw.print("<h1 style='color:green'><center>Date and time is "+d+" </center></h1>");
	// genarate wish message 

	if(hour<=12)
		pw.println("<h1 style='color:red'><center>Good Morning</center></h1> ");
		 
         
		else if(hour<=17)
		pw.println("<h1 style='color:red'><center>Good Afternoon</center></h1> ");

		else if(hour<=20)
		pw.println("<h1 style='color:red'><center>Good Evening</center></h1> ");

		else
		pw.println("<h1 style='color:red'><center>Good night</center></h1> ");
// genarate the hyper link 
      pw.println("<br><a href='page.html'>Home </a>");
	  pw.close();
}
}