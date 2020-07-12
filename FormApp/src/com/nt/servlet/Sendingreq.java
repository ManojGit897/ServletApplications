package com.nt.servlet;
import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
  
  
public class Sendingreq extends HttpServlet {  
  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
          
    String n=request.getParameter("name");  
    //String p=request.getParameter("userPass");  
          
    if(n.equalsIgnoreCase("link1")){  
        RequestDispatcher rd=request.getRequestDispatcher("accountnurl");  
        rd.forward(request, response);  
    }  
    
}
}
