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
	pw.print("<br><br><h1 style='color:red'><center>Date and time is "+d+" </center></h1>");
    pw.print("<br><h1 style='color:green'><center>Date and time is "+d+" </center></h1>");
	// genarate wish message 

	if(hour<=12)
		pw.println("<br><h1 style='color:red'><center>Hello  Good Morning  </center></h1> ");
		 
         
		else if(hour<=17)
		pw.println("<br><h1 style='color:red'><center> Hello Good Afternoon</center></h1> ");

		else if(hour<=20)
		pw.println("<br><h1 style='color:red'><center> Hello Good Evening</center></h1> ");

		else
		pw.println("<br><h1 style='color:red'><center> Hello Good night</center></h1> ");
// genarate the hyper link 
      pw.println("<center><br><a href='home.html'>Home </center></a>");
	  pw.close();
}
}