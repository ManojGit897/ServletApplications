package com.nt.servlet;
 import javax.servlet.*;
 import javax.servlet.http.*;
 import java.io.*;
 import java.util.*;


 public class VoteServlet extends HttpServlet {
	
	@Override
 public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException ,IOException
	{
// print Writer 

PrintWriter pw =null;
  String name=null;
      int age=0;
// general setting 

   pw=res.getWriter();
res.setContentType("text/html");   

// get req parameter values from data form

 name=req.getParameter("name");
 age=Integer.parseInt(req.getParameter("age"));
 String gender=req.getParameter("gen");
 
 
 
 
// write req processing logic 
 if (gender.equalsIgnoreCase("M")) {
	 if(age>100) {
		 RequestDispatcher rd=req.getRequestDispatcher("voter.html");  
		    rd.include(req, res);    
		 pw.println("<h1 style='color:red;text-align:center'> Heyy  Mr. "+name+"  You are  too old..... U r Outdated...");	 
		 pw.println("<br><a href='voter.html'>click here <img src='smilley1.jpg'></a>");
	 }
	 else if(age>=21&&age<=50) {
			pw.println("<h1 style='color:red;text-align:center'><br><br> Heyy  Mr. "+name+"  You are eligible to the marriage but think thrice  it is 80 years of project");
		    pw.println("<br><br><a href='voter.html'>click here <img src='smilley1.jpg'></a>");
		  }
	 else if(age>=50 && age<=100) {
			pw.println("<h1 style='color:red;text-align:center'><br><br> Heyy  Mr. "+name+"  You are  too old Don't try to marriage at this Time.... Okkk");
		    pw.println("<br><br><a href='voter.html'>click here <img src='smilley1.jpg'></a>");
		  }  
	 
 else {
	 pw.println("<br><br><br><h1 style='color:red;text-align:center'> Heyy  Mr. "+name+"  You are  Not eligible to the marriage  Let's Enjoy..");
	   pw.println("<br><br><a href='voter.html'>click here <img src='smilley2.jpg'></a>"); 
 }
	 
	}   //if 
 else {
	 if(age>100) {
		 RequestDispatcher rd=req.getRequestDispatcher("voter.html");  
		    rd.include(req, res); 
		    
		 pw.println("<h1 style='color:red;text-align:center'><br><br> Heyy  Miss. "+name+"  You are too Old... U r Outdated...");	 
		 pw.println("<br><br><a href='voter.html'>click here <img src='smilley1.jpg'></a>");
	 }
	 else if(age>=18&&age<=50) {
			pw.println("<br><br><br><h1 style='color:red;text-align:center'> Heyy  Miss. "+name+"  You are eligible to the marriage but think thrice  it is 80 years of project");
		   pw.println("<br><br><a href='voter.html'>click here <img src='smilley1.jpg'></a>");
		  }
	 
	 else if(age>=50 && age<=100) {
			pw.println("<h1 style='color:red;text-align:center'><br><br> Heyy  Miss. "+name+"  You are  too old Don't try to marriage at this Time.... Okkk");
		    pw.println("<br><br><a href='voter.html'>click here <img src='smilley1.jpg'></a>");
		  }  
	 
		 else {
			 pw.println("<br><br><br><h1 style='color:red;text-align:center'> Heyy  Miss. "+name+"  You are  Not eligible to the marriage  Let's Enjoy..");
			   pw.println("<br><br><a href='voter.html'>click here <img src='smilley2.jpg'></a>"); 
		 }
	 
 }//else

	pw.close();


	}// Service(-,-)

} //class

