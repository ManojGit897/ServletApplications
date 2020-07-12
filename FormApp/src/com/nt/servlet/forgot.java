package com.nt.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class forgot extends HttpServlet
{

    Connection conn=null;
   PreparedStatement ps=null;
   Statement st=null;
   PreparedStatement ps1=null;
   ResultSet rs=null;
   ResultSet rs1=null;
   
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
	 
  String phone=req.getParameter("fp");
  try {  
  st=conn.createStatement();
  rs=st.executeQuery(" select phonenumber from login where phonenumber="+phone);
  if(rs.next()) {
     
  
 ps=conn.prepareStatement(" select count(*),name,username,password from login where phonenumber=? group by name,username,password");
 if(ps!=null) 
		ps.setString(1,phone);	
			if(ps!=null)	
			rs1=ps.executeQuery();		
		if(rs1.next()) {
		
		 int count=rs1.getInt(1); 
		String name=rs1.getString(2);
		String uname=rs1.getString(3);
		String password=rs1.getString(4); 
	
			pw.println("<center>");
			pw.println("<br> <br><br><body style=bgcolor:'wheat'>");
			pw.println("<h1 style='color:red'  ><b>*******************User deatails***********************");
			pw.println("<br><b> full Name  : "+name);
			pw.println("<br><b> user Name  : "+uname);
			pw.println("<br><b> pass word  : "+password);
			pw.println("<br><br><br> <a href='index.html'> Click here for Signin</a><br><body>");	
                 }//if
		
  }
  else {
	  RequestDispatcher rd=req.getRequestDispatcher("forgot.html");  
	     rd.include(req, res);
	     pw.println("<br><br><br><br><br><br><h3 style='color:red' > Mobile number does not exit in our database table please create your Account</h3>"); 
	     pw.println("<br><br><h2><a href='NewFile.jsp'> Create Account ?</a></h2></center>");  
  }
    
  }//try
    catch (Exception e) {
		e.printStackTrace();
		/* RequestDispatcher rd=req.getRequestDispatcher("forgot.html");  
	     rd.include(req, res);
	     pw.println("<br><br><br><br><br><br><h3 style='color:red' > Mobile number does not exit in our database table please create your Account</h3>"); 
	     pw.println("<br><br><h2><a href='NewFile.jsp'> Create Account ?</a></h2></center>");  */
    }
}//service
public void destroy(){

		try{ 
			ps1.close();
			ps.close();
			conn.close();
			}

			catch(Exception e){
			e.printStackTrace();
			}

			try{
				if(rs!=null) {
			rs.close();
				}
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

