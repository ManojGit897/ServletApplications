package com.nt.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet
{

    Connection conn=null;
   PreparedStatement ps=null;
   ResultSet rs=null;
   int count=0;
  
 public void init(ServletConfig config)
{

try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	//nEstablish the connection 
	conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
 }//try

 catch(Exception e){
  e.printStackTrace();
 }//catch
}//init    
 @Override
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
 // PrintWriter pw=res.getWriter();
      PrintWriter pw=res.getWriter();
	 res.setContentType("text/html");
	 
  String user=req.getParameter("name");
 
 
  String pass=req.getParameter("pass");
  
try {
 

 ps=conn.prepareStatement("select count(*) from login where username=? and password=?");
 if(ps!=null) 
		ps.setString(1,user);
		ps.setString(2,pass);
			if(ps!=null)	
			rs=ps.executeQuery();
		if(rs!=null) {
		rs.next();
		count=rs.getInt(1);
		if(count>=1) {
			pw.println("<center>");
			pw.println("<br> <br><br><body style=bgcolor:'wheat'>");
			pw.println("<h1 style='color:red'  ><b>Login Sucessfully");
			pw.println("Mr "+user+" Welcome to Our World</b> </h1><br><br>");
			pw.println("<h3> Search here  what do you want...</center>");
			
			RequestDispatcher rd=req.getRequestDispatcher("Search.html");  
		    rd.include(req, res); 

			}
			
		else {
			
		 RequestDispatcher rd=req.getRequestDispatcher("index.html");  
	     rd.include(req, res);
	     
	     pw.println("<h3> <br> <br> <br> <br> <br> <br> <br><br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br><center><b style='color:red'>**********************  Your username & Password is inncorrect  Please Enter the Valid Password   *********************</h3></b></center>");
		}
		}
	
	
}

catch(Exception e){
e.printStackTrace();
}
pw.close();
}
public void destroy(){
try{
ps.close();
conn.close();
}

catch(Exception e){
e.printStackTrace();
}

try{
rs.close();
conn.close();
}

catch(Exception e){
e.printStackTrace();
}
}

@Override

public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	

  doPost(req,res);

  

}



}//class


