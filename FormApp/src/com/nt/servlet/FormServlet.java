 
 package com.nt.servlet;
  import java.io.IOException;
  import java.io.PrintWriter;
  import java.util.Date;
  import java.util.Locale;
  import java.util.*;
  import javax.servlet.ServletException;
  import javax.servlet.http.HttpServlet;
  import javax.servlet.http.HttpServletRequest;
  import javax.servlet.http.HttpServletResponse;
  public class FormServlet extends HttpServlet {
  public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException ,IOException
	{
	  String name=null, gender=null, ms=null,addrs=null,Qualification=null, Dob=null,Dow=null, url=null, fcolor=null, email=null;
	  
	  int age=0;
	  String crs[]=null,hb[]=null;
	 
			  PrintWriter pw= null;    
	  
	  //get print writter object 
	   pw= res.getWriter();
	   

	   // set response content type 
	   res.setContentType("text/html");
	  
	   // read from data .......
	   name=req.getParameter("tname");
	   age=Integer.parseInt(req.getParameter("tage"));
	   gender=req.getParameter("gen");
	   ms=req.getParameter("ms");
	  addrs =req.getParameter("addrs");
	  Qualification=req.getParameter("qlfy");
	  
	   Dob=req.getParameter("dob");
	   Dow=req.getParameter("week");
	  fcolor =req.getParameter("color");
	//  =req.getParameter("")
	 email=req.getParameter("mail");
	 url =req.getParameter("url");
	 
	 crs=req.getParameterValues("crs"); 
	    if(crs==null){
			crs=new String[1];
			crs[0]=" No Course selected.";
		}
	 hb=req.getParameterValues("hb");  
	    if(hb==null){
			hb=new String[1];
			hb[0]=" No Hobies are selected.";
		}
	 
	 // write the request processing logic........
	 Date d=new Date();
	 
	 pw.println("<body bgcolor='wheat'>");

pw.print("<h1 style='color:red'><center>Date and time is "+d+" </center></h1>");

	  pw.println("<br> <i style='color:red'> Thank you Your datails are sucessfully submited.. Thank You For visiting  my site.</i>");
	   pw.println("");
	/* if (gender.equalsIgnoreCase("M")) {
		 
		if(age<=5)
			pw.println("<b>"+ name + "You are baby boy</b>");
		else if (age<=12)
			pw.println("<b>"+ name + " You are Small boy</b>");
		else if(age<=19)
			pw.println("<b>"+ name + " You are Teenage  boy</b>");
		else if (age<=35)
			pw.println("<b>"+ name + " You are young man</b>");
		else if (age<=50)
			pw.println("<b>"+ name + "You are middle aged man</b>");
		else 
			pw.println("<b>"+ name + " You are  old man </b>");
	}
	   
	 else if (gender.equalsIgnoreCase("F"))   
	 {
		 
		 if(age<=5)
				pw.println("<b>"+ name + " You are baby girl</b>");
			else if (age<=12)
				pw.println("<b>"+ name + " You are Small girl</b>");
			else if(age<=19)
				pw.println("<b>"+ name + " You are Teenage  girl</b>");
			else if (age<=35)
				pw.println("<b>"+ name + " You are young woman</b>");
			else if (age<=50)
				pw.println("<b>"+ name + " You are middle aged woman</b>");
			else 
				pw.println("<b>"+ name + " You are  old woman </b>");
	 }
	   
	*/  
         pw.println("<pre>");
		
		 pw.println("");
		 pw.println("<b> Personal details</b>");
	   pw.println("<br><b> Name            :<b>"+name);
	   pw.println("<br><b> age             :<b>"+age);
	   pw.println("<br><b> Email           :<b>"+email);
	   pw.println("<br><b> Gender          :<b>"+gender);
	   pw.println("<br><b> Marital Status  :<b>"+ms);
	   pw.println("<br><b> Addres          :<b>"+addrs);
	   pw.println("<br><b> favorate color  :<b>"+fcolor);
	   pw.println("<br><b> Qualification   :<b>"+Qualification);
	   pw.println("<br><b> Date of birth   :<b>"+Dob);
	   pw.println("<br><b> Date of week    :<b>"+Dow);
	   pw.println("<br><b> Courses         :<b>"+crs);
	   pw.println("<br><b> Hobies          :<b>"+hb);
	   pw.println("<br><b> Social urls     :<b>"+url);
	   
	   
             pw.println("</pre>");
             pw.println("</body>");

pw.println(" <br> <center><i style='color:red'> ");
 
			 pw.println("<a href='home.html'> Click here goto Home Page</a></center>");
	 
	      
}
	  public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException ,IOException
		{
		doGet(req,res);

		}
 
	  
 } 