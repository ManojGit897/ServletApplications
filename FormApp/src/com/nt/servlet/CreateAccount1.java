package com.nt.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateAccount1 extends HttpServlet
{

    Connection conn=null;
    Connection conn1=null;
    
   PreparedStatement ps=null;
   Statement st=null;
   ResultSet rs1=null;
   ResultSet rs2=null;
  
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
public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
 // PrintWriter pw=res.getWriter();
      PrintWriter pw=res.getWriter();
	 res.setContentType("text/html");
	 
  String fname=req.getParameter("fn");
 
  
  String ph=req.getParameter("pn");
  
  String username=req.getParameter("un");
  String password=req.getParameter("pass");
  
  int l=ph.length();
  
  if(l>10) {
  	  
  	pw.println(" <center><b style='color:red'><h2> Phone number does not exceed  10 digits(you have entered "+l+" digits)</h2></b></center><br>");
   
 	 RequestDispatcher rd=req.getRequestDispatcher("NewFile.jsp");  
      rd.include(req, res);
  }
  else if(l<10) {
  	pw.println(" <center><b style='color:red'><h2> Phone number must be 10 digits(you have entered "+l+" digits)</h2></b></center><br>");
  	  
    	 RequestDispatcher rd=req.getRequestDispatcher("NewFile.jsp");  
         rd.include(req, res);
  
  }
  
  else {
    
              try {
	  st=conn.createStatement();
    rs1=st.executeQuery(" select phonenumber from login where phonenumber="+ph);
 // rs2=st.executeQuery(" select username from login where username="+"'"+username+"'");
  //ps=conn.prepareStatement("insert into login values(1,?,?,?,?)");
  
      if(rs1.next()){
    	  String uname=rs1.getString(1); 
    	 
    	  pw.println(" <br> <center><i style='color:red'> ");   
    	 pw.println("<h2> phone number is alredy existed..<br>try different Number</i></h2></center>");
    	 RequestDispatcher rd=req.getRequestDispatcher("NewFile.jsp");  
    	     rd.include(req, res); 
    	     pw.println(" <br> <center><i style='color:red'> ");
   	      pw.println("<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>");
   	      
   	 	 pw.println("<h2><a href='home.html'> Click here goto Home Page</a></h2></center>");
   	      
      }  
      else if(true) {
    	  rs2=st.executeQuery(" select username from login where username="+"'"+username+"'");
    	  
      
         if(rs2.next()) {
	   
    	  pw.println(" <br> <center><i style='color:red'> ");
 		 pw.println("<h2> Username is alredy existed.......</i></h2></center>");
 		 RequestDispatcher rd=req.getRequestDispatcher("NewFile.jsp");  
 	     rd.include(req, res);  
 	    pw.println(" <br> <center><i style='color:red'> ");
 	      pw.println("<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>");
 	      
 	 	 pw.println("<h2><a href='home.html'> Click here goto Home Page</a></h2></center>");
    	  
      } //if 
     
       
 
         else {
	   ps=conn.prepareStatement("insert into login values(1,?,?,?,?)");  
    	  ps.setString(1,fname);
    	  ps.setString(2,ph);
    	  ps.setString(3,username);
    	  ps.setString(4,password);

    	 int result=ps.executeUpdate();
    	 if(result!=0)
    	 { 
    	 	pw.println(" <center><b style='color:red'><h2> Your Account Registration is Successfully Done</h2></b></center><br>");
    	 	 pw.println("<h3><center><a href='index.html'><i> Click here goto Login Page</i></a></h3></center>");
    	 	 RequestDispatcher rd=req.getRequestDispatcher("NewFile.jsp");  
    	      rd.include(req, res);
    	      
    	      pw.println(" <br> <center><i style='color:red'> ");
    	      pw.println("<br><br><br><br><br><br><br><br><br><br><br><br><br><br>");
    	      
    	 	 pw.println("<h2><a href='home.html'> Click here goto Home Page</a></h2></center>");
    	      
    	      
    	      
    	 }else {
    	 	pw.println(" <center><b style='color:red'><h2> Your Account Registration is failed please try Again...</h2></b></center><br>");
    	 pw.println("<h3><center><a href='index.html'><i> Click here goto Login Page</i></a></h3></center>");
    	 RequestDispatcher rd=req.getRequestDispatcher("NewFile.jsp");  
    	 rd.include(req, res);

    	 pw.println(" <br> <center><i style='color:red'> ");
    	 pw.println("<br><br><br><br><br><br><br><br><br><br><br><br><br>");

    	 pw.println("<h2><a href='home.html'> Click here goto Home Page</a></h2></center>"); 
    	 }
    	 	
      }//else
         
      }// else if 
  
 pw.close(); 
  
  } //try 
  
  catch(Exception e) {
	  e.printStackTrace();
  }
         
  }//else
   
   
    

 }//service method
    
public void destroy(){
try{
	
ps.close();
conn.close();
rs1.close();
rs2.close();
}

catch(Exception e){
e.printStackTrace();
}
}

@Override

public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	

  doGet(req,res);

  

}



}//class


