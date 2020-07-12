

 package com.nt.servlet;
 import java.io.IOException;
 import java.io.PrintWriter;
 import java.util.Date;
 import java.util.Locale;
 import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
 import javax.servlet.http.HttpServlet;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;

 public class ProcessServlet extends HttpServlet {
	@Override
 public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException ,IOException
	{
	 PrintWriter pw= null;
	  String comp=null;

	  int Value1=0, Value2=0;

	  //get print writter object 
	   pw= res.getWriter();

	   // set response content type 
	   res.setContentType("text/html");

	   // read s1 param value to know the component thet is used to send request 
	   
	   comp=req.getParameter("s1");

	   // write the logic

	   if(comp.equalsIgnoreCase("link1"))
	   {

		     pw.println("<center>");
		   pw.println(" Date and Time "+new Date()) ;

		     pw.println("</center>");
	   }
    else if(comp.equalsIgnoreCase("link2"))
    {

	     pw.println("<center>");
     pw.println(" sys properties :"+System.getProperties() );

     pw.println("</center>");
    }

	else if(comp.equalsIgnoreCase("Add"))
	{
		Value1=Integer.parseInt(req.getParameter("t1"));
        Value2=Integer.parseInt(req.getParameter("t2"));
        RequestDispatcher rd=req.getRequestDispatcher("calculator.html");  
	     rd.include(req, res);

	     pw.println("<center>");
		pw.println("<h1 style='color:red';text-align:'center'>Addition Results:"+(Value1+Value2)+"</h1>");

	     pw.println("</center>");
	}


	else if(comp.equalsIgnoreCase("Subtraction"))
	{
		Value1=Integer.parseInt(req.getParameter("t1"));
        Value2=Integer.parseInt(req.getParameter("t2"));
        
        RequestDispatcher rd=req.getRequestDispatcher("calculator.html");  
	     rd.include(req, res);

	     pw.println("<center>");
		pw.println("<h1 style='color:red';text-align:'center'>Subtraction  Results:"+(Value1-Value2)+"</h1>");

	     pw.println("</center>");
	} 
	   
	else if(comp.equalsIgnoreCase("Division"))
	{
		Value1=Integer.parseInt(req.getParameter("t1"));
        Value2=Integer.parseInt(req.getParameter("t2"));
         
        RequestDispatcher rd=req.getRequestDispatcher("calculator.html");  
	     rd.include(req, res);

	     pw.println("<center>");

		pw.println("<h1 style='color:red';text-align:'center'> Division   Results:"+(Value1/Value2)+"</h1>");

	     pw.println("</center>");
	}
	   
		else if(comp.equalsIgnoreCase("Mod"))
		{
			Value1=Integer.parseInt(req.getParameter("t1"));
	        Value2=Integer.parseInt(req.getParameter("t2"));
	        
	        RequestDispatcher rd=req.getRequestDispatcher("calculator.html");  
		     rd.include(req, res);

		     pw.println("<center>");
			pw.println("<h1 style='color:red';text-align:'center'>Mod  Results: "+(Value1%Value2)+"</h1>");

		     pw.println("</center>");
		}


	else
	{
		Value1=Integer.parseInt(req.getParameter("t1"));
        Value2=Integer.parseInt(req.getParameter("t2"));
        
        RequestDispatcher rd=req.getRequestDispatcher("calculator.html");  
	     rd.include(req, res);
	   //  <h1 style='color:red';text-align:'center'> Choose u r  Submit button or hyperliks to submit the request </h1>

	     pw.println("<center>");
		pw.println("<h1 style='color:red';text-align:'center'>Multification  Results:"+(Value1*Value2)+"</h1>");
		 pw.println("</center>");

	}

	//add hyper link
	   pw.println("<center>");
	pw.println("<br><br><br><a href='home.html'> Go to Home </a>");
	pw.println("</center>");
	}

	@Override
 public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException ,IOException
	{
	doGet(req,res);

	}

 }