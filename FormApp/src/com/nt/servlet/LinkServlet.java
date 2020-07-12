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

 public class LinkServlet extends HttpServlet {
	@Override
 public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException ,IOException
	{
	 PrintWriter pw= null;
	 String link=null;
	 Locale locales[]=null;
	 //get prinnt Writer 
     pw=res.getWriter();
	 // set response type 
     res.setContentType("text/html");
	 // read "s1" req param value to  know the hyper link that is clicked
	 link=req.getParameter("s1");
	 if(link.equalsIgnoreCase("link1")){ //  all language 
     //get all available locales 
	  locales=Locale.getAvailableLocales();
		 for(Locale Ic:locales){ pw.println("<body bgcolor='wheat'>");
			 
			 pw.println("<center>");
			 pw.println(Ic.getDisplayLanguage()+"<br>"); }
		 pw.println("</center>");
	 }
	 else if(link.equalsIgnoreCase("link2")){  
		 locales=Locale.getAvailableLocales();
		 for(Locale Ic:locales){
			 pw.println("<body bgcolor='wheat'>");
			 pw.println("<center>");
			 pw.println(Ic.getDisplayCountry()+"<br>"); 
			 pw.println("</center>");
			 pw.println("</body>");
			 }
			 }
	 else{
		 pw.println("<body bgcolor='wheat'>");
		 pw.println("<center>");
		 pw.println("Date and time "+ new Date());
		 pw.println("</center>");
		 pw.println("</body><br>");
		 
		 
	 }
	 pw.println("<body bgcolor='wheat'>");
	 pw.println("<center><br><br><a href='links.html'> Click here goto Home Page</a></center>");
	
	 pw.println("</body>");
	}

@Override
 public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException ,IOException
	{
	doGet(req,res);

	}

 }